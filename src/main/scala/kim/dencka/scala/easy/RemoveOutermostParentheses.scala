package kim.dencka.scala.easy

import scala.collection.mutable

object RemoveOutermostParentheses extends App {

  // 100% mem - 100% fast
  def removeOuterParentheses(s: String): String = {
    val stack: mutable.Stack[Char] = mutable.Stack.empty[Char]
    s.foldLeft(0, stack) { case ((cnt, st), ch) =>
      if (cnt == 0 && ch == '(') (cnt + 1, st)
      else if (cnt == 1 && ch == ')') (cnt - 1, st)
      else if (ch == '(') (cnt + 1, st.push(ch))
      else (cnt - 1, st.push(ch))
    }._2.mkString.reverse
  }

  // KIM_INFO THERE IS A SOLUTION FROM DISCUSSION
//  case class State(count: Int, running: StringBuilder)
//
//  def removeOuterParentheses(S: String): String = {
//    S.foldLeft(State(0, new StringBuilder))((acc, ch) => {
//      acc match {
//        case State(0, run) if ch == '(' => State(1, run)
//        case State(1, run) if ch == ')' => State(0, run)
//        case State(x, run) if ch == '(' => State(x + 1, run += ch)
//        case State(x, run) if ch == ')' => State(x - 1, run += ch)
//      }
//    }).running.toString
//  }

  println(removeOuterParentheses("(()())(())(()(()))"))

}
