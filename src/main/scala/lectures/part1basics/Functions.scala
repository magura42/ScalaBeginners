package lectures.part1basics

object Functions extends App {

  def funcWithParams(i: Int, s: String): String = {
    i + "___" + s
  }
  println(funcWithParams(42, "muc"))

}
