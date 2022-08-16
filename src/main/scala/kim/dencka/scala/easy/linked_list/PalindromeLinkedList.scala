package kim.dencka.scala.easy.linked_list

import kim.dencka.scala.payloads.LinkedListStructure._

object PalindromeLinkedList extends App {

  def isPalindrome(head: ListNode): Boolean = {
    @annotation.tailrec
    def reverse(ln: ListNode, acc: ListNode): ListNode = ln match {
      case null => acc
      case _ => reverse(ln.next, new ListNode(ln.x, acc))
    }

    @annotation.tailrec
    def compare(ln1: ListNode, ln2: ListNode): Boolean = (ln1, ln2) match {
      case (null, null) => true
      case (l1, l2) if l1 == null || l2 == null || l1.x != l2.x => false
      case _ => compare(ln1.next, ln2.next)
    }

    compare(head, reverse(head, null))
  }

// KIM_INFO THERE IS A SOLUTION FROM DISCUSSION (I LIKE IT)

//  def isPalindrome(head: ListNode): Boolean = {
//    def go(lhead: ListNode, node: ListNode): ListNode = {
//      if (node == null) lhead
//      else {
//        val ln = go(lhead, node.next)
//        if (ln == null || ln.x != node.x) null
//        else if (ln.next != null) ln.next
//        else ln
//      }
//    }
//
//    head == null || head.next == null || go(head, head) != null
//  }


}
