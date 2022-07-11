package kim.dencka.easy.collection

object LongestCommonPrefix extends App {

  val array = Array("flower", "flow", "flight")

  def longestCommonPrefix(strs: Array[String]): String = {
    val starter = strs.headOption.getOrElse("")

    @annotation.tailrec
    def findCommon(str1: String, prefix: String): String =
      if (str1.startsWith(prefix)) {
        prefix
      }
      else if (str1.length > prefix.length) {
        findCommon(str1.dropRight(1), prefix)
      }
      else if (str1.length == prefix.length) {
        findCommon(str1.dropRight(1), prefix.dropRight(1))
      }
      else if (str1.length < prefix.length) {
        findCommon(str1, prefix.dropRight(1))
      }
      else {
        ""
      }

    strs.drop(1).foldLeft(starter) { (acc, elem) =>
      findCommon(elem, acc)
    }

    //    @annotation.tailrec
    //    def run(prefix: String): String = strs match {
    //      case arr if arr.forall(_.startsWith(prefix)) => prefix
    //      case _ if prefix.nonEmpty => run(prefix.dropRight(1))
    //      case _ => ""
    //    }
    //    run(maxLength.headOption.getOrElse(""))
  }

  println(longestCommonPrefix(array))

}
