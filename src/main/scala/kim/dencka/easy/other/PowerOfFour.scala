package kim.dencka.easy.other

object PowerOfFour extends App {

//  def isPowerOfFour(n: Int): Boolean = {

//  }

  def isPowerOfFour(n: Int): Boolean = {
    val exponent: Double = math.log10(n) / math.log10(4.0)
    println(s"-- $exponent")
    println(n.toDouble/4.0)
    if (exponent - math.round(exponent) == 0) true
    else false
  }

  println(isPowerOfFour(16))
  println(isPowerOfFour(5))
  println(isPowerOfFour(64))
  println(isPowerOfFour(512))
  println(isPowerOfFour(1024))

}
