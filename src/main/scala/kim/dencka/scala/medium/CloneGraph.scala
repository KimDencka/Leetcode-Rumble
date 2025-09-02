package kim.dencka.scala.medium

import kim.dencka.scala.payloads.GraphStructure._

object CloneGraph extends App {

  val g = new Node(1) {
    neighbors = List(
      new Node(2) {
        neighbors = List(new Node(3), new Node(1))
      },
      new Node(4) {
        neighbors = List(new Node(1), new Node(3))
      }
    )
  }

  import scala.collection._
  def cloneGraph(n: Node): Node =
    if (n == null) n else run(n, mutable.Map[Node, Node]())

  def run(n: Node, oldToNew: mutable.Map[Node, Node]): Node =
    if (oldToNew.contains(n)) n
    else {
      oldToNew += n -> new Node(n.value)
      for (nei <- n.neighbors) {
        run(nei, oldToNew)
        val newNode = oldToNew(n)
        newNode.neighbors = newNode.neighbors :+ oldToNew(nei)
      }
      oldToNew(n)
    }

  val res1 = cloneGraph(g)
  val res2 = g

  println(res1)
  println(res2)
  println(res1.neighbors)
  println(res2.neighbors)
  println(res1.neighbors.map(_.neighbors))
  println(res2.neighbors.map(_.neighbors))
}
