package kim.dencka.easy.linked_list

object ReverseLinkedList extends App {

  class ListNode(val x: Int, val next: ListNode = null)

  def reverseList(head: ListNode): ListNode = {
    @annotation.tailrec
    def run(ln: ListNode, acc: ListNode): ListNode = ln match {
      case null => acc
      case _ => run(ln.next, new ListNode(ln.x, acc))
    }
    run(head, null)
  }

}
