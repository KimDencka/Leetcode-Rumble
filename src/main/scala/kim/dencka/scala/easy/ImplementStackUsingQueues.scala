package kim.dencka.scala.easy

import scala.collection.mutable

object ImplementStackUsingQueues extends App {

  class MyStack {
    val q: mutable.Queue[Int] = scala.collection.mutable.Queue.empty[Int]

    def push(x: Int): Unit = {
      q.enqueue(x)
      (0 until q.size - 1)
        .foreach(_ => q.enqueue(q.dequeue()))
    }

    def pop(): Int = q.dequeue()

    def top(): Int = q.front

    def empty(): Boolean = q.isEmpty

  }

  /**
   * Your MyStack object will be instantiated and called as such:
   * var obj = new MyStack()
   * obj.push(x)
   * var param_2 = obj.pop()
   * var param_3 = obj.top()
   * var param_4 = obj.empty()
   */
}
