package kim.dencka.scala.easy

object FindModeInBinarySearchTree extends App {

  class TreeNode(
      val value: Int,
      val left: TreeNode = null,
      val right: TreeNode = null
  )

  val bt = new TreeNode(
    5,
    new TreeNode(2, new TreeNode(2), new TreeNode(2)),
    new TreeNode(9, new TreeNode(9), new TreeNode(9))
  )

  def findMode(root: TreeNode) = {
    def find(root: TreeNode): Array[Int] = {
      if (root == null) Array()
      else Array(root.value) ++ find(root.left) ++ find(root.right)
    }
    val arr = find(root)
    val max = arr.groupBy(identity).maxBy(_._2.length)._2
    arr
      .groupBy(identity)
      .values
      .filter(_.length == max.length)
      .flatten
      .toArray
      .distinct
  }

  val res = findMode(bt).toList
  println(res)

}
