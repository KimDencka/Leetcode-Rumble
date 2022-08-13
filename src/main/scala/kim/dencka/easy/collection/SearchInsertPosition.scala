package kim.dencka.easy.collection

object SearchInsertPosition extends App {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    @annotation.tailrec
    def run(
      arr: Array[Int],
      elem: Int
    )(low: Int = 0, high: Int = arr.length - 1): Int = {
      val middle = low + (high - low) / 2

      if (low > high) low + (high - low) / 2
      else if (arr(middle) == elem) middle
      else if (arr(middle) > elem) run(arr, elem)(low, middle - 1)
      else run(arr, elem)(middle + 1, high)
    }
    run(nums, target)()
  }

  val array = Array(1, 3, 5, 6)

  val res = searchInsert(array, 4)
  println(res)

}
