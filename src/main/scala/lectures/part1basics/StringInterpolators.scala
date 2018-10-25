package lectures.part1basics

object StringInterpolators extends App {

  // s interpolator:
  val name = "david"
  println(s"Hello $name!")

  // f interpolator:

  val  f = 1.2f
  println(f"Format $f%2.3f")

  // raw interpolator:
  val r = "Hello \n Bernd"
  println(raw"$r")
}
