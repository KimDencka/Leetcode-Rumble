package kim.dencka.easy.collection

object MergeSortedArray extends App {

  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
      for ((i, j) <- (m until nums1.length).zip(nums2.indices))
        nums1(i) = nums2(j)
      val sortedArr = nums1.sorted
      for (i <- nums1.indices)
        nums1(i) = sortedArr(i)
      println(nums1.toList)
    }
  }

  //  FROM DISCUSS
  //  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
  //    import scala.annotation.tailrec
  //    @tailrec
  //    def recur(leftIdx: Int, rightIdx: Int, writeIndex: Int): Unit = {
  //      (leftIdx, rightIdx, writeIndex) match {
  //        case (_, r, _) if r < 0 =>
  //        case (l, r, w) if l >= 0 && nums1(l) > nums2(r) =>
  //          nums1(w) = nums1(l)
  //          recur(l-1, r, w-1)
  //        case (l, r, w) =>
  //          nums1(w) = nums2(r)
  //          recur(l, r-1, w-1)
  //      }
  //    }
  //    //
  //    recur(m - 1, n - 1, m + n - 1)
  //    println(nums1.toList)
  //  }

  merge(Array(1, 2, 3, 0, 0, 0), 3, Array(2, 4, 6), 3)

}
