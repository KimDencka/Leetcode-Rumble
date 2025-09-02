package kim.dencka.scala.easy

object CanPlaceFlowers extends App {

  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    @annotation.tailrec
    def loop(i: Int, count: Int): Boolean =
      if (count >= n) true
      else if (i >= flowerbed.length) false
      else if (
        flowerbed(i) == 0 && (i == 0 || flowerbed(i - 1) == 0) && (i == flowerbed.length - 1 || flowerbed(i + 1) == 0)
      ) {
        loop(i + 2, count + 1) // пропускаем следующую позицию, т.к. посадили цветок
      } else {
        loop(i + 1, count) // пропускаем текущий, если равен 1
      }

    loop(0, 0)
  }

  println(canPlaceFlowers(Array(1, 0, 0, 0, 1), 1)) // output: true
  println(canPlaceFlowers(Array(1, 0, 0, 0, 1), 2)) // output: false
  println(canPlaceFlowers(Array(0, 0, 0, 0, 0), 3)) // output: true
  println(canPlaceFlowers(Array(0, 0, 0, 0, 0), 4)) // output: false
  println(canPlaceFlowers(Array(0), 1))             // output: true

}
