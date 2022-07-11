package kim.dencka.easy.tree

object SumOfRootToLeafBinaryNumbers extends App {

  class TreeNode(
    val value: Int,
    val left: TreeNode = null,
    val right: TreeNode = null
  )

  val bt1 =
    new TreeNode(
      1,
      new TreeNode(0, new TreeNode(0), new TreeNode(1)),
      new TreeNode(1, new TreeNode(0), new TreeNode(1))
    )

  def sumRootToLeaf(root: TreeNode): Int = {
//    AS A STRING
//    def run(tree: TreeNode, list: String, acc: List[String]): List[String] = tree match {
//        case null => List()
//        case t if t.left == null && t.right == null => (list + t.value) +: acc
//        case t => run(tree.left, list + t.value, acc) ++ run(tree.right, list + t.value, acc)
//      }
    def run(tree: TreeNode, list: List[Int], acc: List[List[Int]]): List[List[Int]] = tree match {
      case null => List()
      case t if t.left == null && t.right == null => (list :+ t.value) +: acc
      case t => run(tree.left, list :+ t.value, acc) ++ run(tree.right, list :+ t.value, acc)
    }
    val list = run(root, List.empty, List())
    def toDec(l: List[Int]): Int = {
      l.foldRight(0, 0) { case (el, (acc, cnt)) =>
        if (el == 0) (acc, cnt + 1)
        else (acc + math.pow(2, cnt).toInt, cnt + 1)
      }
    }._1
    list.map(toDec).sum

//    AS A STRING. VIA "Integer.parseInt", THIS METHOD TAKES A LITTLE LESS MEMORY, BUT USES THE JAVA METHOD
//    list.map(Integer.parseInt(_, 2)).sum
  }

  println(sumRootToLeaf(bt1))

}
