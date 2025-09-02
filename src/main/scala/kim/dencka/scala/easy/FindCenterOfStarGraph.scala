package kim.dencka.scala.easy

object FindCenterOfStarGraph extends App {

  def findCenter(edges: Array[Array[Int]]): Int = {
    val res = edges.head ++ edges.last
    res.groupBy(identity).values.filter(_.length == 2).head.head
  }

  findCenter(Array(Array(1, 2), Array(3, 2)))
}
