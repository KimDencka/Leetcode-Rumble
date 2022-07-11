package kim.dencka.easy.tree

object MinimumAbsoluteDifferenceInBST extends App {

  class TreeNode(
      val value: Int,
      val left: TreeNode = null,
      val right: TreeNode = null
  )

  val bt1 = new TreeNode(
    5,
    new TreeNode(2, new TreeNode(2), new TreeNode(2)),
    new TreeNode(9, new TreeNode(9), new TreeNode(9))
  )

  val bt2 = new TreeNode(
    543,
    new TreeNode(384, right = new TreeNode(445)),
    new TreeNode(652, right = new TreeNode(699))
  )

  val bt3 = new TreeNode(
    236,
    new TreeNode(104, right = new TreeNode(227)),
    new TreeNode(701, right = new TreeNode(911))
  )

  def getMinimumDifference(root: TreeNode): Int = {
    def run(tree: TreeNode): List[Int] = {
      if (tree == null) List()
      else List(tree.value) ++ run(tree.left) ++ run(tree.right)
    }
    val list = run(root)
    @annotation.tailrec
    def go(myList: List[Int], holder: List[Int], current: Int, acc: Int): Int =
      myList match {
        case _ if holder.isEmpty => acc
        case Nil =>
          println(
            s"1: list: $myList, holder: $holder, current: $current, acc: $acc"
          )
          go(holder.tail, holder.tail, holder.head, acc)
        case h :: tail if acc > math.abs(h - current) =>
          println(
            s"2: list: $myList, holder: $holder, current: $current, acc: $acc"
          )
          go(tail, holder, current, math.abs(h - current))
        case _ :: tail =>
          println(
            s"3: list: $myList, holder: $holder, current: $current, acc: $acc"
          )
          go(tail, holder, current, acc)
      }
    go(list.tail, list.tail, list.head, 1000000)
  }

  println(getMinimumDifference(bt1))
  println(getMinimumDifference(bt2))
  println(getMinimumDifference(bt3))
}
