package kim.dencka.scala.medium.collection

object ProductOfArrayExceptSelf extends App {

  // elegant
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val _left  = nums.scanLeft(1)(_ * _).init
    val _right = nums.scanRight(1)(_ * _).tail

    _left zip _right map { case (l, r) => l * r }
  }

  // a little bit faster
//  def productExceptSelf(nums: Array[Int]): Array[Int] = {
//    val (zeros, nonZero, product) = nums.foldLeft(0, 1, 1) {
//      case ((z, non, prod), num) if num == 0 => (z + 1, non, prod * num)
//      case ((z, non, prod), num)             => (z, non * num, prod * num)
//    }
//    if (zeros > 1) {
//      Array.fill(nums.length)(0)
//    } else if (zeros == 1) {
//      val result = Array.fill(nums.length)(0)
//      result(nums.indexOf(0)) = nonZero
//      result
//    } else {
//      for (i <- nums.indices) nums(i) = (product * math.pow(nums(i), -1)).toInt
//      nums
//    }
//  }

  println(productExceptSelf(Array(1, 2, 3, 4)).toList)      // output: 24,12,8,6
  println(productExceptSelf(Array(-1, 1, 0, -3, 3)).toList) // output: 0,0,9,0,0

}
