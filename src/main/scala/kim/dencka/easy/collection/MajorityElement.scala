package kim.dencka.easy.collection

object MajorityElement extends App {

// #1
//  def majorityElement(nums: Array[Int]): Int = {
//    val half = nums.length / 2
//    val x = nums.groupBy(identity).view.mapValues(_.length).maxBy(_._2)
//    if (x._2 > half)  x._1
//    else 0
//  }

//  #2
//  def majorityElement(nums: Array[Int]): Int = {
//    val sorted = nums.sorted
//    sorted(sorted.length / 2)
//  }

// O(n) - time, O(1) - space
  def majorityElement(nums: Array[Int]): Int = {
    @annotation.tailrec
    def majorityElement(list: Array[Int], countMap: Map[Int, Int]): Int = {
      val current: Int = list.head
      val updatedCountMap: Map[Int, Int] = countMap + (current -> (countMap.getOrElse(current, 0) + 1))

      if (updatedCountMap(current) > nums.length / 2) current
      else majorityElement(list.tail, updatedCountMap)
    }
    majorityElement(nums, Map.empty)
  }


  println(majorityElement(Array(2,2,1,1,1,2,2)))
}
