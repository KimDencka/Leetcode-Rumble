package kim.dencka.scala.easy.other

import scala.collection.mutable

object BackspaceStringCompare extends App {

  val s = "a#b"
  val t = "b"

  def backspaceCompare(s: String, t: String): Boolean =
    run(s, mutable.Stack.empty[Char]) == run(t, mutable.Stack.empty[Char])

  def run(str: String, stack: mutable.Stack[Char]): mutable.Stack[Char] = {
    for (i <- str) {
      if (stack.nonEmpty && i == '#') stack.pop()
      if (i != '#') stack.push(i)
    }
    stack
  }

  println(backspaceCompare(s, t))
}
