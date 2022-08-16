package kim.dencka.scala.easy.tree

object SymmetricTree extends App {

  class TreeNode(
      val value: Int = 0,
      val left: TreeNode = null,
      val right: TreeNode = null
  )
  val bt = new TreeNode(
    1,
    new TreeNode(2, null, new TreeNode(4)),
    new TreeNode(2, null, new TreeNode(4))
  )

  def isSymmetric(root: TreeNode): Boolean = {
    def run(tree1: TreeNode, tree2: TreeNode): Boolean = {
      if (tree1 == null && tree2 == null) {
        true
      } else if (
        tree1 != null && tree2 == null || tree1 == null && tree2 != null
      ) {
        false
      } else {
        tree1.value == tree2.value &&
        run(tree1.left, tree2.right) &&
        run(tree1.right, tree2.left)
      }
    }
    if (root == null) {
      true
    } else {
      run(root.right, root.left)
    }
  }

  println(isSymmetric(bt))

}
