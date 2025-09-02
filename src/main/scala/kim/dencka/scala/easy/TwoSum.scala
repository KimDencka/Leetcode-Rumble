package kim.dencka.scala.easy

object TwoSum extends App {

  val array = Array(3, 2, 4)

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val res = Array(0, 0)
    for {
      i <- nums.indices
      j <- i + 1 until nums.length
    } if (nums(i) + nums(j) == target) {
      res(0) = i
      res(1) = j
    }
    res
  }

  println(twoSum(array, 6).toList)

}
