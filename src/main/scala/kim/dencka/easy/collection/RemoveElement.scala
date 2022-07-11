package kim.dencka.easy.collection

object RemoveElement extends App {

  val nums = Array(0, 1, 2, 2, 3, 0, 4, 2)
  val e = 2

  val res = nums.foldLeft(0, 0, Array.empty[Int]) { case ((cnt, ind, arr), current) =>
    if (e != current) {
      (cnt + 1, ind + 1, arr :+ current)
    }
    else {
      (cnt, ind + 1, arr)
    }
  }

  println(res._1)
  println(res._3.toList)

  //  submitted solution
  //  def removeElement(nums: Array[Int], `val`: Int): Int = {
  //    val res = nums.foldLeft(0, 0, Array.empty[Int]) { case ((cnt, ind, arr), current) =>
  //      if (`val` != current) {
  //        (cnt + 1, ind + 1, arr :+ current)
  //      } else {
  //        (cnt, ind + 1, arr)
  //      }
  //    }
  //    for(i <- res._3.indices)
  //      nums(i) = res._3(i)
  //    res._1
  //  }

}
