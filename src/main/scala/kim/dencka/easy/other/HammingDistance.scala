package kim.dencka.easy.other

object HammingDistance extends App {

  def hammingDistance(x: Int, y: Int): Int = hammingWeight(x ^ y)

  @annotation.tailrec
  def hammingWeight(x: Int, weight: Int = 0): Int =
    if (x != 0) hammingWeight(x & x - 1, weight + 1)
    else weight

}
