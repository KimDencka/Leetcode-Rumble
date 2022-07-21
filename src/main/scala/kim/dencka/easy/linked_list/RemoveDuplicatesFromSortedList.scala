package kim.dencka.easy.linked_list

import kim.dencka.payloads.LinkedListStructure._

object RemoveDuplicatesFromSortedList extends App {

  def deleteDuplicates(head: ListNode): ListNode = {
    def listToListNode(list: List[Int]): ListNode = {
      @annotation.tailrec
      def run(myList: List[Int], acc: ListNode): ListNode = myList match {
        case h :: tail => run(tail, new ListNode(h, acc))
        case Nil => acc
      }
      run(list.reverse.tail, new ListNode(list.last, null))
    }
    def removeDuplicates(nums: List[Int]): List[Int] = {
      val result = nums.drop(1).foldLeft((nums.head, 0, List(nums.head))) { case ((prev, counter, acc), el) =>
        if (prev == el) {
          (el, counter + 1, acc)
        }
        else {
          (el, counter, acc :+ el)
        }
      }
      result._3
    }
    def listNodeToList(listNode: ListNode): List[Int] = {
      @annotation.tailrec
      def run(ln: ListNode, acc: List[Int]): List[Int] = ln match {
        case li if li.next != null => run(li.next, acc :+ li.x)
        case li => acc :+ li.x
      }
      run(listNode, List())
    }
    if (head == null) null
    else {
      val list = listNodeToList(head)
      println(listNodeToList(head))
      listToListNode(removeDuplicates(list))
    }
  }

  println(deleteDuplicates(list2))

}
