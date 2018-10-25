package lectures.part1basics

import scala.annotation.tailrec

object Arguments extends App {

  @tailrec
  def tailRecursiveFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else tailRecursiveFact(n-1, n*acc)

  val fact10 = tailRecursiveFact(10, acc = 1)

  val fact8 = tailRecursiveFact(8)

  println(fact10)
  println(fact8)
}
