package kim.dencka.easy.collection

object RomanToInteger extends App {

  def romanToInt(s: String): Int = {
    val map = Map(
      "I" -> 1,
      "V" -> 5,
      "X" -> 10,
      "L" -> 50,
      "C" -> 100,
      "D" -> 500,
      "M" -> 1000
    )
    val map2 = Map(
      "IV" -> 4,
      "IX" -> 9,
      "XL" -> 40,
      "XC" -> 90,
      "CD" -> 400,
      "CM" -> 900
    )
    @annotation.tailrec
    def run(str: String, acc: Int): Int = {
      val list = str.iterator.toSeq
      list match {
        case l if l.isEmpty => acc
        case l if l.length <= 1 => acc + map(l.head.toString)
        case h :: el :: tail if map2.contains(s"$h$el") =>
          run(tail.mkString, acc + map2(s"$h$el"))
        case h :: tail if map.contains(h.toString) =>
          run(tail.mkString, acc + map(h.toString))
      }
    }
    run(s, 0)
  }

  println(romanToInt("MCMXCVIII"))

}
