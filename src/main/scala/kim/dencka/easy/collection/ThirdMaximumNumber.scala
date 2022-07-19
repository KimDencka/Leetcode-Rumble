package kim.dencka.easy.collection

object ThirdMaximumNumber extends App {

  // KIM_INFO SEE LEETCODE_POLYGON
  import scala.collection.immutable.SortedSet

  def thirdMax(nums: Array[Int]): Int = {
    val maxs = nums.foldLeft(SortedSet.empty[Int]) { (set, num) =>
      if (set.size < 3) set + num
      else if (num > set.head && !set.contains(num)) set - set.head + num
      else set
    }
    if (maxs.size < 3) maxs.last
    else maxs.head
  }

  println(thirdMax(Array(1, 2, 3, 4, 5, 6, 6, 7, 8, 8, 8)))

}
