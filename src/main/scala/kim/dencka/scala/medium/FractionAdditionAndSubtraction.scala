package kim.dencka.scala.medium

object FractionAdditionAndSubtraction extends App {

  def fractionAddition(expression: String): String = {
    val (lastStr, acc) = expression.foldRight("", List.empty[String]) {
      case (ch, (str, acc)) if ch == '-' || ch == '+' => ("", s"$ch$str" :: acc)
      case (ch, (str, acc)) => (s"$ch$str", acc)
    }
    val fractions = (if (lastStr.nonEmpty) lastStr :: acc else acc).map(_.split("/").map(_.toInt))

    if (fractions.forall(pair => pair(1) == fractions.head(1))) {
      val (numeratorSum, denominator) = (fractions.map(_.apply(0)).sum, fractions.head(1))
      reduceFraction(numeratorSum, denominator)
    } else {
      val commonDenominator = fractions.map(_.apply(1)).reduce(lcm)
      val numeratorSum = fractions.map(pair => pair(0) * (commonDenominator / pair(1))).sum
      reduceFraction(numeratorSum, commonDenominator)
    }

  }

  def reduceFraction(a: Int, b: Int): String = {
    val GCD = gcd(a, b)
    if (GCD != 1) s"${a / GCD.abs}/${b / GCD.abs}" else s"$a/$b"
  }

  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  def lcm(a: Int, b: Int): Int = (a * b).abs / gcd(a, b)

  println(fractionAddition("-1/2+1/2"))             // "0/1"
  println(fractionAddition("-1/2+1/2+1/3"))         // "1/3"
  println(fractionAddition("1/3-1/2"))              // "-1/6"
  println(fractionAddition("-1/2+1/9+1/8-6/7"))     // "-565/504"
  println(fractionAddition("-1/180+1/9+1/72-6/90")) // "19/360"
}
