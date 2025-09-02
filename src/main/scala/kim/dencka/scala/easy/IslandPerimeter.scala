package kim.dencka.scala.easy

object IslandPerimeter extends App {

  val grid = Array(
    Array(0, 1, 0, 0),
    Array(1, 1, 1, 0),
    Array(0, 1, 0, 0),
    Array(1, 1, 0, 0)
  )

  // If there is no neighbor that is equal to one, then increase the perimeter by one.
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    var perimeter = 0
    for(r <- grid.indices; c <- grid(0).indices)
      if (grid(r)(c) == 1) {
        if (r == 0 || grid(r - 1)(c) == 0) perimeter += 1                  // up
        if (r == grid.length - 1 || grid(r + 1)(c) == 0) perimeter += 1    // down
        if (c == 0 || grid(r)(c - 1) == 0) perimeter += 1                  // left
        if (c == grid(r).length - 1 || grid(r)(c + 1) == 0) perimeter += 1 // right
      }
    perimeter
  }

  println(islandPerimeter(grid)) // 16

  // FROM DISCUSSION
  // def islandPerimeter(grid: Array[Array[Int]]): Int = {
  //  var perimeter = 0
  //  for (i <- grid.indices; j <- grid(0).indices)
  //    if (grid(i)(j) == 1) {
  //      perimeter += 4
  //      if (i > 0 && grid(i-1)(j) == 1) perimeter -= 2
  //      if (j > 0 && grid(i)(j-1) == 1) perimeter -= 2
  //    }
  //  perimeter
  // }

}
