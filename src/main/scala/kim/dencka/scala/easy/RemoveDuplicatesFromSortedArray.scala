package kim.dencka.scala.easy

object RemoveDuplicatesFromSortedArray extends App {

  val array = Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
  val array2 = Array(1, 1, 2)

  def removeDuplicates(nums: Array[Int]): Int =
    if (nums.isEmpty) {
      0
    }
    else {
      val result = nums.drop(1).foldLeft((nums.head, 0, List(nums.head))) { case ((prev, counter, acc), el) =>
        if (prev == el) {
          (el, counter + 1, acc)
        }
        else {
          (el, counter, acc :+ el)
        }
      }
      val expected = result._3
      nums.dropRight(nums.length - expected.length)
      for (i <- expected.indices)
        nums(i) = expected(i)
      result._3.length
    }

  println(removeDuplicates(array))
  println(removeDuplicates(array2))
}
