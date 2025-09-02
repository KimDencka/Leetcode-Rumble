package kim.dencka.scala.medium

object MaximumSubarray extends App {

  def maxSubArray(nums: Array[Int]): Int =
    if (nums.length == 1) {
      nums(0)
    }
    else if (nums.forall(_ < 0)) {
      nums.max
    }
    else {
      val sum = nums.foldLeft(0, 0) { case ((maxSum, currSum), e) =>
        val x = if (currSum < 0) 0 else currSum
        (math.max(maxSum, x + e), x + e)
      }
      sum._1
    }

  println(maxSubArray(Array(-2, 3)))}
