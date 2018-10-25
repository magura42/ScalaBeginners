package lectures.part2oop

object Generics {

  class MyList[A] {

  }

  class MyMap[Key, Value]

  val listOfInts = new MyList[Int]
  val listOfString = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of animal! (1)

  // 2. NO = INVARIANCE
  class InvarianceList[A]
  val invariantList: InvarianceList[Animal] = new InvarianceList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class ContravarianceList[-A]
  val contravarianceList: ContravarianceList[Cat] = new ContravarianceList[Animal] // macht wenig Sinn

  class Trainer[-A]
  val Trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A) // accept only subtypes of Animal, upper bounded typ
  class Cage2[A >: Animal](animal: A) // accept only supertypes of Animal, lower bounded typ
  val cage = new Cage(new Dog)

  /*
  class Car
  val newCage = new Cage(new Car) // => compiler error
  */

  class MyList2[+A] {
    // def add(element: A): MyList[A] = ??? => compiler error
    def add[B >: A](element: B): MyList[B] = ??? //(1)
    /*
      A = Cat
      B = Dog = Animal
     */
  }

  // expand MyList to be generic

}
