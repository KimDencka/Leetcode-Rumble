package kim.dencka.scala.easy

object MaximumNestingDepthOfTheParentheses extends App {

  def maxDepth(s: String): Int = {
    import scala.collection._
    s.foldLeft(mutable.Stack.empty[Char], 0, 0) { case ((stack, depth, cnt), ch) =>
      if (ch == '(') {
        (stack.push(ch), depth, cnt + 1)
      }
      else if (ch == ')') {
        stack.pop()
        (stack, math.max(depth, cnt), cnt - 1)
      }
      else {
        (stack, depth, cnt)
      }
    }._2
  }

  Vector(
    maxDepth("(1+(2*3)+((8)/4))+1"), // 3
    maxDepth("(1)+((2))+(((3)))")    // 3
  ).foreach(println)


  // KIM_INFO THERE IS A SOLUTION FROM DISCUSSION
//  def maxDepth(s: String): Int = {
//    s.scanLeft(0)((a, b) => b match {
//      case '(' => a + 1
//      case ')' => a - 1
//      case _ => a
//    }).max
//  }
}
