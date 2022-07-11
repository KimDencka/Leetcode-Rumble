package kim.dencka.easy.collection

object PalindromeNumber extends App {

  def isPalindrome(x: Int): Boolean =
    if (x.toString == x.toString.reverse && x >= 0) true
    else false

}
