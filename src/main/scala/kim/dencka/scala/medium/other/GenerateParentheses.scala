package kim.dencka.scala.medium.other

object GenerateParentheses extends App {

  def generateParenthesis(n: Int): List[String] = {
    def loop(str: String, open: Int, close: Int, acc: List[String]): List[String] =
      if (open == 0 && close == 0) str :: acc
      else {
        val opens = if (open > 0) loop(str + "(", open - 1, close, acc) else acc
        if (close > open) loop(str + ")", open, close - 1, opens) else opens
      }
    loop("", n, n, Nil)
  }
  
  println(generateParenthesis(3)) // output: ["((()))","(()())","(())()","()(())","()()()"]; p.s. maybe reversed

}
