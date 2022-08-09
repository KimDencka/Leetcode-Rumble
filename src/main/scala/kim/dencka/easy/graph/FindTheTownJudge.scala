package kim.dencka.easy.graph

object FindTheTownJudge extends App {

  val g = Array(Array(5, 2), Array(3, 2), Array(4, 2), Array(1, 2))

  def findJudge(n: Int, trust: Array[Array[Int]]): Int = {
    val place = Array.fill(n)(0)
    trust.foreach { t =>
      val from = t(0) - 1
      val to = t(1) - 1

      place(from) -= 1
      place(to) += 1
    }
    val judge = place.indexWhere(_ == n - 1)
    if (judge >= 0) judge + 1 else judge
  }

  println(findJudge(5, g))

}
