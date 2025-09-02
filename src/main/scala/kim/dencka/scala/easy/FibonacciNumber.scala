package kim.dencka.scala.easy

object FibonacciNumber extends App {

  def fib(n: Int): Int = {
    if (n == 0) 0
    else if (n == 1 || n == 2) 1
    else fib(n - 1) + fib(n - 2)
  }

  println(fib(5))

}
