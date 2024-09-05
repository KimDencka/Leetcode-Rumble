package kim.dencka.scala.medium.collection

object FindMissingObservations extends App {

  // efficient solution 100% time / memory
  def missingRolls(rolls: Array[Int], mean: Int, n: Int): Array[Int] = {
    val remaining = mean * (rolls.length + n) - rolls.sum
    if (remaining > n * 6 || remaining < n) Array.empty[Int]
    else {
      @annotation.tailrec
      def loop(index: Int, rest: Int, acc: Array[Int]): Array[Int] =
        if (index >= acc.length) acc
        else {
          val toAdd = math.min(6, rest - (n - index - 1)) // (n - index - 1) - позиции которые ещё не заполнены. вычитаем это число от rest чтобы оставить как минимум по 1 не заполненным позициям
          acc(index) = toAdd
          loop(index + 1, rest - toAdd, acc)
        }
      loop(0, remaining, Array.fill(n)(0))
    }
  }

  // elegant solution
//  import scala.math.Integral.Implicits._
//  def missingRolls(rolls: Array[Int], mean: Int, n: Int): Array[Int] = {
//    val missingSum = mean * (rolls.length + n) - rolls.sum
//    val (quotient, remainder) = missingSum /% n // (missingSum / n, missingSum % n); div-mod operator
//    if (missingSum < n || missingSum > 6 * n) Array.empty
//    else Array.tabulate(n)(i => if (i < remainder) quotient + 1 else quotient)
//  }

  println(missingRolls(Array(3, 2, 4, 3), 4, 2).toList) // 6, 6
  println(missingRolls(Array(1, 5, 6), 3, 4).toList)    // 6, 1, 1, 1
  println(missingRolls(Array(1, 2, 3, 4), 6, 4).toList) // empty
  println(missingRolls(Array(6, 1, 5, 2), 4, 4).toList) // 6, 6, 5, 1
}
