package lectures.part1basics

object CallBy extends App {

  def callByValue(x: Long): Unit = {
    println("callByValue: " + x)
    println("callByValue: " + x)
  }

  def callByName(x: => Long): Unit = {
    println("callByName: " + x)
    println("callByName: " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

}
