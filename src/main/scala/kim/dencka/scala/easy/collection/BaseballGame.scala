package kim.dencka.scala.easy.collection

import scala.collection.mutable

object BaseballGame extends App {

  val arr = Array("5", "-2", "4", "C", "D", "9", "+", "+")

  // 100% mem - 100% fast
  def calPoints(ops: Array[String]): Int = {
    val stack: mutable.Stack[Int] = mutable.Stack.empty[Int]
    for (el <- ops)
      if (el == "C") stack.pop()
      else if (el == "D") stack.push(stack.top * 2)
      else if (el == "+") {
        val x = stack.pop()
        val y = stack.pop()
        stack.push(y, x, x + y)
      }
      else stack.push(el.toInt)
    stack.sum
  }

//  def calPoints(ops: Array[String]): Int =
//    ops
//      .foldLeft(List[Int]()) {
//        case (st @ a :: b :: _, "+") => a + b :: st
//        case (st @ a :: _, "D") => a + a :: st
//        case (_ :: st, "C") => st
//        case (st, num) => num.toInt :: st
//      }
//      .sum

  println(calPoints(arr))

}
