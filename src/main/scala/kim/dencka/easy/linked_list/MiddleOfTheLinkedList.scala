package kim.dencka.easy.linked_list

import LINKED_LIST_STRUCTURE._

object MiddleOfTheLinkedList extends App {

  def middleNode(head: ListNode): ListNode = {
    @annotation.tailrec
    def run(list1: ListNode, list2: ListNode): ListNode =
      (list1, list2) match {
        case (_, l2) if l2 == null || l2.next == null => list1
        case _ => run(list1.next, list2.next.next)
      }
    run(head, head)
  }

  println(middleNode(list0))

}
