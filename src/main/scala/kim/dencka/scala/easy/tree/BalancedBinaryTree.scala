package kim.dencka.scala.easy.tree

object BalancedBinaryTree extends App {

  class TreeNode(
      val value: Int = 0,
      val left: TreeNode = null,
      val right: TreeNode = null
  )

  val tr1 = new TreeNode(
    3,
    new TreeNode(9),
    new TreeNode(20, new TreeNode(15), new TreeNode(7))
  )
  val tr2 = new TreeNode(
    1,
    new TreeNode(
      2,
      new TreeNode(3, new TreeNode(4), new TreeNode(4)),
      new TreeNode(3)
    ),
    new TreeNode(2)
  )

  def isBalanced(root: TreeNode): Boolean = {
    def helper(root: TreeNode): (Int, Boolean) = {
      // empty tree is balanced
      if (root == null) {
        return (0, true)
      }

      val (leftHeight, isLeftBalanced) = helper(root.left)
      val (rightHeight, isRightBalanced) = helper(root.right)
      val height = scala.math.max(leftHeight, rightHeight) + 1
      println(
        s"h: $height, lh: $leftHeight, rh: $rightHeight, root: ${root.value}"
      )
      val heightDiff = scala.math.abs(leftHeight - rightHeight) <= 1
      val isBalanced = isLeftBalanced && isRightBalanced && heightDiff
      (height, isBalanced)
    }
    helper(root)._2
  }

  println(isBalanced(tr1))

}
