package kim.dencka.easy.collection

object TwoSum extends App {

  val array = Array(3, 2, 4)

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    for {
      i <- nums.indices
      j <- i + 1 until nums.length
    } if (nums(i) + nums(j) == target) {
      return Array(i, j)
    }
    Array()
  }

  println(twoSum(array, 6).toList)

}
