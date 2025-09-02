package kim.dencka.scala.easy

object KidsWithTheGreatestNumberOfCandies extends App {

  def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] = {
    val max    = candies.max
    val result = Array.ofDim[Boolean](candies.length)
    result.indices.foreach { i =>
      if (max <= candies(i) + extraCandies) result(i) = true
    }
    result.toList
  }

  println(kidsWithCandies(Array(2, 3, 5, 1, 3), 3)) // output: List(true,true,true,false,true)
  println(kidsWithCandies(Array(4, 2, 1, 1, 2), 1)) // output: List(true,false,false,false,false)

}
