package kim.dencka.easy.collection

object LinkedListCycle extends App {

  class ListNode(
    var x: Int,
    var next: ListNode = null
  )

  def hasCycle(head: ListNode): Boolean = {
    @annotation.tailrec
    def loop(slow: ListNode, fast: ListNode): Boolean = {
      println(s"slow: ${slow.x}, fast: ${fast.x}")
      if (slow == fast) true
      else if (fast == null || fast.next == null) false
      else loop(slow.next, fast.next.next)
    }

    if (head == null || head.next == null) false
    else loop(head.next, head.next.next)
  }

}
