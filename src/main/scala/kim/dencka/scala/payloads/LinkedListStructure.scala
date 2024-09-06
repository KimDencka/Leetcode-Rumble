package kim.dencka.scala.payloads

object LinkedListStructure {
  case class ListNode(var x: Int, var next: ListNode = null)

  @annotation.tailrec
  def printList(list: ListNode): Unit =
    if (list == null) println()
    else {
      if (list.next != null) print(s"${list.x}, ")
      else print(list.x)
      printList(list.next)
    }

  def makeList(data: List[Int]): ListNode = {
    data match {
      case Nil          => null
      case head :: tail => ListNode(head, makeList(tail))
    }
  }


  // 1,2,3,4,5,6,7,8,9
  val list0 = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6, ListNode(7, ListNode(8, ListNode(9)))))))))
  // 1,2,3,6,4,5,6
  val list1 = ListNode(1, ListNode(2, ListNode(6, ListNode(3, ListNode(4, ListNode(5, ListNode(6)))))))
  // 1,1,2,3,3
  val list2 = ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(3)))))
  // 1,2,4
  val list3 = ListNode(1, ListNode(2, ListNode(4)))
  // 1,3,4
  val list4 = ListNode(1, ListNode(3, ListNode(4)))
  // 4,1,8,4,5
  val list5 = ListNode(4, ListNode(1, ListNode(8, ListNode(4, ListNode(5)))))
  // 5,6,1,8,4,5
  val list6 = ListNode(5, ListNode(6, ListNode(1, ListNode(8, ListNode(4, ListNode(5))))))
  // 1,2,3,4,5,4,3,2,1
  val list7 = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6, ListNode(4, ListNode(3, ListNode(2, ListNode(1))))))))))
  // 1,4,3,2,5,2
  val list8 = ListNode(1, ListNode(4, ListNode(3, ListNode(2, ListNode(5, ListNode(2))))))
}
