package kim.dencka.scala.easy.collection

object SingleNumber extends App {

  val arr = Array(2, 2, 1)
  val arr2 = Array(4, 1, 2, 1, 2)

  // FIXME MUST RESOLVE (SOLUTION ACCEPTED BUT I THINK IT TAKES TOO MUCH TIME AND MEMORY)

  def singleNumber(nums: Array[Int]): Int = {
    @annotation.tailrec
    def run(arr: Array[Int]): Int = arr match {
      case ar if nums.count(_ == ar.head) == 1 => ar.head
      case ar => run(ar.tail)
    }
    run(nums.distinct)
  }

  println(singleNumber(arr))
  println(singleNumber(arr2))

}

object MustResolve
