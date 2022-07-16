package kim.dencka.easy.collection
class SecondMinimumNodeInBinaryTree
object PascalsTriangle extends App {
  def generate(numRows: Int): List[List[Int]] = {
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
    def run(cnt: Int, current: List[Int], acc: List[List[Int]]): List[List[Int]] =
      cnt match {
        case c if c == numRows => acc
        case c =>
          val nr = nextRow(current)
          println(s"current: $current, nr $nr")
          run(c + 1, nr, acc :+ nr)
      }
    run(1, List(1), List(List(1)))
  }

  // DEN_INFO THERE IS SOLUTION FROM DISCUSSION

  // FROM DISCUSSION (I LIKE IT)
    def generate2(numRows: Int): List[List[Int]] = {
      @annotation.tailrec
      def iter(index: Int, acc: List[List[Int]]): List[List[Int]] = index match {
        case `numRows` => acc
        case 0         => iter(1, List(List(1)))
        case 1         => iter(2, List(1, 1) +: acc)
        case _ =>
          val row = 1 +: acc.head.sliding(2, 1).map(_.sum).toList :+ 1
          iter(index + 1, row +: acc)
      }

      iter(0, Nil).reverse
    }

  println(generate2(5))

}
