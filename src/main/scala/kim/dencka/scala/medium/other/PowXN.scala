package kim.dencka.scala.medium.other

/**
 * Exponentiation by squaring - быстрое возведение в степень.
 *
 * @see
 *   kim.dencka.scala.resources.exponentiation-by-squaring.png
 */
object PowXN extends App {

  def myPow(x: Double, n: Int): Double = {
    def loop(acc: Double, p: Long): Double =
      if (p == 0) 1.0
      else if (p % 2 == 0) loop(acc * acc, p / 2)
      else acc * loop(acc * acc, p / 2)

    if (n >= 0) loop(x, n)
    else loop(1 / x, -n.toLong)
  }

  println(myPow(2.0, 10))

}
