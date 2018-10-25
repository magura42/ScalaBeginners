package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  @tailrec
  def concatString(s: String, n: Int, accumulation: String): String =
    if (n <= 0) accumulation
    else concatString(s, n-1, accumulation + s)


  println(concatString("hello", 5, ""))
}
