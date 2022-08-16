package kim.dencka.easy.other

import kim.dencka.easy.other.FirstBadVersion.isBadVersion

// KIM_INFO IT SOLVED

class FirstBadVersion extends App {
  def firstBadVersion(n: Int): Int = {
    @annotation.tailrec
    def run(low: Int, high: Int): Int = {
      val mid = low + (high - low) / 2
      if (!isBadVersion(mid - 1) && isBadVersion(mid)) mid
      else if (isBadVersion(mid)) run(low, mid - 1)
      else run(mid + 1, high)
    }
    run(1, n)
  }
}

object FirstBadVersion {
  def isBadVersion(version: Int): Boolean = ???
}
