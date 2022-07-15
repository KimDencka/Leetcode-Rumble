package kim.dencka.easy.collection

object MoveZeroes extends App {

  // TODO THERE IS SOLUTION FROM DISCUSSION

//  def moveZeroes(nums: Array[Int]): Unit = {
//    @annotation.tailrec
//    def move(left: Int, right: Int): Unit =
//      if (left < nums.length && right < nums.length) {
//        (nums(left), nums(right)) match {
//          case (x, _) if x != 0 => move(left + 1, right + 1)
//          case (0, 0) => move(left, right + 1)
//          case (0, y) if y != 0 =>
//            nums(left) = y
//            nums(right) = 0
//            move(left + 1, right + 1)
//        }
//      }
//    move(0, 0)
//  }

  def moveZeroes(nums: Array[Int]): Unit = {
    val response = nums.indices.foldLeft(0) { (lastNonZeroFoundAt, currentIndex) =>
      println(s"last: $lastNonZeroFoundAt, curr: $currentIndex")
      if (nums(currentIndex) != 0) {
        nums(lastNonZeroFoundAt) = nums(currentIndex)
        lastNonZeroFoundAt + 1
      }
      else lastNonZeroFoundAt
    }
    println(response)
    (response until nums.length).foreach(index => nums(index) = 0)
  }

//  Code WalkThrough
//
//  We use foldLeft method on array indicies, Also intialize lastNonZeroFoundAt variable with zero, during each iteration of foldLeft, we check if element is non zero, if yes, we update value nums(lastNonZeroFoundAt) = nums(currentIndex) and increment lastNonZeroFoundAt
//    Once one foldleft is completed, you will get last index where all non zero elements are stored, we then fill rest of array with zero values.

  println(moveZeroes(Array(0,1,0,3,12)))
}

class MoveZeroes
