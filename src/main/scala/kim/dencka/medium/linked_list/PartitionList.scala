package kim.dencka.medium.linked_list

import kim.dencka.payloads.LinkedListStructure._

object PartitionList extends App {

  def partition(head: ListNode, x: Int): ListNode = {
    @annotation.tailrec
    def getSmaller(ln: ListNode, list1: List[Int], list2: List[Int]): List[Int] =
      ln match {
        case null => list1 ++ list2
        case l if x > l.x => getSmaller(l.next, list1 :+ ln.x, list2)
        case l => getSmaller(l.next, list1, list2 :+ ln.x)
      }

    val l1 = getSmaller(head, List.empty, List.empty)

    def buildLN(list: List[Int]): ListNode =
      if (list.isEmpty) null
      else new ListNode(list.head, buildLN(list.tail))

    buildLN(l1)
  }

  println(partition(list8, 3))

}
