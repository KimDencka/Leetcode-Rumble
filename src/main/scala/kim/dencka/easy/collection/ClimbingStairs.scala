package kim.dencka.easy.collection

object ClimbingStairs extends App {

  def climbStairs(n: Int): Int = {
    @annotation.tailrec
    def run(cur: Int, prev: Int, step: Int): Int = n match {
      case 1 => 1
      case 2 => 2
      case 3 => 3
      case _ if step != n => run(cur + prev, cur, step + 1)
      case _ => cur
    }
    run(3, 2, 3)
  }

  println(climbStairs(4))

}
