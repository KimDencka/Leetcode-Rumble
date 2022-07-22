package kim.dencka.easy.other

object ValidPalindrome extends App {

  val str = "A man, a plan, a canal: Panama"
  val str2 = "race a car"

  def isPalindrome(s: String): Boolean = {
    val filtered = s.filter(_.isLetterOrDigit)
    filtered.equalsIgnoreCase(filtered.reverse)
  }

  println(isPalindrome(str))
  println(isPalindrome(str2))

}
