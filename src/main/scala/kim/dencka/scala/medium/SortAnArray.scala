package kim.dencka.scala.medium

object SortAnArray extends App {

  def sortArray(nums: Array[Int]): Array[Int] = {
    if (nums.length <= 1) return nums
    val (list1, list2) = nums.splitAt(nums.length / 2)
    merge(sortArray(list1).toList, sortArray(list2).toList).toArray
  }

  @annotation.tailrec
  def merge(list1: List[Int], list2: List[Int], acc: List[Int] = List.empty): List[Int] =
    (list1, list2) match {
      case (_, Nil)             => acc.reverse ++ list1
      case (Nil, _)             => acc.reverse ++ list2
      case (h1 :: t1, h2 :: t2) =>
        if (h1 < h2) merge(t1, list2, h1 :: acc)
        else merge(list1, t2, h2 :: acc)
    }

  println(sortArray(Array(5, 2, 3, 1)).toList)
}
