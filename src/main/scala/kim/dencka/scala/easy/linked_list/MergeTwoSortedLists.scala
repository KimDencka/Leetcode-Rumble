package kim.dencka.scala.easy.linked_list

import kim.dencka.scala.payloads.LinkedListStructure._

object MergeTwoSortedLists extends App {

  @annotation.tailrec
  def listNodeToList(listNode: ListNode, list: List[Int]): List[Int] =
    if (Option(listNode).isEmpty) {
      List.empty
    }
    else if (Option(listNode.next).isEmpty) {
      list :+ listNode.x
    }
    else {
      listNodeToList(listNode.next, list :+ listNode.x)
    }

  def listToListNode(list: List[Int]): ListNode = list match {
    case h :: t =>
      new ListNode(h, listToListNode(t))
    case _ => null
  }

  def mergeList(list1: List[Int], list2: List[Int]): List[Int] = (list1, list2) match {
    case (Nil, _) => list2
    case (_, Nil) => list1
    case (h1 :: t1, h2 :: t2) =>
      if (h1 < h2) {
        h1 :: mergeList(t1, list2)
      }
      else {
        h2 :: mergeList(list1, t2)
      }
  }
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode =
    if (Option(list1).isEmpty && Option(list2).isEmpty) {
      null
    }
    else {
      val l1 = listNodeToList(list1, List.empty)
      val l2 = listNodeToList(list2, List.empty)
      val res = mergeList(l1, l2)
      listToListNode(res)
    }


  mergeTwoLists(list3, list4)

}
