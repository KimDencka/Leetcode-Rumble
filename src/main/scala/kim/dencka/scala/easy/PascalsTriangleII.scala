package kim.dencka.scala.easy

object PascalsTriangleII extends App {

  def getRow(rowIndex: Int): List[Int] = {
    def nextRow(list: List[Int]): List[Int] = {
      @annotation.tailrec
      def run(myList: List[Int], acc: List[Int]): List[Int] = myList match {
        case h :: Nil => h +: h +: acc
        case h :: l :: Nil if list.length == 2 => h +: (h + l) +: l +: acc
        case h :: l :: Nil => acc :+ (h + l) :+ l
        case h :: el :: tail if h == 1 => run(el :: tail, acc :+ h :+ h + el)
        case h :: tail => run(tail, acc :+ h + tail.head)
      }
      run(list, List())
    }

    @annotation.tailrec
    def run(cnt: Int, current: List[Int], acc: List[List[Int]]): List[Int] =
      cnt match {
        case c if c == rowIndex => acc.last
        case c =>
          val nr = nextRow(current)
          println(s"current: $current, nr $nr")
          run(c + 1, nr, acc :+ nr)
      }
    run(0, List(1), List(List(1)))
  }

  // KIM_INFO THERE IS A SOLUTION FROM DISCUSSION

  // FROM DISCUSSION (MODIFIED. SEE PASCALS TRIANGLE)
  //    def getRow(rowIndex: Int): List[Int] = {
  //      @annotation.tailrec
  //      def iter(index: Int, acc: List[List[Int]]): List[Int] = index match {
  //        case i if i == rowIndex + 1 => acc.head
  //        case 0         => iter(1, List(List(1)))
  //        case 1         => iter(2, List(1, 1) +: acc)
  //        case _ =>
  //          val row = 1 +: acc.head.sliding(2, 1).map(_.sum).toList :+ 1
  //          iter(index + 1, row +: acc)
  //      }
  //
  //      iter(0, Nil)
  //    }

  println(getRow(33))

}
