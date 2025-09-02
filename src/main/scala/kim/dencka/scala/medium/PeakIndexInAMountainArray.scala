package kim.dencka.scala.medium

object PeakIndexInAMountainArray extends App {
  //    arr.indexOf(arr.max) // slow but elegant solution

  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    @annotation.tailrec
    def loop(low: Int, high: Int): Int = {
      val mid = (low + high) / 2
      arr(mid) match {
        case num if num < arr(mid + 1) => loop(mid + 1, high)
        case num if num > arr(mid + 1) && num > arr(mid - 1) => mid
        case _ => loop(low, mid)
      }
    }
    loop(0, arr.length - 1)
  }

}
