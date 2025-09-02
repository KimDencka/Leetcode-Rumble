package kim.dencka.scala.medium

object ValidateBinarySearchTree extends App {

  val tree = new TreeNode(1, new TreeNode(1))

  def isValidBST(root: TreeNode): Boolean = {
    var prev: Option[Int] = None

    def inorder(tree: TreeNode): Boolean =
      Option(tree) match {
        case None                            => true
        case Some(cur) if !inorder(cur.left) => false
        case Some(cur)                       =>
          prev match {
            case Some(pr) if cur.value <= pr => false
            case _                           =>
              prev = Some(cur.value)
              inorder(tree.right)
          }
      }
    inorder(root)
  }

  println(isValidBST(tree)) // false

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int      = _value
    var left: TreeNode  = _left
    var right: TreeNode = _right
  }

}
