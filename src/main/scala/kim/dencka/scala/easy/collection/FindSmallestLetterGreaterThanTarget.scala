package kim.dencka.scala.easy.collection

object FindSmallestLetterGreaterThanTarget extends App {

  def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
//    letters.find(c => c > target).getOrElse(letters(0))

    @annotation.tailrec
    def run(low: Int, high: Int): Char =
      if (low < high) {
        val mid = low + (high - low) / 2
        if (letters(mid) <= target) run(mid + 1, high)
        else run(low, mid)
      }
      else letters(low % letters.length)

    run(0, letters.length)
  }

  println(nextGreatestLetter(Array('e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'), 'e'))

}
