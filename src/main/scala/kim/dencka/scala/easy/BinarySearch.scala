package kim.dencka.scala.easy

object BinarySearch extends App {

  def search(nums: Array[Int], target: Int): Int = {
    @annotation.tailrec
    def findNumber(low: Int, high: Int): Int = {
      val middle = low + (high - low) / 2

      if (low > high) -1
      else if (nums(middle) == target) middle
      else if (nums(middle) > target) findNumber(low, middle - 1)
      else findNumber(middle + 1, high)
    }

    findNumber(0, nums.length - 1)
  }

  println(search(Array(-1, 0, 3, 5, 9, 12), 2))

}
