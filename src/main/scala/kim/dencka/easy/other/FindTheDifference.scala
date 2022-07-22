package kim.dencka.easy.other

object FindTheDifference extends App {

  def findTheDifference(s: String, t: String): Char = {
    (t.sum - s.sum).toChar

//    (t diff s).head // valid
//    (t.map(_.toInt).sum - s.map(_.toInt).sum).toChar // valid
  }

  println(findTheDifference("qwer", "qwert"))

  //  KIM_INFO BITWISE OPERATION
//  def findTheDifference(s: String, t: String): Char =
//    t.foldLeft(s.foldLeft(0)(_^_))(_^_).toChar

  //  def findTheDifference(s: String, t: String): Char = {
  //        (s.toCharArray ++ t.toCharArray).foldLeft(0)(_^_).toChar
  //    }
}