package kim.dencka.easy.collection

object NextGreaterElementI extends App {

  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] =
    nums1.foldLeft(Array.empty[Int]) { (acc, num) =>
      val index = nums2.indexOf(num)
      val el = nums2.splitAt(index + 1)._2.find(_ > num).getOrElse(-1)
      acc :+ el
    }

  // KIM_INFO THE SAME LOGIC, BUT DIFFERENT IMPLEMENTATIONS (I LIKE IT)
  def nextGreaterElement2(nums1: Array[Int], nums2: Array[Int]): Array[Int] =
    nums1.map(num => nums2.drop(nums2.indexOf(num) + 1).find(_ > num).getOrElse(-1))

  println(nextGreaterElement(Array(4, 1, 2), Array(1, 3, 4, 2)).toList)
  println(nextGreaterElement2(Array(4, 1, 2), Array(1, 3, 4, 2)).toList)

}
