package kim.dencka.scala.easy.tree

object N_aryTreePreorderTraversal extends App {

  class Node(
    val value: Int,
    var children: List[Node] = List()
  )

  val n1 =
    new Node(
      1,
      List(new Node(3, List(new Node(5), new Node(6))), new Node(2), new Node(4))
    )

  val n2 =
    new Node(
      1,
      List(
        new Node(2),
        new Node(3, List(new Node(6), new Node(7, List(new Node(11), new Node(14))))),
        new Node(4, List(new Node(8), new Node(12))),
        new Node(5, List(new Node(9, List(new Node(13))), new Node(10)))
      )
    )

  def preorder(root: Node): List[Int] =
    if (root == null) List()
    else List(root.value) ++ root.children.flatMap(preorder)

  println(preorder(n1))
  println(preorder(n2))


}
