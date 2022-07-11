package kim.dencka.easy.collection

object ValidParentheses extends App {

  val s = "(("

  def isValid(s: String): Boolean = {
    val map = Map('(' -> ')', '{' -> '}', '[' -> ']')
    @annotation.tailrec
    def go(tailing: String, acc: List[Char]): Boolean = tailing match {
      case ss if ss.nonEmpty =>
        val el = ss.head
        if (map.contains(el)) {
          go(ss.tail, el +: acc)
        }
        else if (acc.headOption.flatMap(map.get).contains(el)) {
          go(ss.tail, acc.tail)
        }
        else {
          false
        }
      case _ if acc.nonEmpty => false
      case _ => true
    }
    if (s.length == 1) {
      false
    }
    else {
      go(s, List())
    }
  }

  println(isValid(s))

}
