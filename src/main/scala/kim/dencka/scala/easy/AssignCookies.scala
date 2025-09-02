package kim.dencka.scala.easy

object AssignCookies extends App {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    @annotation.tailrec
    def run(arr1: Array[Int], arr2: Array[Int], cnt: Int): Int = (arr1, arr2) match {
      case (a1, a2) if a1.isEmpty || a2.isEmpty => cnt
      case (a1, a2) if a1.head <= a2.head => run(arr1.tail, arr2.tail, cnt + 1)
      case (a1, a2) => run(a1, a2.tail, cnt)
    }
    run(g.sorted, s.sorted, 0)
  }

//  def findContentChildren2(g: Array[Int], s: Array[Int]): Int =
//    s.sorted
//      .foldLeft((0, g.sorted.toList)) { case (res @ (content, children), cookie) =>
//        children.headOption.filter(_ <= cookie).map(_ => (content + 1, children.tail)).getOrElse(res)
//      }._1

  println(findContentChildren(Array(1, 2), Array(2, 3)))
  println(findContentChildren(Array(1, 1, 2, 2, 3, 3), Array(1, 2, 3)))
  println(findContentChildren(Array(10, 9, 8, 7), Array(5, 6, 7, 8)))

}
