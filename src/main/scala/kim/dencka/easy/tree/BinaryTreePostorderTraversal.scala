package kim.dencka.easy.tree

object BinaryTreePostorderTraversal extends App {

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

  def postorderTraversal(root: TreeNode): List[Int] = {
    if (root == null) List()
    else
      postorderTraversal(root.left) ++ postorderTraversal(root.right) ++ List(
        root.value
      )
  }

  println(postorderTraversal(bt))

}
