package kim.dencka.easy.collection

object PalindromeNumber extends App {

  def isPalindrome(x: Int): Boolean = {
    @annotation.tailrec
    def run(n: Int, digits: List[Int]): List[Int] =
      if (n < 10) n :: digits
      else run(n / 10, (n % 10) :: digits)

    val list = run(x, List.empty)

    if (x < 0) false
    else list == list.reverse
  }

  println(isPalindrome(100))
  println(isPalindrome(101))
  println(isPalindrome(-101))
  println(isPalindrome(2110112))
  println(isPalindrome(1000011))

}
