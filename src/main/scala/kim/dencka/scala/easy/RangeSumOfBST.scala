package kim.dencka.scala.easy

object RangeSumOfBST extends App {

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

  // TODO I SHOULD TO RESOLVE
  // I THINK IT IS TOO LONG SOLUTION

  def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
    def run(tree: TreeNode): List[Int] =
      if (tree == null) List()
      else run(tree.left) ++ List(tree.value) ++ run(tree.right)

    val list = run(root)

    list.filter(el => el <= high && el >= low).sum
  }

  println(rangeSumBST(bt, 1, 15))
}

class RangeSumOfBST
