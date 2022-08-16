package kim.dencka.scala.easy.collection

object ContainsDuplicate extends App {

  val arr1 = Array(1,1,1,3,3,4,3,2,4,2)
  val arr2 = Array(1,2,3,4)

  def containsDuplicate(nums: Array[Int]): Boolean = {
    @annotation.tailrec
    def checkDuplicates(arr: Array[Int], map: Map[Int, Int]): Boolean = {
      val cur = arr.head
      val upgradedMap: Map[Int, Int] = map + (cur -> (map.getOrElse(cur, 0) + 1))
      if (upgradedMap(cur) > 1) true
      else if (arr.length != 1) checkDuplicates(arr.tail, upgradedMap)
      else false
    }
    checkDuplicates(nums, Map.empty[Int, Int])
  }

  println(containsDuplicate(arr1))
  println(containsDuplicate(Array(1)))
  println(containsDuplicate(arr2))

}
