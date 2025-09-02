package kim.dencka.scala.easy

object LongestCommonPrefix extends App {

  val array = Array("flower", "flow", "flight")

  def longestCommonPrefix(strs: Array[String]): String = {
    val starter = strs.headOption.getOrElse("")

    @annotation.tailrec
    def findCommon(str1: String, prefix: String): String =
      if (str1.startsWith(prefix)) prefix
      else if (str1.length > prefix.length) findCommon(str1.init, prefix)
      else if (str1.length == prefix.length) findCommon(str1.init, prefix.init)
      else if (str1.length < prefix.length) findCommon(str1, prefix.init)
      else ""

    strs.tail.foldLeft(starter) { (acc, elem) =>
      findCommon(elem, acc)
    }

  }

  println(longestCommonPrefix(array))

}
