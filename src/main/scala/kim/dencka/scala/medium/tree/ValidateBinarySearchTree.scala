package kim.dencka.scala.medium.tree

object ValidateBinarySearchTree extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  // FIXME 72/80 test passability
  def isValidBST(root: TreeNode): Boolean = {
    def run(tree: TreeNode): Boolean = tree match {
      case t if t != null && t.left != null && t.right != null =>
        val valid = (t.value > t.left.value) && (t.value < t.right.value)
        if (valid) run(t.left) && run(t.right)
        else false
      case t if t != null && t.left != null && t.right == null =>
        val valid = t.value > t.left.value
        if (valid) run(t.left)
        else false
      case t if t != null && t.left == null && t.right != null =>
        val valid = t.value < t.right.value
        if (valid) run(t.right)
        else false
      case t if t != null && t.left == null && t.right == null =>
        true
    }
    run(root)
  }

}

