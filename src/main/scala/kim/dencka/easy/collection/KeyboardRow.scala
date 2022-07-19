package kim.dencka.easy.collection

object KeyboardRow extends App {

  def findWords(words: Array[String]): Array[String] = {
    val rows = Array[String]("qwertyuiop", "asdfghjkl", "zxcvbnm")
    words.filter { word =>
      rows.foldLeft(false) { (b, row) =>
        b || word.toLowerCase.forall(c => row.contains(c))
      }
    }
  }

// THE SAME. (MESS)
//  def findWords(words: Array[String]): Array[String] = {
//    val rows = Array("qwertyuiop", "asdfghjkl", "zxcvbnm")
//    rows
//      .flatMap { str =>
//        words.map { word =>
//          val check = word.toLowerCase.forall { ch =>
//            str.contains(ch)
//          }
//          if (check) word
//          else ""
//        }
//      }
//      .filter(_.nonEmpty)
//  }

  println(findWords(Array("Hello", "Alaska", "Dad", "Peace")).toList)

}
