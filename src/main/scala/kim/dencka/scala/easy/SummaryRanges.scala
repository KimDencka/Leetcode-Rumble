package kim.dencka.scala.easy

object SummaryRanges extends App {

  def summaryRanges(nums: Array[Int]): List[String] = {
    @annotation.tailrec
    def run(arr: Array[Int], list: List[Int], acc: List[String]): List[String] = arr match {
      case Array() =>
        if (list.length == 1) acc :+ list.head.toString
        else acc :+ s"${list.head}->${list.last}"
      case _ if arr.head - 1 == list.last => run(arr.tail, list :+ arr.head, acc)
      case _ =>
        if (list.length == 1) run(arr.tail, List(arr.head), acc :+ list.head.toString)
        else run(arr.tail, List(arr.head), acc :+ s"${list.head}->${list.last}")
    }

    if (nums.isEmpty) List.empty
    else run(nums.tail, List(nums.head), List.empty[String])
  }
  println(summaryRanges(Array(0, 1, 2, 4, 6, 7, 8, 10)))
  println(summaryRanges(Array(0, 2, 4, 6, 8, 10, 12)))
  println(summaryRanges(Array()))

}
