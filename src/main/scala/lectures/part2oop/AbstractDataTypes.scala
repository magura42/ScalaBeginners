package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Dackel"
    override def eat: Unit = println("nomnomnom")
  }

  // trait
  trait Carnivore {
    def eat(animal: Animal)
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croco"
    override def eat: Unit = "nomnom"
    override def eat(animal: Animal): Unit = println(s"I'm a croco and i'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)
}
