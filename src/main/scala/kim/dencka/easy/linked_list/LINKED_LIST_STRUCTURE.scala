package kim.dencka.easy.linked_list

object LINKED_LIST_STRUCTURE {
  class ListNode(val x: Int, val next: ListNode = null)

  // 1,2,3,6,4,5,6
  val list1 =
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
  // 1,1,2,3,3
  val list2 =
    new ListNode(
      1,
      new ListNode(
        1,
        new ListNode(
          2,
          new ListNode(
            3,
            new ListNode(
              3
            )
          )
        )
      )
    )
  // 1,2,4
  val list3 = new ListNode(1, new ListNode(2, new ListNode(4)))
  // 1,3,4
  val list4 = new ListNode(1, new ListNode(3, new ListNode(4)))
  // 4,1,8,4,5
  val list5 = new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5)))))
  // 5,6,1,8,4,5
  val list6 = new ListNode(5, new ListNode(6, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))))))
}
