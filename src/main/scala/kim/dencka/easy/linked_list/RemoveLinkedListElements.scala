package kim.dencka.easy.linked_list

import kim.dencka.payloads.LINKED_LIST_STRUCTURE._

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
