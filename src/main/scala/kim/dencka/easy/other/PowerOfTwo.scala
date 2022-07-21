package kim.dencka.easy.other

object PowerOfTwo extends App {

  def isPowerOfTwo(n: Int): Boolean = {
    if (n<=0) false else (n & (n-1)) == 0
  }

//  def isPowerOfTwo2(n: Int): Boolean = {
//    @annotation.tailrec
//    def hammingWeight(x: Int, weight: Int = 0): Int =
//      if (x != 0) hammingWeight(x & x - 1, weight + 1) else weight
//
//    val ones = hammingWeight(n)
//    if (n < 0) false
//    else ones == 1
//  }

}
