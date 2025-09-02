package kim.dencka.scala.easy

object ReverseVowelsOfAString extends App {

  def reverseVowels(s: String): String = {
    val vowels = Set('a', 'o', 'u', 'e', 'i', 'A', 'O', 'U', 'E', 'I')

    @annotation.tailrec
    def loop(left: Int, right: Int, acc: StringBuilder): StringBuilder = {
      if (left > right) return acc
      val (leftChar, rightChar) = (s.charAt(left), s.charAt(right))
      if (vowels.contains(leftChar) && vowels.contains(rightChar)) {
        acc.replace(left, left + 1, s"$rightChar")
        acc.replace(right, right + 1, s"$leftChar")
        loop(left + 1, right - 1, acc)
      } else if (vowels.contains(leftChar) && !vowels.contains(rightChar)) {
        loop(left, right - 1, acc)
      } else if (!vowels.contains(leftChar) && vowels.contains(rightChar)) {
        loop(left + 1, right, acc)
      } else {
        loop(left + 1, right - 1, acc)
      }
    }
    loop(0, s.length - 1, new StringBuilder(s)).toString
  }

  println(reverseVowels("hello"))    // output: holle
  println(reverseVowels("leetcode")) // output: leotcede
  println(reverseVowels("aA"))       // output: Aa

}
