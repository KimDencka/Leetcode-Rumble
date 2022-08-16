package kim.dencka.scala.medium.linked_list

import kim.dencka.scala.payloads.LinkedListStructure._

object ReverseLinkedListII extends App {

  def reverseBetween(head: ListNode, left: Int, right: Int): ListNode = {
    def listNodeToList(listNode: ListNode): List[Int] = {
      @annotation.tailrec
      def run(ln: ListNode, acc: List[Int]): List[Int] = ln match {
        case li if li.next != null => run(li.next, acc :+ li.x)
        case li => acc :+ li.x
      }
      run(listNode, List())
    }

    @annotation.tailrec
    def reversePart(myList: List[Int], step: Int, temp: List[Int], acc: List[Int]): List[Int] =
      myList match {
        case Nil => acc
        case h :: tail if step == right => reversePart(tail, step, List(), acc ++ (h +: temp))
        case h :: tail if step == left => reversePart(tail, step + 1, h +: temp, acc)
        case h :: tail if step > left && step < right => reversePart(tail, step + 1, h +: temp, acc)
        case h :: tail => reversePart(tail, step + 1, temp, acc :+ h)
      }

    def listToListNode(list: List[Int]): ListNode =
      if (list.isEmpty) null
      else new ListNode(list.head, listToListNode(list.tail))

    if (left == right) head
    else listToListNode(reversePart(listNodeToList(head), 1, List.empty, List.empty))
  }

  println(reverseBetween(list0, 3, 7))

}
