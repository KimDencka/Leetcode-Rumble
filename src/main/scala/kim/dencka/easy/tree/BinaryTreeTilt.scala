package kim.dencka.easy.tree

object BinaryTreeTilt extends App {

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

  def findTilt(root: TreeNode): Int = {
    def find(root: TreeNode): Int = {
      def sum(tree: TreeNode): Int =
        if (tree == null) 0
        else tree.value + sum(tree.left) + sum(tree.right)

      if (root == null) 0
      else {
        val left = sum(root.left)
        val right = sum(root.right)
        math.abs(left - right)
      }
    }

    def run(tree: TreeNode, acc: Int): Int = tree match {
      case null => acc
      case t =>
        val tee = find(t)
        val l = run(t.left, acc)
        val r = run(t.right, acc)
        l + r + tee
    }
    run(root, 0)
  }

  println(findTilt(bt))
}
