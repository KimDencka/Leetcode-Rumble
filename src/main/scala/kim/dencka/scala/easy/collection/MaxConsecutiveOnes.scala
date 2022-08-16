package kim.dencka.scala.easy.collection

object MaxConsecutiveOnes extends App {

  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    @annotation.tailrec
    def run(arr: Array[Int], cnt: Int, acc: Int): Int =
      if (arr.isEmpty) math.max(acc, cnt)
      else if (arr.head == 1) run(arr.tail, cnt + 1, acc)
      else run(arr.tail, 0, math.max(acc, cnt))
    run(nums, 0, 0)
  }

  println(findMaxConsecutiveOnes(Array(1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1)))

}
