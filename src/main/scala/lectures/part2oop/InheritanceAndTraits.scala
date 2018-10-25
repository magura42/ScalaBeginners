package lectures.part2oop

object InheritanceAndTraits extends App {

  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {

    def crunch = {
      eat
      println("crunch, crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, aget: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "domestic"
    override def eat: Unit = {
      super.eat
      println("crunch it!")
    }
  }
  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)

  // type substition (=> polymorphism
  val unknownAnimal: Animal = new Dog("Bello")
  unknownAnimal.eat

  // overriding vs overloading

  // super

  // preventing overriding
  // 1. final on member
  // 2. final on entire class
  // 3. seal the class = extend class only in THIS FILE, prevent extension in other files
}
