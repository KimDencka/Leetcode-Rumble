package kim.dencka.scala.easy.tree

object MaximumDepthOfBinaryTree extends App {

  class TreeNode(
      val value: Int = 0,
      val left: TreeNode = null,
      val right: TreeNode = null
  )

  val bt = new TreeNode(
    3,
    new TreeNode(9),
    new TreeNode(
      20,
      new TreeNode(15),
      new TreeNode(9, new TreeNode(6, new TreeNode(2, new TreeNode(10))))
    )
  )

  def maxDepth(root: TreeNode): Int = {
    def run(tree1: TreeNode, tree2: TreeNode, depth1: Int, depth2: Int): Int = {
      if (tree1 == null && tree2 == null) {
        println(s"0: depth1: $depth1, depth2: $depth2")
        if (depth1 > depth2) depth1
        else depth2
      } else if (tree1 == null) {
        println(s"1: depth1: $depth1, depth2: $depth2, tree2: ${tree2.value}")
        run(tree2.left, tree2.right, depth1, depth2 + 1)
      } else if (tree2 == null) {
        println(s"2: depth1: $depth1, depth2: $depth2, tree1: ${tree1.value}")
        run(tree1.left, tree1.right, depth1 + 1, depth2)
      } else {
        println(
          s"3: depth1: $depth1, depth2: $depth2, tree1: ${tree1.value}, tree2: ${tree2.value}"
        )
        run(tree1.left, tree2.left, depth1 + 1, depth2 + 1)
        run(tree1.right, tree2.right, depth1 + 1, depth2 + 1)
      }
    }
    if (root == null) {
      0
    } else {
      run(root.left, root.right, 1, 1)
    }
  }

  def maxDepth2(root: TreeNode): Int = {
    def run(tree: TreeNode, depth: Int): Int = {
      if (tree == null) {
        depth
      } else {
        val x1 = run(tree.left, depth + 1)
        println(s"1: x1: $x1, depth: $depth, tree: ${tree.value}")
        val x2 = run(tree.right, depth + 1)
        if (x1 > x2) x1
        else x2
      }
    }
    run(root, 0)
  }

  println(maxDepth2(bt))

}
