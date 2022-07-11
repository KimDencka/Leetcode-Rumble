package kim.dencka.easy.tree
import kim.dencka.easy.tree.BinaryTreePostorderTraversal.TreeNode

object ConstructStringFromBinaryTree extends App {

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

  def tree2str(root: TreeNode): String = {
    if (root != null && root.left == null && root.right == null) root.value.toString
    else if (root != null && root.left == null) root.value + s"()(${tree2str(root.right)})"
    else if (root != null && root.right == null) root.value + s"(${tree2str(root.left)})"
    else root.value.toString + s"(${tree2str(root.left)})" + s"(${ tree2str(root.right)})"
  }

  println(tree2str(bt))

}
