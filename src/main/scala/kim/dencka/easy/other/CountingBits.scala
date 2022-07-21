package kim.dencka.easy.other

object CountingBits extends App {

  def countBits(n: Int): Array[Int] = {
    @annotation.tailrec
    def hammingWeight(x: Int, weight: Int = 0): Int =
      if (x != 0) hammingWeight(x & x - 1, weight + 1)
      else weight

    (for (i <- 0 to n) yield hammingWeight(i)).toArray
  }
}
