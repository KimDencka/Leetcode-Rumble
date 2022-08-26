package kim.dencka.scala.easy.collection

import scala.collection.mutable

object CrawlerLogFolder extends App {

  def minOperations(logs: Array[String]): Int = {
    //    logs.foldLeft(mutable.Stack.empty[String]) {
    //        case (stack, "../") =>
    //          if (stack.nonEmpty) {
    //            stack.pop()
    //            stack
    //          }
    //          else stack
    //        case (stack, "./") => stack
    //        case (stack, str) => stack.push(str)
    //      }.size

    val stack = mutable.Stack.empty[String]

    for (s <- logs)
      if (stack.nonEmpty) {
        if (s == "../") stack.pop()
        else if (s != "./") stack.push(s)
      }
      else {
        if (s != "../" && s != "./")
          stack.push(s)
      }
    stack.size
  }
  println(minOperations(Array("d1/", "d2/", "./", "d3/", "../", "d31/")))

}
