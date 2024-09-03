package kim.dencka.scala.medium.collection

object IncreasingTripletSubsequence extends App {

  @annotation.tailrec
  def increasingTriplet(
    nums: Array[Int],
    first: Int = Int.MaxValue,
    second: Int = Int.MaxValue,
    index: Int = 0
  ): Boolean =
    if (index >= nums.length) false
    else if (nums(index) > second) true
    else if (nums(index) <= first) increasingTriplet(nums, nums(index), second, index + 1)
    else increasingTriplet(nums, first, nums(index), index + 1)

  println(increasingTriplet(Array(1, 2, 3, 4, 5)))    // output: true
  println(increasingTriplet(Array(5, 4, 3, 2, 1)))    // output: false
  println(increasingTriplet(Array(2, 1, 5, 0, 4, 6))) // output: true

}
