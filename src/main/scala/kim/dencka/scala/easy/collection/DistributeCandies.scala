package kim.dencka.scala.easy.collection

object DistributeCandies extends App {

  def distributeCandies(candyType: Array[Int]): Int = {
    math.min(candyType.toSet.size, candyType.length / 2)
  }

  println(distributeCandies(Array(1, 1, 2, 2, 3, 3)))

}
