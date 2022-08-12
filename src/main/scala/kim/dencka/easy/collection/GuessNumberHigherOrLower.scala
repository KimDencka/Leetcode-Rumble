package kim.dencka.easy.collection

import kim.dencka.easy.collection.GuessNumberHigherOrLower.guess

// KIM_INFO IT SOLVED

class GuessNumberHigherOrLower {
  def guessNumber(n: Int): Int = {
    @annotation.tailrec
    def run(low: Int, high: Int): Int = {
      val middle = low + (high - low) / 2

      guess(middle) match {
        case -1 => run(low, middle - 1)
        case 1 => run(middle + 1, high)
        case 0 => middle
      }
    }
    run(1, n)
  }
}

object GuessNumberHigherOrLower {
  // -1: Your guess is higher than the number I picked(i.e.num > pick)
  // 1: Your guess is lower than the number I picked(i.e.num < pick)
  // 0: your guess is equal to the number I picked(i.e.num == pick)

  def guess(k: Int): Int = ???

}
