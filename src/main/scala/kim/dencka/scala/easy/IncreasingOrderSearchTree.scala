package kim.dencka.scala.easy

object IncreasingOrderSearchTree extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val bst =
    new TreeNode(
      5,
      new TreeNode(3, new TreeNode(2, new TreeNode(1)), new TreeNode(4)),
      new TreeNode(6, right = new TreeNode(8, new TreeNode(7), new TreeNode(9)))
    )

  val bst2 =
    new TreeNode(
      8,
      new TreeNode(
        4,
        new TreeNode(2, new TreeNode(1), new TreeNode(3)),
        new TreeNode(6, new TreeNode(5), new TreeNode(7))
      ),
      new TreeNode(
        12,
        new TreeNode(10, new TreeNode(9), new TreeNode(11)),
        new TreeNode(14, new TreeNode(13), new TreeNode(15))
      )
    )

  // TODO I SHOULD TO RESOLVE
  // TOO LONG SOLUTION (I THINK). TWO ITERATIONS

  def increasingBST(root: TreeNode): TreeNode = {
    def toList(tree: TreeNode): List[Int] =
      if (tree == null) List()
      else toList(tree.left) ++ List(tree.value) ++ toList(tree.right)
    val list = toList(root).reverse

    @annotation.tailrec
    def run(list: List[Int], acc: TreeNode): TreeNode = list match {
      case Nil => acc
      case h :: tail => run(tail, new TreeNode(h, null, acc))
    }
    run(list.tail, new TreeNode(list.head))
  }

//  println(increasingBST(bst))
  println(increasingBST(bst2))
}

class IncreasingOrderSearchTree
