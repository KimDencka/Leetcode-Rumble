package kim.dencka.payloads

object LinkedListStructure {
  case class ListNode(val x: Int, val next: ListNode = null)

  // 1,2,3,4,5,6,7,8,9
  val list0 =
    new ListNode(
      1,
      new ListNode(
        2,
        new ListNode(
          3,
          new ListNode(
            4,
            new ListNode(
              5,
              new ListNode(
                6,
                new ListNode(
                  7,
                  new ListNode(
                    8,
                    new ListNode(
                      9
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
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
  // 1,2,3,4,5,4,3,2,1
  val list7 = new ListNode(
    1,
    new ListNode(
      2,
      new ListNode(
        3,
        new ListNode(
          4,
          new ListNode(
            5,
            new ListNode(
              6,
              new ListNode(
                4,
                new ListNode(
                  3,
                  new ListNode(
                    2,
                    new ListNode(
                      1
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )
  // 1,4,3,2,5,2
  val list8 =
    new ListNode(
      1,
      new ListNode(
        4,
        new ListNode(
          3,
          new ListNode(
            2,
            new ListNode(
              5,
              new ListNode(
                2
              )
            )
          )
        )
      )
    )
}
