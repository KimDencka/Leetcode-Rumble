package kim.dencka.scala.medium

object LetterCombinationsOfAPhoneNumber extends App {

  val map = Map(
    '2' -> List("a", "b", "c"),
    '3' -> List("d", "e", "f"),
    '4' -> List("g", "h", "i"),
    '5' -> List("j", "k", "l"),
    '6' -> List("m", "n", "o"),
    '7' -> List("p", "q", "r", "s"),
    '8' -> List("t", "u", "v"),
    '9' -> List("w", "x", "y", "z")
  )

  // tailrec
  def letterCombinations(digits: String): List[String] = {
    @annotation.tailrec
    def loop(s: String, acc: List[String] = List("")): List[String] =
      if (s == "") acc
      else loop(s.tail, acc.flatMap(a => map(s.head).map(a + _)))

    if (digits.isEmpty) List.empty
    else loop(digits)
  }

  // backtracking
  // backtracking возвращает список всех возможных комбинаций, которые могут быть созданы с текущей цифры и далее
  // def letterCombinations(digits: String): List[String] = {
  //  def backtracking(index: Int, str: String): List[String] =
  //    if (str.length == digits.length) List(str)
  //    else {
  //      val letters = map(digits.charAt(index))
  //      letters.flatMap(ch => backtracking(index + 1, str + ch))
  //    }
  //  if (digits.isEmpty) List.empty
  //  else backtracking(0, "")
  // }

  println(letterCombinations("2345"))
}
