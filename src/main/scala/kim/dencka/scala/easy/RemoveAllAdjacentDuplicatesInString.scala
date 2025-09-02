package kim.dencka.scala.easy

import scala.collection.mutable

object RemoveAllAdjacentDuplicatesInString extends App {

  def removeDuplicates(s: String): String =
    s.foldLeft(mutable.Stack.empty[Char]) { (stack, ch) =>
      if (stack.isEmpty) stack.push(ch)
      else if (stack.top == ch) {
        stack.pop()
        stack
      }
      else stack.push(ch)
    }.mkString.reverse

  println(removeDuplicates("abbaca"))
}
