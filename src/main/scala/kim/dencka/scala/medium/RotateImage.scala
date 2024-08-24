package kim.dencka.scala.medium

object RotateImage extends App {

  def rotate(matrix: Array[Array[Int]]): Unit = {
    val n = matrix.length
    for (layer <- 0 to n) { // Iterate through matrix layers (from outer to inner)
      val first = layer
      val last  = n - 1 - layer
      for (i <- first until last) {
        val offset = i - first
        val top = matrix(first)(i) // hold top-left element

        matrix(first)(i) = matrix(last - offset)(first) // move bottom-left to top-left
        matrix(last - offset)(first) = matrix(last)(last - offset) // move bottom-right to bottom-left
        matrix(last)(last - offset) = matrix(i)(last) // move top-right to bottom-right
        matrix(i)(last) = top // move saved top-left to top-right
      }
    }
  }

  val array = Array(
    Array(1, 2, 3, 4),
    Array(5, 6, 7, 8),
    Array(9, 10, 11, 12),
    Array(13, 14, 15, 16)
  )
  rotate(array)
  println(array.foreach(v => println(v.toList)))
  // output:
  // (13, 9, 5, 1)
  // (14, 10, 6, 2)
  // (15, 11, 7, 3)
  // (16, 12, 8, 4)

  // with factory methods
  // array.transpose.map(_.reverse)

}
