package kim.dencka.scala.easy

object DiameterOfBinaryTree extends App {

  class TreeNode(
      val value: Int,
      val left: TreeNode = null,
      val right: TreeNode = null
  )

  val bt1 =
    new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), new TreeNode(5)),
      new TreeNode(3)
    )

  val bt2 = new TreeNode(
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

  val bt3 =
    new TreeNode(
      1,
      new TreeNode(
        2,
        new TreeNode(
          4,
          new TreeNode(6),
          new TreeNode(7, new TreeNode(9, right = new TreeNode(12)))
        ),
        new TreeNode(
          5,
          right = new TreeNode(
            8,
            new TreeNode(10),
            new TreeNode(11, new TreeNode(13))
          )
        )
      ),
      new TreeNode(3)
    )

  def diameterOfBinaryTree(root: TreeNode): Int = recur(root)._1
  // (diameter, depth)
  def recur(tree: TreeNode): (Int, Int) = tree match {
    case null => (0, 0)
    case node =>
      val (dl, hl) = recur(node.left)
      val (dr, hr) = recur(node.right)
      println(s"tree: ${tree.value}, dl: $dl, dr: $dr, hl: $hl, hr: $hr")
      (dl.max(dr).max(hl + hr), hl.max(hr) + 1)
  }

  println(diameterOfBinaryTree(bt1))
  println(diameterOfBinaryTree(bt2))
  println(diameterOfBinaryTree(bt3))

}
