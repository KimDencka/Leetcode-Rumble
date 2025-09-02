package kim.dencka.scala.easy

object ContainsDuplicateII extends App {
  import scala.collection.immutable.HashSet
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    @annotation.tailrec
    def check(index: Int, previous: HashSet[Int]): Boolean =
      if (index >= nums.length) false
      else if (previous.contains(nums(index))) true
      else {
        if (previous.size < k) check(index + 1, previous + nums(index))
        else check(index + 1, previous + nums(index) - nums(index - k))
      }

    check(0, HashSet.empty)
  }

  println(containsNearbyDuplicate(Array(1, 2, 3, 1, 2, 3), 2)) // false
  println(containsNearbyDuplicate(Array(1, 0, 1, 1), 1)) // true
  println(containsNearbyDuplicate(Array(1), 1)) // false
  println(containsNearbyDuplicate(Array(0, 1, 2, 3, 2, 5), 3)) // true
  println(containsNearbyDuplicate(Array(99, 99), 2)) // true
  println(containsNearbyDuplicate(Array(99, 99, 80), 3)) // true
  println(containsNearbyDuplicate(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 9), 3)) // true

}
