package kim.dencka.scala.easy.tree

object ConvertSortedArrayToBinarySearchTree extends App {

  class TreeNode(
      val value: Int,
      val left: TreeNode = null,
      val right: TreeNode = null
  )

  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    def run(left: Int, right: Int): TreeNode = (left, right) match {
      case (l, r) if l > r => null
      case (l, r) =>
        val mid = (l + r + 1) / 2
        new TreeNode(nums(mid), run(l, mid - 1), run(mid + 1, r))
    }
    run(0, nums.length - 1)
  }

  println(
    sortedArrayToBST(
      Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    )
  )

//  SCALA STYLE SOLUTION
//  sealed trait TreeNode
//  case object NilNode extends TreeNode
//  case class Node(
//      value: Int,
//      left: TreeNode = NilNode,
//      right: TreeNode = NilNode
//  ) extends TreeNode
//
//  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
//    def run(left: Int, right: Int): TreeNode = (left, right) match {
//      case (l, r) if l > r => NilNode
//      case (l, r) =>
//        val mid = (l + r + 1) / 2
//        Node(nums(mid), run(l, mid - 1), run(mid + 1, r))
//
//    }
//    run(0, nums.length - 1)
//  }
//
//  println(sortedArrayToBST(Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)))

}
