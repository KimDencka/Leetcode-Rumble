package kim.dencka.easy.tree

object SameTree extends App {

  class TreeNode(
      val value: Int = 0,
      val left: TreeNode = null,
      val right: TreeNode = null
  )

  val bt1 = new TreeNode(
    1,
    new TreeNode(2, new TreeNode(4), new TreeNode(5)),
    new TreeNode(6)
  )
  val bt2 = new TreeNode(
    1,
    new TreeNode(2, new TreeNode(4), new TreeNode(5)),
    new TreeNode(6)
  )

  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    def run(p: TreeNode, q: TreeNode): Boolean = (Option(p), Option(q)) match {
      case (None, None) => true
      case (Some(t1), Some(t2)) if t1.value == t2.value =>
        run(t1.left, t2.left) && run(t1.right, t2.right)
      case _ => false
    }
    run(p, q)
  }

  println(isSameTree(bt1, bt2))

}
