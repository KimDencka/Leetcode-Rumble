package kim.dencka.easy.collection

object IntersectionOfTwoArraysII extends App {

  // DEN_INFO SEE LEETCODE_POLYGON

  val arr1 = Array(1, 2, 3, 4, 3)
  val arr2 = Array(5, 1, 4, 6, 2, 3, 7, 4, 3)

  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    @annotation.tailrec
    def run(arr1: Array[Int], arr2: Array[Int], i: Int, j: Int, acc: Array[Int]): Array[Int] =
      if (i == arr1.length || j == arr2.length) acc
      else if (arr1(i) < arr2(j)) run(arr1, arr2, i + 1, j, acc)
      else if (arr1(i) > arr2(j)) run(arr1, arr2, i, j + 1, acc)
      else run(arr1, arr2, i + 1, j + 1, acc :+ arr1(i))
    run(nums1.sorted, nums2.sorted, 0, 0, Array.empty[Int])
  }

  println(intersect(arr1, arr2).toList)

}
