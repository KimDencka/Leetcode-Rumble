package kim.dencka.scala.easy

import kim.dencka.scala.payloads.LinkedListStructure._

object RemoveLinkedListElements extends App {

  def removeElements(head: ListNode, `val`: Int): ListNode = {
    def run(ln: ListNode): ListNode = ln match {
      case null => null
      case l if l.x == `val` => run(l.next)
      case _ => new ListNode(ln.x, run(ln.next))
    }
    run(head)
  }

  println(removeElements(list1, 6))

}
