package kim.dencka.payloads

object GraphStructure {

  case class Node(val value: Int) {
    var neighbors: List[Node] = List()
  }

}
