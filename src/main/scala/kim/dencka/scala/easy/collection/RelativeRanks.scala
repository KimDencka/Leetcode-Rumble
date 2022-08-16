package kim.dencka.scala.easy.collection

object RelativeRanks extends App {
  def findRelativeRanks(score: Array[Int]): Array[String] = {
    val sorted = score.sortWith(_ > _)
    sorted
      .foldLeft(score.map(_.toString), 1) { case ((acc, cnt), num) =>
        val index = score.indexOf(num)
        if (cnt == 1) (acc.updated(index, "Gold Medal"), cnt + 1)
        else if (cnt == 2) (acc.updated(index, "Silver Medal"), cnt + 1)
        else if (cnt == 3) (acc.updated(index, "Bronze Medal"), cnt + 1)
        else (acc.updated(index, cnt.toString), cnt + 1)
      }
      ._1
  }

  println(findRelativeRanks(Array(1, 2, 3, 4, 5, 6, 7, 8, 9)).toList)
}
