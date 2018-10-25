package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("argargargarg")
  }

  println(funnyAnimal.eat)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name!")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"my name is JIM")
  }

  /*
    1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
    2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
    3. MyList:
      - map(transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer form A to MyList[B]) => MyList[B]

      class EventPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String, Int]

      [1,2,3].map(n*2) = [2,4,6]
      [1,2,3,4].filter(n % 2) = [2,4]
      [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]

      => MyList.scala
   */
}
