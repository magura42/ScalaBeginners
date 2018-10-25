package lectures.part1basics

object Expressions extends App {

  val a = 1
  println(a)

  val b = {
    val c = "123"
    val d = 234
    c + "_" + d
  }
  println(b)

  val e = if(true) 42 else 24
  println(e)

  val f = {
    var i=0
    while(i<10) {
      i += 1
    }
    "hello scala!"
  }
  println(f)
}
