package kim.dencka.scala.easy

object AddBinary extends App {
  def addBinary(a: String, b: String): String = {
    def addTwoBinary(a: Short, b: Short): String =
      if (a == 1 && b == 1) {
        "10"
      }
      else if (a == 0 && b == 0) {
        "0"
      }
      else {
        "1"
      }
    @annotation.tailrec
    def run(str1: String, str2: String, mem: Byte, acc: String): String =
      (str1, str2) match {
        case (n1, n2) if n1.length == 1 & n2.length == 1 =>
          val res = addTwoBinary(n1.toShort, n2.toShort)
          println(s"1: res: $res, acc: $acc, n1: ${n1.head.toString}, n2: ${n2.head.toString}, mem: $mem")
          if (mem != 1) {
            res + acc
          }
          else {
            11 + acc
          }
        case (n1, n2) if n1.nonEmpty & n2.nonEmpty =>
          val res =
            addTwoBinary(n1.head.toString.toShort, n2.head.toString.toShort)
          if (mem == 1) {
            if (res.length == 2) {
              println(s"2_1: res: $res, acc: $acc, mem: $mem")
              run(n1.tail, n2.tail, 1, 1 + acc)
            }
            else {
              if (res == "1") {
                println(s"2_2: res: $res, acc: $acc, mem: $mem")
                run(n1.tail, n2.tail, 1, 0 + acc)
              }
              else {
                println(s"2_3: res: $res, acc: $acc, mem: $mem")
                run(n1.tail, n2.tail, 0, mem + acc)
              }
            }
          }
          else {
            if (res.length == 2) {
              println(s"2_4: res: $res, acc: $acc, mem: $mem")
              run(n1.tail, n2.tail, 1, 0 + acc)
            }
            else {
              println(s"2_5: res: $res, acc: $acc, mem: $mem")
              run(n1.tail, n2.tail, 0, res + acc)
            }
          }
        case (n1, n2) if n1.nonEmpty & n2.isEmpty =>
          val r = addTwoBinary(n1.head.toString.toShort, mem)
          if (r.length == 2) {
            if (n1.drop(1).isEmpty) {
              println(s"3_1: r: $r, acc: $acc, n1: ${n1.head.toString}, mem: $mem")
              run(n1.tail, n2, 0, r + acc)
            }
            else {
              println(s"3_2: r: $r, acc: $acc, n1: ${n1.head.toString}, mem: $mem")
              run(n1.tail, n2, 1, 0 + acc)
            }
          }
          else {
            println(s"3_3: r: $r, acc: $acc, n1: ${n1.head.toString}, mem: $mem")
            run(n1.tail, n2, 0, r + acc)
          }
        case (n1, n2) if n1.isEmpty & n2.nonEmpty =>
          val r = addTwoBinary(n2.head.toString.toShort, mem)
          if (r.length == 2) {
            if (n2.drop(1).isEmpty) {
              println(s"4_1: r: $r, acc: $acc, n2: ${n2.head.toString}, mem: $mem")
              run(n1, n2.tail, 0, r + acc)
            }
            else {
              println(s"4_2: r: $r, acc: $acc, n2: ${n2.head.toString}, mem: $mem")
              run(n1, n2.tail, 1, 0 + acc)
            }
          }
          else {
            println(s"4_3: r: $r, acc: $acc, n2: ${n2.head.toString}, mem: $mem")
            run(n1, n2.tail, 0, r + acc)
          }
        case _ => acc
      }
    run(a.reverse, b.reverse, 0, "")
  }

  println(addBinary("1111", "1111"))

}
