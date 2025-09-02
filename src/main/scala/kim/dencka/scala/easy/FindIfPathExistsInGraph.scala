package kim.dencka.scala.easy

import scala.collection.immutable.Queue

object FindIfPathExistsInGraph extends App {

  val edges = Array(Array(0, 1), Array(1, 2), Array(2, 0))
  val edges2 = Array(Array(0, 1), Array(0, 2), Array(3, 5), Array(5, 4), Array(4, 3))

  def validPath(n: Int, edges: Array[Array[Int]], start: Int, destination: Int): Boolean =
    if (start == destination) true
    else if (edges.isEmpty) false
    else bfs(build(edges), start, destination)

  def bfs(map: Map[Int, List[Int]], start: Int, dest: Int): Boolean = {
    @annotation.tailrec
    def go(queue: Queue[Int], seen: Set[Int]): (Queue[Int], Set[Int]) =
      if (queue.isEmpty) (queue, seen)
      else {
        val (node, restQueue) = queue.dequeue
        val updatedSet = seen + node
        val (q, s) = map(node).foldLeft(restQueue, updatedSet) { case ((qu, se), n) =>
          val q2 = if (!se.contains(n)) qu.enqueue(n) else qu
          (q2, se)
        }
        go(q, s)
      }
    val (_, seen) = go(Queue.empty[Int].enqueue(start), Set.empty[Int])
    if (seen.contains(start) && seen.contains(dest)) true else false
  }

  def build(edges: Array[Array[Int]]): Map[Int, List[Int]] =
    edges.foldLeft(Map.empty[Int, List[Int]]) { (acc, edge) =>
      appendMap(appendMap(acc, edge(0), edge(1)), edge(1), edge(0))
    }

  def appendMap(map: Map[Int, List[Int]], k: Int, v: Int): Map[Int, List[Int]] =
    map.get(k) match {
      case Some(list) =>
        val r = list :+ v
        map + (k -> r)
      case None => map + (k -> List(v))
    }

  println(validPath(3, edges, 0, 2))
  println(validPath(6, edges2, 0, 5))
}
