package kim.dencka.scala.easy

object UnivaluedBinaryTree extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val bt1 =
    new TreeNode(
      1,
      new TreeNode(1),
      new TreeNode(2)
    )

  val bt2 =
    new TreeNode(
      1,
      new TreeNode(1),
      new TreeNode(1)
    )
  // TODO I SHOULD TO RESOLVE
  // NOT THE BEST SOLUTION (I THINK)

  def isUnivalTree(root: TreeNode): Boolean = {
    def run(tree: TreeNode): Set[Int] =
      if (tree == null) Set()
      else Set(tree.value) ++ run(tree.left) ++ run(tree.right)
    val set = run(root)
    set.size == 1
  }

  println(isUnivalTree(bt1))
  println(isUnivalTree(bt2))

}

class UnivaluedBinaryTree
