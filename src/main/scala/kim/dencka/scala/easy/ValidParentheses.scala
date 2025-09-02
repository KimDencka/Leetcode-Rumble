package kim.dencka.scala.easy

import scala.collection.mutable

object ValidParentheses extends App {

  val s = "{{{}}()()}]{()}"

  // iteration -> memory
  def isValid(s: String): Boolean = {
    val map: Map[Char, Char] = Map(')' -> '(', '}' -> '{', ']' -> '[')
    val stack: mutable.Stack[Char] = mutable.Stack[Char]()

    for (i <- 0 until s.length)
      if (stack.nonEmpty && map.contains(s(i)) && stack.top == map(s(i))) {
        stack.pop
      }
      else {
        stack.push(s(i))
      }

    stack.isEmpty
  }

  // Recursive ideal solution
//    def isValid(s: String): Boolean = {
//      val map = Map('(' -> ')', '{' -> '}', '[' -> ']')
//      val parentheses: mutable.Stack[Char] = mutable.Stack()
//
//      @annotation.tailrec
//      def run(stack: mutable.Stack[Char], cnt: Int): Boolean = {
//        if (cnt == s.length) stack.isEmpty
//        else if (map.contains(s(cnt))) {
//          run(stack.push(s(cnt)), cnt + 1)
//        }
//        else if (stack.isEmpty) false
//        else if (map(stack.top) == s(cnt)) {
//          stack.pop()
//          run(stack, cnt + 1)
//        }
//        else false
//      }
//
//      run(parentheses, 0)
//    }

  // First not ideal solution
//    def isValid(s: String): Boolean = {
//    val map = Map('(' -> ')', '{' -> '}', '[' -> ']')
//    @annotation.tailrec
//    def go(tailing: String, acc: List[Char]): Boolean = tailing match {
//      case ss if ss.nonEmpty =>
//        val el = ss.head
//        if (map.contains(el)) {
//          go(ss.tail, el +: acc)
//        }
//        else if (acc.headOption.flatMap(map.get).contains(el)) {
//          go(ss.tail, acc.tail)
//        }
//        else {
//          false
//        }
//      case _ if acc.nonEmpty => false
//      case _ => true
//    }
//    if (s.length == 1) {
//      false
//    }
//    else {
//      go(s, List())
//    }
//  }

  println(isValid(s))

}
