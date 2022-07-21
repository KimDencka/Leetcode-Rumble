package kim.dencka.easy.linked_list

import kim.dencka.payloads.LINKED_LIST_STRUCTURE._

object ReverseLinkedList extends App {

  def reverseList(head: ListNode): ListNode = {
    @annotation.tailrec
    def run(ln: ListNode, acc: ListNode): ListNode = ln match {
      case null => acc
      case _ => run(ln.next, new ListNode(ln.x, acc))
    }
    run(head, null)
  }

}
