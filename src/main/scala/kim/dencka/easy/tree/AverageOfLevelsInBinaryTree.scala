package kim.dencka.easy.tree

object AverageOfLevelsInBinaryTree extends App {

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

  // TODO NEED TO SOLVE
  def averageOfLevels(root: TreeNode): Array[Double] = {
    ???
  }

//  println(averageOfLevels(bt).toList)
}

class AverageOfLevelsInBinaryTree
