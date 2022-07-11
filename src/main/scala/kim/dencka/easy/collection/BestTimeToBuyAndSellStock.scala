package kim.dencka.easy.collection

object BestTimeToBuyAndSellStock extends App {

  def maxProfit(prices: Array[Int]): Int = {
    ???
  }
// FIXME NEED TO FIX
// MEMORY LIMIT EXCEEDED (WORKING SOLUTION)
//  def maxProfit(prices: Array[Int]): Int = {
//    if (prices.length > 1) {
//      val profits = for {
//        i <- prices.indices
//        j <- i + 1 until prices.length
//      } yield {
//        prices(j) - prices(i)
//      }
//      val res = profits.drop(1).foldLeft(profits.head) { (prev, el) =>
//        if (el > prev) el
//        else prev
//      }
//      if (res > 0) res
//      else 0
//    } else {
//      0
//    }
//  }

  println(maxProfit(Array(1)))
  println(maxProfit(Array(7, 1, 5, 3, 6, 4)))

}