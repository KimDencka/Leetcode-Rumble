package kim.dencka.scala.easy

object PowerOfTwo extends App {

  def isPowerOfTwo(n: Int): Boolean =
    if (n <= 0) false else (n & (n - 1)) == 0

//  def isPowerOfTwo2(n: Int): Boolean = {
//    @annotation.tailrec
//    def hammingWeight(x: Int, weight: Int = 0): Int =
//      if (x != 0) hammingWeight(x & x - 1, weight + 1) else weight
//
//    val ones = hammingWeight(n)
//    if (n < 0) false
//    else ones == 1
//  }

//  def isPowerOfFour(n: Int): Boolean = {
//    val exponent: Double = math.log10(n) / math.log10(2.0)
//    if (exponent - math.round(exponent) == 0) true
//    else false
//  }

}
