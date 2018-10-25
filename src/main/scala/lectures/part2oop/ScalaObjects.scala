package lectures.part2oop

object ScalaObjects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Bob")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANION: können gegenseitig private Methode aufrufen!

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")

  println(mary == john)

  val p1 = Person
  val p2 = Person
  println(p1 == p2)

  val bob = Person(mary, john)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}
