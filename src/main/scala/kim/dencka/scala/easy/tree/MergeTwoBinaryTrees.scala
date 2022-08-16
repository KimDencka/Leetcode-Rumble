package kim.dencka.scala.easy.tree
import scala.util.Random

object MergeTwoBinaryTrees extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val bt1 =
    new TreeNode(
      1,
      new TreeNode(3, new TreeNode(5)),
      new TreeNode(2)
    )

  val bt2 =
    new TreeNode(
      2,
      new TreeNode(1, right = new TreeNode(4)),
      new TreeNode(3, right = new TreeNode(7))
    )

  val bt3 =
    new TreeNode(
      1,
      right = new TreeNode(
        1,
        right = new TreeNode(
          1,
          right = new TreeNode(
            1,
            right = new TreeNode(
              1,
              right = new TreeNode(
                1,
                new TreeNode(2)
              )
            )
          )
        )
      )
    )

  val bt4 =
    new TreeNode(
      1,
      right = new TreeNode(
        1,
        right = new TreeNode(
          1,
          right = new TreeNode(
            1,
            right = new TreeNode(
              1,
              right = new TreeNode(
                1,
                right = new TreeNode(
                  1,
                  right = new TreeNode(
                    1,
                    right = new TreeNode(
                      1,
                      right = new TreeNode(
                        1,
                        right = new TreeNode(1, new TreeNode(2))
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )

  def mergeTrees(root1: TreeNode, root2: TreeNode): TreeNode =
    if (root1 == null) root2
    else if (root2 == null) root1
    else new TreeNode(
      value = root1.value + root2.value,
      left = mergeTrees(root1.left, root2.left),
      right = mergeTrees(root1.right, root2.right)
    )



  println(mergeTrees(bt3, bt4))

}
