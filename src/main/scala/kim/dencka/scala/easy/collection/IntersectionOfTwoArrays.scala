package kim.dencka.scala.easy.collection

object IntersectionOfTwoArrays extends App {
  import scala.collection.immutable.HashSet

  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    @annotation.tailrec
    def run(arr: Array[Int], acc: HashSet[Int]): Array[Int] = arr match {
      case Array() => acc.toArray
      case _ if nums1.contains(arr.head) => run(arr.tail, acc + arr.head)
      case _ => run(arr.tail, acc)
    }
    run(nums2, HashSet.empty[Int])
  }
}
