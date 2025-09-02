package kim.dencka.scala.easy

object MissingNumber extends App {

  def missingNumber(nums: Array[Int]): Int =
    nums.sorted.fold(0) { case (cnt, el) =>
      if (cnt == el) cnt + 1
      else cnt
    }

  println(missingNumber(Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)))

}
