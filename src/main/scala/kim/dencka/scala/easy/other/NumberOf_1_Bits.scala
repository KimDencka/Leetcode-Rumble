package kim.dencka.scala.easy.other

object NumberOf_1_Bits extends App {

  def hammingWeight(n: Int): Int =
    n.toBinaryString.count(_ == '1')

  // KIM_INFO THERE ARE SOLUTIONS FROM DISCUSSION

//    @annotation.tailrec
//    def hammingWeight(n: Int, weight: Int = 0): Int =
//      if (n != 0) hammingWeight(n & n - 1, weight + 1) else weight

  // ------------------------------------------

  //  object Operations {
  //  /*
  //     a functional approach to computing the amount of 1 bits found within an arbitrary unsigned value. a call to fold loops through indices 0 to 31 inclusive. the declared range signifies the range of a binary string of length 32, ie. 2^31. With each iteration, we assert on the ith bit (through bit shifting): is there presence of a 1? If so, add to count. Due to fold's functional nature, `count + (expression)` additionally acts as the return value at each iterative step -- building to the eventual return value.
  //  */
  //    def countBits(integer: Int): Int =
  //      (0 to 31).fold(0)((count, i) => count + ((integer >> i) & 1))
  //  }
  //  def hammingWeight(n: Int): Int = {
  //    Operations.countBits(n)
  //  }

  // ------------------------------------------

  // def hammingWeight(n: Int): Int =
  //  (0 to 31).foldLeft(0)((count, shift) => count + (n >> shift & 1))
  //def hammingWeight(n: Int): Int =
  //  (0 to 31).map(shift => n >> shift & 1).sum
}
