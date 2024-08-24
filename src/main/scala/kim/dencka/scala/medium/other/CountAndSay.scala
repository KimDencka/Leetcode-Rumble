package kim.dencka.scala.medium.other

object CountAndSay extends App {

  def countAndSay(n: Int): String = {
    if (n == 1) return "1"
    val res = new StringBuilder("1")
    (2 to n).foreach(_ => res.replace(0, res.length(), go(res.toString())))
    res.toString()
  }

  def go(str: String): String = {
    val res                 = new StringBuilder()
    val (lastChar, lastCnt) = str.tail.foldLeft(str.head, 1) {
      case ((prev, cnt), el) if prev == el => (prev, cnt + 1)
      case ((prev, cnt), el)               =>
        res.append(cnt).append(prev)
        (el, 1)
    }
    res.append(lastCnt).append(lastChar).toString()
  }

  println(countAndSay(4)) // 1211

}
