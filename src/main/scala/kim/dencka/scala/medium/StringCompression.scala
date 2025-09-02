package kim.dencka.scala.medium

object StringCompression extends App {

  def compress(chars: Array[Char]): Int =
    if (chars.length == 1) 1
    else {
      @annotation.tailrec
      def loop(l: Int, r: Int, acc: StringBuilder): StringBuilder =
        if (r >= chars.length) {
          val count = if (r - l == 1) "" else s"${r - l}" //  handle single occurence case
          acc.append(chars(l)).append(count)
        } else if (chars(l) == chars(r)) {
          loop(l, r + 1, acc) // just continue if the current (right pointer) char is the same as the left pointer char
        } else {
          val count = if (r - l == 1) "" else s"${r - l}" //  handle single occurence case
          loop(r, r, acc.append(chars(l)).append(count))
        }

      val compressed = loop(0, 0, new StringBuilder())
      compressed.copyToArray(chars)
      compressed.length()
    }

  println(compress(Array('a', 'a', 'b', 'b', 'c', 'c', 'c')))                               // output: 6
  println(compress(Array('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'))) // output: 4

}
