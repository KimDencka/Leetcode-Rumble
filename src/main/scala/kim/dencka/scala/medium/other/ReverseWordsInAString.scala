package kim.dencka.scala.medium.other

object ReverseWordsInAString extends App {
  // factory methods
  def reverseWords(s: String): String = s.split(" ").filter(_.nonEmpty).reverse.mkString(" ")

  println(reverseWords("the sky is blue"))  // output: blue is sky the
  println(reverseWords("a good   example")) // output: example good a
  println(reverseWords("  hello world  "))  // output: world hello
}
