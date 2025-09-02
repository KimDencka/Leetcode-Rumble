package kim.dencka.scala.easy

object ValidPerfectSquare extends App {

  def isPerfectSquare(num: Int): Boolean = {
    @annotation.tailrec
    def run(low: Int, high: Int): Boolean = {
      val mid = low + (high - low) / 2
      if (low > high) false
      else if (mid * mid == num) true
      else if (mid > num / mid) run(low, mid - 1)
      else run(mid + 1, high)
    }
    run(1, num)
  }

  println(isPerfectSquare(16))
  println(isPerfectSquare(20))
  println(isPerfectSquare(2147483647))

}
