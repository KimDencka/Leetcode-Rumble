package kim.dencka.scala.easy.other

object MergeStringsAlternately extends App {

  def mergeAlternately(word1: String, word2: String): String = {
    @annotation.tailrec
    def loop(list1: List[Char], list2: List[Char], acc: StringBuilder): StringBuilder =
      (list1, list2) match {
        case (Nil, Nil)           => acc
        case (_, Nil)             => acc.append(list1.mkString)
        case (Nil, _)             => acc.append(list2.mkString)
        case (h1 :: t1, h2 :: t2) => loop(t1, t2, acc.append(h1).append(h2))
      }
    loop(word1.toList, word2.toList, new StringBuilder).toString
  }

  println(mergeAlternately("abc", "pqr")) // output: "apbqrs"

}
