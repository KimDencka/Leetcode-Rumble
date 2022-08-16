package kim.dencka.scala.easy.collection

object BestTimeToBuyAndSellStock extends App {

// FIXME NEED TO FIX
// MEMORY LIMIT EXCEEDED (WORKING SOLUTION)
  def maxProfit(prices: Array[Int]): Int = {
    prices.tail.foldLeft(0, prices.head) { case ((acc, cur), el) =>
      if (cur - el > 0) {
        (acc, el)
      } else {
        val diff = math.abs(cur - el)
        if (diff > acc) (diff, cur)
        else (acc, cur)
      }
    }._1
  }

  println(maxProfit(Array(1)))
  println(maxProfit(Array(7, 1, 5, 3, 6, 4)))

  // KIM_INFO THERE IS A SOLUTION FROM DISCUSSION (I LIKE IT)
//  def maxProfit(prices: Array[Int]): Int =
//    prices.foldLeft((Int.MaxValue, 0)) {
//      case ((minPrice, maxProfit), price) => (minPrice min price, maxProfit max (price - minPrice))
//    }._2

}