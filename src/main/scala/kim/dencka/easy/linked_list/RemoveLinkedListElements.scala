package kim.dencka.easy.linked_list

object RemoveLinkedListElements extends App {

  class ListNode(val x: Int, val next: ListNode = null)

  val list =
    new ListNode(
      1,
      new ListNode(
        2,
        new ListNode(
          6,
          new ListNode(
            3,
            new ListNode(
              4,
              new ListNode(
                5,
                new ListNode(
                  6
                )
              )
            )
          )
        )
      )
    )

  def removeElements(head: ListNode, `val`: Int): ListNode = {
    def run(ln: ListNode): ListNode = ln match {
      case null => null
      case l if l.x == `val` => run(l.next)
      case _ => new ListNode(ln.x, run(ln.next))
    }
    run(head)
  }

  println(removeElements(list, 6))

}
