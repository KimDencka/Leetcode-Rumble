package kim.dencka.scala.medium.linked_list

import kim.dencka.scala.payloads.LinkedListStructure._

object DeleteNodesFromLinkedListPresentInArray extends App {

  // time - 80%, memory - 90%
  def modifiedList(nums: Array[Int], head: ListNode): ListNode = {
    val numsSet = nums.toSet
    @annotation.tailrec
    def skipNodes(node: ListNode): ListNode =
      if (numsSet.contains(node.x)) skipNodes(node.next)
      else node

    val newHead = skipNodes(head)

    @annotation.tailrec
    def deleteNodes(prev: ListNode, node: ListNode): Unit =
      if (node != null) {
        if (numsSet.contains(node.x)) {
          prev.next = node.next
          deleteNodes(prev, node.next)
        } else {
          deleteNodes(node, node.next)
        }
      }

    deleteNodes(newHead, newHead.next)
    newHead
  }


  // elegant functional solution; time - 50%, memory - 100%
  def modifiedList(nums: Array[Int], head: ListNode): ListNode = {
    val numsSet = nums.toSet
    @annotation.tailrec
    def toList(node: ListNode, acc: List[Int]): List[Int] =
      if (node != null) toList(node.next, node.x :: acc)
      else acc

    toList(head, Nil)
      .filterNot(numsSet.contains)
      .foldLeft(null: ListNode) { case (prev, x) => new ListNode(x, prev) }
  }



//  printList(modifiedList(Array(1, 2, 3), list0))
//  printList(modifiedList(Array(1), makeList(List(1, 2, 1, 2, 1, 2))))
  printList(modifiedList(Array(1, 7, 6, 2, 4), makeList(List(3, 7, 1, 8, 1))))
}
