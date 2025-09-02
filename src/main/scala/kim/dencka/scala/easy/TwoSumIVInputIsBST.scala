package kim.dencka.scala.easy

object TwoSumIVInputIsBST extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  def findTarget(root: TreeNode, k: Int): Boolean = {
    def toArray(tree: TreeNode): Array[Int] =
      if (tree == null) Array()
      else Array(tree.value) ++ toArray(tree.left) ++ toArray(tree.right)

    val arr = toArray(root)

    def twoSum(nums: Array[Int]): Array[Int] = {
      for {
        i <- nums.indices
        j <- i + 1 until nums.length
      } if (nums(i) + nums(j) == k) {
        return Array(i, j)
      }
      Array()
    }

    val res = twoSum(arr)

    if (res.nonEmpty) true
    else false

  }



}
