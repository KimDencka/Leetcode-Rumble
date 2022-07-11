package kim.dencka.easy.tree

object CousinsInBinaryTree extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val bt = new TreeNode(
    1,
    new TreeNode(
      2,
      new TreeNode(4, new TreeNode(8), new TreeNode(9)),
      new TreeNode(5, new TreeNode(10), new TreeNode(11))
    ),
    new TreeNode(
      3,
      new TreeNode(6, new TreeNode(12), new TreeNode(13)),
      new TreeNode(7, new TreeNode(14), new TreeNode(15))
    )
  )

  def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
    def run(tree: TreeNode, level: Int, num: Int, parent: Int): (Int, Int) = tree match {
      case null => (0, 0)
      case t if t.value == num => (level, parent)
      case t =>
        val l = run(t.left, level + 1, num, t.value)
        if (l == (0, 0)) run(t.right, level + 1, num, t.value)
        else l
    }
    val n1 = run(root, 0, x, 0)
    val n2 = run(root, 0, y, 0)
    println(s"$n1 == $n2")
    if (n1._1 > 1 && n2._1 > 1 && n1._2 != n2._2) n1._1 == n2._1
    else false
  }

  println(isCousins(bt, 2, 3)) // should be false
  println(isCousins(bt, 5, 7)) // should be true
  println(isCousins(bt, 10, 7)) // should be false
  println(isCousins(bt, 12, 15)) // should be true

}
