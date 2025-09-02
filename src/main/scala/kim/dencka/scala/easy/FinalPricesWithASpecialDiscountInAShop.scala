package kim.dencka.scala.easy

import scala.collection.mutable

object FinalPricesWithASpecialDiscountInAShop extends App {

  // 100% mem - 100% fast
  def finalPrices(prices: Array[Int]): Array[Int] = {
    val stack: mutable.Stack[Int] = mutable.Stack.empty[Int]

    for (i <- prices.length - 1 to (0, -1)) {
      while (stack.nonEmpty && stack.top > prices(i))
        stack.pop()

      val price = prices(i)
      if (stack.nonEmpty) {
        prices.update(i, price - stack.top)
      }
      stack.push(price)
    }
    prices
  }

  println(finalPrices(Array(2, 8, 4, 6, 2, 3)).toList)

}
