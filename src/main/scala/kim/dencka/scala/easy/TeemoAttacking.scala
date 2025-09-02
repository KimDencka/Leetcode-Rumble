package kim.dencka.scala.easy

object TeemoAttacking extends App {

  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int =
    timeSeries.tail.foldLeft(duration, timeSeries.head) { case ((acc, prev), num) =>
      (acc + math.min(num - prev, duration), num)
    }._1

  println(findPoisonedDuration(Array(1, 3, 5, 9, 15), 4))
  println(findPoisonedDuration(Array(1, 2), 2))
  println(findPoisonedDuration(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 4))

}
