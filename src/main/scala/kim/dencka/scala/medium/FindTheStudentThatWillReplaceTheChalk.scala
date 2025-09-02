package kim.dencka.scala.medium

object FindTheStudentThatWillReplaceTheChalk extends App {

  // prefix sum
  def chalkReplacer(chalk: Array[Int], k: Int): Int = {
    @annotation.tailrec
    def loop(index: Int, n: Int): Int =
      if (chalk(index) > n) index
      else loop((index + 1) % chalk.length, n - chalk(index))

    loop(0, (k % chalk.map(_.toLong).sum).toInt)
  }

//  // brute force
//  def chalkReplacer(chalk: Array[Int], k: Int): Int = {
//    @annotation.tailrec
//    def loop(index: Int, n: Int): Int =
//      if (chalk(index) > n) index
//      else loop((index + 1) % chalk.length, n - chalk(index))
//
//    loop(0, k)
//  }

  val arr = Array(3, 4, 1, 2)
  println(chalkReplacer(arr, 25)) // output: 1

}
