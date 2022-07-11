package kim.dencka.easy.tree

object Leaf_SimilarTrees extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val bt1 =
    new TreeNode(
      3,
      new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
      new TreeNode(1, new TreeNode(9), new TreeNode(8))
    )

  val bt2 =
    new TreeNode(
      3,
      new TreeNode(5, new TreeNode(6), new TreeNode(7)),
      new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8)))
    )

  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    def run(tree: TreeNode, list: List[Int]): List[Int] = tree match {
      case t if t != null && t.left == null && t.right == null => t.value +: list
      case t if t != null => run(t.left, list) ::: run(t.right, list)
      case null => List()
    }
    val t1 = run(root1, List.empty[Int])
    val t2 = run(root2, List.empty[Int])
    println(s"t1: $t1, t2: $t2")
    t1 == t2
  }

  println(leafSimilar(bt1, bt2))

}
