package kim.dencka.scala.easy

object FindAllNumbersDisappearedInAnArray extends App {

  // KIM_INFO SEE LEETCODE_POLYGON

  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    nums.foreach { num =>
      val i = math.abs(num) - 1
      if (nums(i) > 0) {
        println(s"num $num, nums(i): ${nums(i) * -1}")
        nums(i) = nums(i) * -1
      }
    }
    println(nums.toList)
    nums.zipWithIndex.collect {
      case (num, i) if num > 0 => i + 1
    }.toList
  }

  println(findDisappearedNumbers(Array(10, 2, 5, 10, 9, 1, 1, 4, 3, 7)))
  println(findDisappearedNumbers(Array(4, 3, 2, 7, 7, 2, 3, 1)))
  println(findDisappearedNumbers(Array(4, 3, 2, 7, 8, 2, 3, 1)))
  println(findDisappearedNumbers(Array(1, 1, 1, 1, 1)))
}
