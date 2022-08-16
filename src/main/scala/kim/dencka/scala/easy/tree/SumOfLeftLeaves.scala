package kim.dencka.scala.easy.tree

object SumOfLeftLeaves extends App {

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

  def sumOfLeftLeaves(root: TreeNode): Int = {
    def run(tree: TreeNode, isLeft: Boolean, acc: Int): Int = tree match {
      case null                                           => acc
      case t if isLeft & t.right == null & t.left == null => acc + t.value
      case t =>
        run(t.left, isLeft = true, acc) + run(t.right, isLeft = false, 0)
    }
    run(root, isLeft = false, 0)
  }

  println(sumOfLeftLeaves(bt))

}
