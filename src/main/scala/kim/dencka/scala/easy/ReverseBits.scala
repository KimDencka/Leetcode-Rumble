package kim.dencka.scala.easy

object ReverseBits extends App {

  def reverseBits(x: Int): Int = {
    def toDec(str: String): Long =
      str.foldRight(0d, 0) { case (num, (acc, pow)) =>
        println(s"num: $num, pow: $pow")
        if (num == '0') (acc, pow + 1)
        else (acc + math.pow(2, pow), pow + 1)
      }._1.toLong

    val b = x.toBinaryString
    val num =
      if (b.length < 32) ("0" * (32 - b.length)) + b
      else b

    println(num.reverse)

    toDec(num.reverse).toInt

  }

  // KIM_INFO THERE ARE SOLUTIONS FROM DISCUSSION (TAKE INTO ACCOUNT)

  // def reverseBits(x: Int): Int = {
  //    @annotation.tailrec
  //    def reverse(in: Int, n: Int = 32, out: Int = 0): Int =
  //      if (n == 0) out
  //      else reverse(in >>> 1, n - 1, (out << 1) | (in & 1)) //magic
  //    reverse(x)
  //  }

  // def reverseBits(x: Int): Int = {
  //   (0 to 31)
  //     .map(i => ((x >> i) & 1) << (31 - i))
  //     .sum
  // }

  // def reverseBits(x: Int): Int = {
  //   x.toBinaryString.reverse.padTo(32,'0').foldLeft(0)((p,n) => (p << 1) + (n - '0'))
  // }

  println(reverseBits(43261596))
  println(reverseBits(-3))
}
