package kim.dencka.scala.easy.collection

object ImplementStrMethod extends App {
  def strStr(haystack: String, needle: String): Int = {
    @annotation.tailrec
    def run(prefix: String, acc: Int): Int = prefix.take(needle.length) match {
      case _ if haystack.isEmpty => 0
      case s if s == needle => acc
      case s if s.nonEmpty => run(prefix.tail, acc + 1)
      case _ => -1
    }
    run(haystack, 0)
  }

  val haystack = "aaaaaa"
  val needle = "bbab"

  println(strStr(haystack, needle))
}
