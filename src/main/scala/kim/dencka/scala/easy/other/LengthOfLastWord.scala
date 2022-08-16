package kim.dencka.scala.easy.other

object LengthOfLastWord extends App {
  def lengthOfLastWord(s: String): Int =
    s.split(" ").toList.takeRight(1).head.length

  println(lengthOfLastWord(" sdaf  sadfh las woe woei   weo w   weiur  weiughj poi     "))

  //  def lengthOfLastWord(s: String): Int = {
  //    @annotation.tailrec
  //    def run(str: String, cnt: Int): Int = str match {
  //      case st if st.takeRight(1) != " " & st.nonEmpty=> run(str.init, cnt + 1)
  //      case _ => cnt
  //    }
  //    run(s.trim, 0)
  //  }
}
