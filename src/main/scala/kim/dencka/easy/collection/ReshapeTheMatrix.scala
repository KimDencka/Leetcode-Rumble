package kim.dencka.easy.collection

object ReshapeTheMatrix extends App {

  def matrixReshape(mat: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    val valid = mat.length * mat.head.length == r * c
    val flatted = mat.flatten

    @annotation.tailrec
    def run(arr: Array[Int], cnt: Array[Int], acc: Array[Array[Int]]): Array[Array[Int]] =
      if (arr.isEmpty) acc :+ cnt
      else if (cnt.length < c) {
        println(s"1: arr: ${arr.toList}, cnt: ${cnt.toList}")
        run(arr.tail, cnt :+ arr.head, acc)
      } else {
        println(s"2: arr: ${arr.toList}, cnt: ${cnt.toList}")
        run(arr.tail, Array(arr.head), acc :+ cnt)
      }

    if (valid) run(flatted, Array.empty, Array.empty)
    else mat
  }

// WITH FACTORY METHODS
//  def matrixReshape(mat: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
//    if (mat.length * mat(0).length != r * c) mat
//    else mat.flatten.grouped(c).toArray
//  }

  println(matrixReshape(Array(Array(1, 2, 3), Array(4, 5, 6)), 2, 2).map(_.toList).toList)

}
