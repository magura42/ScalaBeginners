package lectures.part2oop

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String, val age: Int = 42) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} AND ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"apply method $name"

    //1.
    def +(s: String): Person = new Person(s"${this.name} ($s)", this.favoriteMovie)

    // 2:
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

    // 3
    def learns(language: String): String = s"$name learns $language"
    def learnsScala: String = this learns "Scala"

    // 4
    def apply(number: Int): String = s"$name watched $favoriteMovie $number times"
  }

  var mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println( mary likes "Inception")
  // infix notation = operator notation

  // operators in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // all opertators are methode with one param

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ ! ?

  println(!mary)
  println(mary.unary_!)

  // postfix notation, no arguments
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  /*
    1. overload the + operator
       mary + "the rockstar" => new person "Mary (the rockstar)"

    2. add an age to the person class
       add a unary + opertator => new person with age + 1
       +mary => mary with the age incrementer

    3. add a "learns" method in the person class => "Mary learns Scala"
       Add a learnsScala method, calss learns method with "Scala"
       Use it in postfix notation

    4. overload the apply method
       mary.apply(2) => "Mary watched Inception 2 times"
   */

  // 1
  val m2 = mary + "the rockstar"
  println(m2.name)

  // 2
  val m3 = +mary
  println(m3.age)

  // 3
  println(mary learnsScala)

  // 4
  println(mary(2))

}
