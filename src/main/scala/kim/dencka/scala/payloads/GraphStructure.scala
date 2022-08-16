package kim.dencka.scala.payloads

object GraphStructure {

  case class Node(val value: Int) {
    var neighbors: List[Node] = List()
  }

}
