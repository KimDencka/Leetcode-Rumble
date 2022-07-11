package kim.dencka.easy.collection

object SqrtX extends App {
  val t1 = System.nanoTime
  def mySqrt(x: Int): Int = {
    @annotation.tailrec
    def sqrt(prev: Int, cnt: Int): Int =
      if (cnt * cnt > x || cnt * cnt < 0) {
        println(s"1: pow: ${cnt * cnt}, cnt: $cnt, prev: $prev\n1: res: $x")
        prev
      }
      else {
        println(s"2: pow: ${cnt * cnt}, cnt: $cnt, prev: $prev\n2: res: $x")
        sqrt(cnt, cnt + 1)
      }
    sqrt(0, 1)
  }
  println(mySqrt(2147395600))
  val duration = (System.nanoTime - t1) / 1e9d
  println(duration)
}
