package kim.dencka.easy.collection

object ArrayPartition extends App {

  def arrayPairSum(nums: Array[Int]): Int = {
    nums.sorted.zipWithIndex.filter(_._2 % 2 != 1).map(_._1).sum
    // nums.sorted.grouped(2).map(_.min).sum THE SAME SOLUTION
  }

  println(arrayPairSum(Array(6, 5, 2, 1, 2, 6)))

}