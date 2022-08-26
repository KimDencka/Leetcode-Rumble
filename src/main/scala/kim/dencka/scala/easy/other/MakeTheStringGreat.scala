package kim.dencka.scala.easy.other

import scala.collection.mutable

object MakeTheStringGreat extends App {

  // 100% mem - 100% fast
  def makeGood(s: String): String = {
    val stack = mutable.Stack.empty[Char]
    for (i <- s.indices)
      if (stack.nonEmpty) {
        if (stack.top + 32 == s(i) || stack.top - 32 == s(i)) {
          stack.pop()
        } else stack.push(s(i))
      } else stack.push(s(i))

    stack.mkString.reverse
  }

  Vector(
    makeGood("leEeetcode"),
    makeGood("abBAcC"),
    makeGood("s"),
    makeGood("")
  ).foreach(println)

}
