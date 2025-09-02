package kim.dencka.scala.easy

object MinimumDepthOfBinaryTree extends App {

  class TreeNode(
      val value: Int,
      val left: TreeNode = null,
      val right: TreeNode = null
  )

  def minDepth(root: TreeNode): Int = {
    def run(tree: TreeNode): Int = {
      if (tree == null) {
        0
      } else {
        if (tree.left == null || tree.right == null) {
          val l = run(tree.left)
          val r = run(tree.right)
          math.max(l, r) + 1
        } else {
          val l = run(tree.left)
          val r = run(tree.right)
          math.min(l, r) + 1
        }
      }
    }
    run(root)
  }

}
