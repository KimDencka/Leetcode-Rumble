package kim.dencka.easy.collection

object PlusOne extends App {

  def plusOne(digits: Array[Int]): Array[Int] = {
    @annotation.tailrec
    def run(arr: Array[Int], acc: Array[Int], cnt: Int): Array[Int] =
      arr match {
        case Array(x) if x == 9 =>
          println(s"0: acc: ${acc.toList}, arr: ${arr.toList}, cnt: $cnt")
          Array(1, 0).concat(acc)
        case Array(x) =>
          println(s"0: acc: ${acc.toList}, arr: ${arr.toList}, cnt: $cnt")
          Array(x + 1).concat(acc)
        case ar if ar(cnt) == 9 =>
          println(s"1: acc: ${acc.toList}, ar: ${ar.toList}, cnt: $cnt")
          run(ar.init, 0 +: acc, cnt - 1)
        case ar if ar(cnt) != 9 =>
          println(s"2: acc: ${acc.toList}, ar: ${ar.toList}, cnt: $cnt")
          (ar.init :+ ar(cnt) + 1).concat(acc)
      }
    run(digits, Array(), digits.length - 1)
  }

  println(plusOne(Array(9)).toList)
  println(plusOne(Array(1, 2, 3)).toList)
  println(plusOne(Array(9, 9, 9, 9, 9)).toList)
  println(plusOne(Array(8, 9, 9, 9, 9)).toList)
  println(plusOne(Array(5)).toList)

}
