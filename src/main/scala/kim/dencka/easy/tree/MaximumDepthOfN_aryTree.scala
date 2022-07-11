package kim.dencka.easy.tree

object MaximumDepthOfN_aryTree extends App {

  class Node(
      val value: Int,
      val children: List[Node] = List()
  )

  val nt =
    new Node(
      1,
      List(
        new Node(2),
        new Node(
          3,
          List(new Node(6), new Node(7, List(new Node(11, List(new Node(14))))))
        ),
        new Node(4, List(new Node(8, List(new Node(12))))),
        new Node(5, List(new Node(9, List(new Node(13))), new Node(10)))
      )
    )

  val nt2 =
    new Node(
      10,
      List(
        new Node(
          8,
          List(
            new Node(2),
            new Node(
              1,
              List(
                new Node(9),
                new Node(11)
              )
            ),
            new Node(6)
          )
        ),
        new Node(
          5,
          List(
            new Node(7, List(new Node(-1))),
            new Node(8),
            new Node(3),
            new Node(
              4,
              List(
                new Node(2),
                new Node(1),
                new Node(3)
              )
            )
          )
        )
      )
    )

  def maxDepth(root: Node): Int = {
    def run(tree: Node, acc: Int): Int = tree match {
      case null => acc
      case t if t.children.nonEmpty =>
        val l = t.children.map { el =>
          run(el, acc + 1)
        }
        println(s"list: $l, acc: $acc")
        l.max
      case _ => acc
    }
    if (root == null) 0
    else run(root, 1)
  }

  println(maxDepth(nt2))

}
