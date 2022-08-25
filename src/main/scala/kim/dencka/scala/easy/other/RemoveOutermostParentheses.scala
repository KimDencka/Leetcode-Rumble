package kim.dencka.scala.easy.other

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

  println(removeOuterParentheses("(()())(())(()(()))"))

}
