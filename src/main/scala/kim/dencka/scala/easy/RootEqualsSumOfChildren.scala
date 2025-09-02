package kim.dencka.scala.easy

object RootEqualsSumOfChildren extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  def checkTree(root: TreeNode): Boolean = {
    root.value == (root.left.value + root.right.value)
  }

}
