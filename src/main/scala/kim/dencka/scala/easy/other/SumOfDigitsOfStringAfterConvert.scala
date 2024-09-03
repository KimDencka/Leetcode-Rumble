package kim.dencka.scala.easy.other

object SumOfDigitsOfStringAfterConvert extends App {

  // efficient solution. 100% time / space
  def getLucky(s: String, k: Int): Int = {
    @annotation.tailrec
    def loop(target: Int, n: Int): Int =
      if (target < 10 || n == 0) target
      else loop(splitAndSum(target), n - 1)

    loop(sumDigits(s.toList.map(_ - 'a' + 1)), k - 1)
  }

  @annotation.tailrec
  def sumDigits(list: List[Int], acc: Int = 0): Int =
    list match {
      case Nil          => acc
      case head :: tail =>
        if (head >= 10) sumDigits(tail, acc + splitAndSum(head))
        else sumDigits(tail, acc + head)
    }

  @annotation.tailrec
  def splitAndSum(num: Int, acc: Int = 0): Int =
    if (num < 10) acc + num
    else splitAndSum(num / 10, acc + (num % 10))

  // elegant solution
//  def getLucky(s: String, k: Int): Int =
//    (0 to k)
//      .foldLeft("") {
//        case (acc, _) if acc.isEmpty =>
//          s.toCharArray.map(c => (c - 'a' + 1).toString).mkString
//        case (acc, _)                =>
//          acc.toCharArray.map(c => c - '0').sum.toString
//      }
//      .toInt

  println(getLucky("leetcode", 2))           // 6
  println(getLucky("iiii", 1))               // 36
  println(getLucky("zbax", 2))               // 8
  println(getLucky("vbyytoijnbgtyrjlsc", 2)) // 15

}
