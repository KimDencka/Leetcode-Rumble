package kim.dencka.scala.easy

object SubtreeOfAnotherTree extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val bt1 =
    new TreeNode(
      3,
      new TreeNode(4, new TreeNode(1), new TreeNode(2)),
      new TreeNode(5)
    )
  val bt2 =
    new TreeNode(4, new TreeNode(1), new TreeNode(2))

  val bt3 = new TreeNode(
    3,
    new TreeNode(4, new TreeNode(1)),
    new TreeNode(5, new TreeNode(2))
  )
  val bt4 = new TreeNode(
    3,
    new TreeNode(1),
    new TreeNode(2)
  )

    def isSameTree(p: TreeNode, q: TreeNode): Boolean = (p, q) match {
      case (null, null) => true
      case (_, null) | (null, _) => false
      case (p, q) => (p.value == q.value) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    def isSubtree(root: TreeNode, subRoot: TreeNode): Boolean = (root, subRoot) match {
      case (_, null) | (null, _) => false
      case (_, _) => isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }


  println(isSubtree(bt1, bt2))
  println(isSubtree(new TreeNode(1, new TreeNode(1)), new TreeNode(1)))
  println(isSubtree(bt3, bt4))
}
