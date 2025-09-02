package kim.dencka.scala.medium

object BinaryTreeRightSideView extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val bt1 =
    new TreeNode(
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

  val bt2 =
    new TreeNode(
      1,
      new TreeNode(
        2,
        new TreeNode(
          3,
          new TreeNode(
            4,
            new TreeNode(
              5,
              new TreeNode(
                6,
                new TreeNode(8),
                new TreeNode(9)
              ),
              new TreeNode(7)
            )
          )
        )
      )
    )

  // KIM_INFO NOT WORKING
  def rightSideView(root: TreeNode): List[Int] = {
    def run(tree: TreeNode, isRight: Boolean): List[Int] =
      if (tree == null) List()
      else if (tree.right != null)
        if (isRight) List(tree.value) ++ run(tree.right, isRight = true)
        else run(tree.right, isRight = true)
      else if (tree.right != null && tree.left != null)
        if (isRight) List(tree.value) ++ run(tree.right, isRight = true) ++ run(tree.left, isRight = false)
        else run(tree.right, isRight = false) ++ run(tree.left, isRight = false)
      else if (tree.right == null) List(tree.value) ++ run(tree.left, isRight = true)
      else if (isRight) List(tree.value) ++ run(tree.right, isRight = true) ++ run(tree.left, isRight = false)
      else run(tree.right, isRight = true) ++ run(tree.left, isRight = false)

    run(root, isRight = true)
  }

  println(rightSideView(bt2))
  // expected [1,2,3,4,5,7,9]
  // reality [[1,2,3,4,5,7]

}

class BinaryTreeRightSideView
