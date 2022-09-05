package kim.dencka.scala.easy.other

object ImplementQueueUsingStacks {

  class MyQueue {

    var stack = new scala.collection.mutable.Stack[Int]()
    var temp = new scala.collection.mutable.Stack[Int]()

    def push(x: Int): Unit = {
      for (_ <- stack.indices) {
        temp.push(stack.pop())
      }

      stack.push(x)

      for (_ <- temp.indices) {
        stack.push(temp.pop())
      }

    }

    def pop(): Int = stack.pop()

    def peek(): Int = stack.top

    def empty(): Boolean = stack.isEmpty

  }

  /** Your MyQueue object will be instantiated and called as such:
   * var obj = new MyQueue()
   * obj.push(x)
   * var param_2 = obj.pop()
   * var param_3 = obj.peek()
   * var param_4 = obj.empty()
  */

}
