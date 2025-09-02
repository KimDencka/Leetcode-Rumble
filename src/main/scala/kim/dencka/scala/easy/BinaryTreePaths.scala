package kim.dencka.scala.easy

object BinaryTreePaths extends App {

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

  def binaryTreePaths(root: TreeNode): List[String] = {
    def run(tree: TreeNode, str: String, acc: List[String]): List[String] =
      tree match {
        case null                 => acc :+ str
        case t if t.right == null => run(t.left, str + s"${t.value}", acc)
        case t if t.left == null  => run(t.right, str + s"${t.value}", acc)
        case t =>
          run(t.left, str + s"${t.value}->", acc) ++
            run(t.right, str + s"${t.value}->", acc)
      }
    run(root, "", List())
  }

  println(binaryTreePaths(bt))

}
