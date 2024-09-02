package kim.dencka.scala.easy.other

object GreatestCommonDivisorOfStrings extends App {

  // solution: https://leetcode.com/problems/greatest-common-divisor-of-strings/solution/
  def gcdOfStrings(str1: String, str2: String): String =
    if (str1 + str2 != str2 + str1) ""
    else str1.substring(0, gcd(str1.length, str2.length))

  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  //  // brute force
//  def gcdOfStrings(str1: String, str2: String): String =
//    if (str1.length > str2.length) findGDC(str1, str2, str2)
//    else findGDC(str2, str1, str1)
//
//  @annotation.tailrec
//  def findGDC(long: String, short: String, acc: String): String =
//    if ((long.split(acc).isEmpty && short.split(acc).isEmpty) || acc.isEmpty) acc
//    else findGDC(long, short, acc.init)

  println(gcdOfStrings("LEET", "CODE")) // output: ""
  println(                              // output: TAUXX
    gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX")
  )
}
