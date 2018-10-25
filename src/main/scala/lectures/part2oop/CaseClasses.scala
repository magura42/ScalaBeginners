package lectures.part2oop

object CaseClasses extends App {

  /**
    * equals, hashCode, toString wird bereitgestellt.
    */


  case class Person(name: String, age: Int)

  // 1. class parameters are fields:
  val jim = new Person("Jim", 42)
  println(jim.name)

  // 2. sensible toString
  println(jim) // <=> println(jim.toString)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 24)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 12)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("mary", 23)

  // 6. CCs are serializable => Akka
  // 7. CCs have extractor patterns = CCs can be used in Pattern Matching

  case object UK {
    def name: String = "UK of GB and NI"
  }
}
