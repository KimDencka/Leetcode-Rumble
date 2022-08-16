package kim.dencka.scala.easy.collection

object RangeSumQuery_Immutable extends App {

  class NumArray(_nums: Array[Int]) {

    def sumRange(left: Int, right: Int): Int = {
      @annotation.tailrec
      def run(l: Int, acc: Int): Int = l match {
        case _ if l > right => acc
        case _ => run(l + 1, acc + _nums(l))
      }
      run(left, 0)
    }
  }

}
