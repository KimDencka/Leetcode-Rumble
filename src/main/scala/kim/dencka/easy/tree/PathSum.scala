package kim.dencka.easy.tree

object PathSum extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val t1 = new TreeNode(
    5,
    new TreeNode(
      4,
      new TreeNode(11, new TreeNode(7), new TreeNode(2))
    ),
    new TreeNode(8, new TreeNode(13), new TreeNode(4, right = new TreeNode(1)))
  )

  val t2 = new TreeNode(1, new TreeNode(2))
  val t3 = new TreeNode(1)
  val t4 = new TreeNode(
    0,
    new TreeNode(1),
    new TreeNode(1)
  )
  val t5 = new TreeNode(
    1,
    new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5))))
  )

  def hasPathSum(root: TreeNode, targetSum: Int): Boolean =
    if (root == null) {
      false
    }
    else if (root.left == null && root.right == null) {
      root.value == targetSum
    }
    else {
      def run(tree: TreeNode, cnt: Int): Boolean = tree match {
        case t if t == null => cnt == targetSum
        case t if t.right == null => run(tree.left, cnt + t.value)
        case t if t.left == null => run(tree.right, cnt + t.value)
        case t =>
          val l = run(t.left, cnt + tree.value)
          val r = run(t.right, cnt + tree.value)
          println(s"cnt: $cnt, tree: ${t.value}, l: $l, r: $r")
          if (cnt == 0 && t.right == null) {
            l
          }
          else if (cnt == 0 && t.left == null) {
            r
          }
          else {
            r || l
          }
      }
      run(root, 0)
    }

  println(hasPathSum(t5, 6))

}
