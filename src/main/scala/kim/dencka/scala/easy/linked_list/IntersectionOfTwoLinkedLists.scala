package kim.dencka.scala.easy.linked_list

import kim.dencka.scala.payloads.LinkedListStructure._

object IntersectionOfTwoLinkedLists extends App {

  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    @annotation.tailrec
    def run(list1: ListNode, list2: ListNode): ListNode =
      (list1, list2) match {
        case (l1, l2) if l1 == null || l2 == null => null
        case _ =>
          if (list1 == list2) list1
          else
            (list1.next, list2.next) match {
              case (null, null) => null
              case (null, _) => run(headB, list2.next)
              case (_, null) => run(list1.next, headA)
              case (_, _) => run(list1.next, list2.next)
            }
      }
    run(headA, headB)
  }

//  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
//    @scala.annotation.tailrec
//    def helper(currentA: ListNode, currentB: ListNode): ListNode =
//      (currentA, currentB) match {
//        case (null, null) => null
//        case (null, _) => null
//        case (_, null) => null
//        case (_, _) =>
//          if (currentA == currentB) {
//            currentA
//          }
//          else {
//            (currentA.next, currentB.next) match {
//              case (null, null) => null
//              case (null, _) => helper(headB, currentB.next)
//              case (_, null) => helper(currentA.next, headA)
//              case (_, _) => helper(currentA.next, currentB.next)
//            }
//          }
//      }
//
//    helper(headA, headB)
//  }

  println(getIntersectionNode(list5, list6))

}
