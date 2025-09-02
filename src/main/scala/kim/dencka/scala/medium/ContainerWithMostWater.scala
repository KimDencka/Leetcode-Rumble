package kim.dencka.scala.medium

object ContainerWithMostWater extends App {

  def maxArea(height: Array[Int]): Int = {
    @annotation.tailrec
    def run(i: Int, j: Int, max: Int): Int =
      if (i >= j) {
        max
      }
      else {
        val area = (j - i) * math.min(height(i), height(j))
        val newMax = if (area > max) area else max
        val (newI, newJ) = if (height(i) < height(j)) (i + 1, j) else (i, j - 1)
        run(newI, newJ, newMax)
      }

    run(0, height.length - 1, 0)
  }

  println(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))
  println(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3)))
  println(maxArea(Array(2, 3, 10, 5, 7, 8, 9)))
}
