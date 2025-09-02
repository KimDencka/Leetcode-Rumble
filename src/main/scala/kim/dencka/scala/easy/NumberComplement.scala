package kim.dencka.scala.easy

object NumberComplement extends App {

  def findComplement(num: Int): Int = {
    val builder = new StringBuilder()
    num.toBinaryString.foreach(ch => if (ch == '1') builder.append('0') else builder.append('1'))
    Integer.parseInt(builder.toString(), 2)
  }

  // super solution; bitwise operators
  // import scala.math.BigInt.int2bigInt
  //def findComplement(num: Int): Int = {
  //  val bitLength = num.bitLength
  //  val mask      = (1 << bitLength) - 1
  //  ~num & mask
  //}
  // 
  // another solution: ~num & (Integer.highestOneBit(num) - 1)

  println(findComplement(5))

}
