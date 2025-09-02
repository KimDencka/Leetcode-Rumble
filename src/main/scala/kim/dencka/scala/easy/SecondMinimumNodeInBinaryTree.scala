package kim.dencka.scala.easy

object SecondMinimumNodeInBinaryTree extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val bt1 =
    new TreeNode(
      1,
      new TreeNode(1),
      new TreeNode(2)
    )

  val bt2 =
    new TreeNode(
      2,
      new TreeNode(2),
      new TreeNode(5, new TreeNode(5), new TreeNode(7))
    )

  val bt3 =
    new TreeNode(
      2,
      new TreeNode(2),
      new TreeNode(3, new TreeNode(3), new TreeNode(3))
    )

  def findSecondMinimumValue(root: TreeNode): Int = {
    def validate(root: TreeNode): Boolean = root match {
      case t
          if t != null &&
            t.left != null &&
            t.right != null &&
            t.value == math.min(t.left.value, t.right.value) =>
        true
      case _ => false
    }

    def run(tree: TreeNode, set: Set[Int]): Set[Int] = tree match {
      case null => set
      case t if t.left == null && t.right == null => run(null, set + t.value)
      case t if validate(t) =>
        val l = run(t.left, set + t.value)
        val r = run(t.right, set + t.value)
        l ++ r
      case _ => set
    }

    if (validate(root)) {
      val li = run(root, Set())
      val filtList = li.filter(_ != li.min)
      if (filtList.nonEmpty) filtList.min
      else -1
    }
    else -1
  }

  // KIM_INFO THERE IS A SOLUTION FROM DISCUSSION

  // FROM DISCUSSION
  //   def findSecondMinimumValue(root: TreeNode): Int = {
  //    val m2 = Array(Int.MaxValue)
  //    helper(root, root.value, m2)
  //    if (m2(0) == Int.MaxValue) -1 else m2(0)
  //  }
  //
  //  def helper(node: TreeNode, minVal: Int, m2: Array[Int]): Unit = {
  //    if (node == null) return
  //
  //    if (node.value != minVal && node.value < m2(0)) m2(0) = node.value
  //    helper(node.left, minVal, m2)
  //    helper(node.right, minVal, m2)
  //  }
  // }

  // FROM DISCUSSION
  //  def findSecondMinimumValue(root: TreeNode): Int = root match {
  //    case null => -1
  //    case r if r.left == null && r.right == null => -1
  //    case r if r.value < r.left.value => {
  //      val rsm = findSecondMinimumValue(r.right)
  //      if (rsm != -1) math.min(rsm, r.left.value)
  //      else r.left.value
  //    }
  //    case r if r.value < r.right.value => {
  //      val lsm = findSecondMinimumValue(r.left)
  //      if (lsm != -1) math.min(lsm, r.right.value)
  //      else r.right.value
  //    }
  //    case r =>
  //      val lsm = findSecondMinimumValue(r.left)
  //      val rsm = findSecondMinimumValue(r.right)
  //      (lsm, rsm) match {
  //        case (-1, -1) => -1
  //        case (-1, r) => r
  //        case (l, -1) => l
  //        case (l, r) => math.min(l, r)
  //      }
  //  }

  println(findSecondMinimumValue(bt1))
  println(findSecondMinimumValue(bt2))
  println(findSecondMinimumValue(bt3))
}
