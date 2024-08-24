package leetcode

object StringToIntegerATOI extends App {
  def myAtoi(s: String): Int = {
    @annotation.tailrec
    def loop(chars: List[Char], acc: Long, sign: Int): Int =
      chars match {
        case _ if sign * acc > Int.MaxValue => Int.MaxValue
        case _ if sign * acc < Int.MinValue => Int.MinValue
        case h :: tail if h.isDigit         => loop(tail, acc * 10 + h.asDigit, sign)
        case _                              => sign * acc.toInt
      }

    s.trim.toList match {
      case '+' :: tail => loop(tail, 0, 1)
      case '-' :: tail => loop(tail, 0, -1)
      case chars       => loop(chars, 0, 1)
    }
  }

  println(myAtoi("42"))            // 42
  println(myAtoi("   -042"))       // 42
  println(myAtoi("1337c0d3"))      // 1337
  println(myAtoi("0-1"))           // 0
  println(myAtoi("words and 987")) // 0
}
