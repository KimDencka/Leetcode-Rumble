package kim.dencka.easy.linked_list

import kim.dencka.payloads.LINKED_LIST_STRUCTURE._

object ConvertBinaryNumberInLinkedListToInteger extends App {

  def getDecimalValue(head: ListNode): Int = {
    def toStr(list: ListNode): String =
      if (list == null) ""
      else list.x + toStr(list.next)

    def toDec(l: String): Int = {
      l.foldRight(0, 0) { case (el, (acc, cnt)) =>
        if (el.toString.toInt == 0) (acc, cnt + 1)
        else (acc + math.pow(2, cnt).toInt, cnt + 1)
      }
    }._1
    toDec(toStr(head))
  }

  println(getDecimalValue(null))

}
