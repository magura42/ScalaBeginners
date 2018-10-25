package lectures.part2oop

object OOBasics extends App {

  val author = new Writer("Manfred", "Harrer", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWritteByAuthor(author))

  val c = new Counter(12)
  c.inc.print

  class Person(name: String, val age:Int) {

  }

  /*
  Novel and a writer
  Writer: first name, surname, year
  - method fullname

  Novel: name, year of release, author:Writer
  - method authorAge
  - isWrittenByAuthor(author)
  - copy (new year of relase) = new instance of novel
   */

  class Writer(firstname: String, surname: String, val year: Int) {
    def fullName: String = s"$firstname $surname"
  }

  class Novel(name: String, var yearOfRelease: Int, author: Writer) {

    def authorAge: Int = yearOfRelease - this.author.year

    def isWritteByAuthor(author: Writer): Boolean = this.author == author

    def copyNovel(newYearOfRelease: Int): Novel = new Novel(this.name, newYearOfRelease, author)
  }

  /*
    counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new counter
    - overload inc/dec to receive an amount
   */

    class Counter(val counter: Int) {



      def inc = {
        println("incrementing")
        new Counter(this.counter + 1) // immutability
      }

      def dec = {
        println("decrementing")
        new Counter(this.counter - 1) // immutability
      }

      def inc(n: Int): Counter = {
        if (n <= 0) this
        else inc.inc(n-1)
      }

      def dec(n: Int): Counter = {
        if (n <= 0) this
        else dec.dec(n+1)
      }

      def print = println(this.counter)
    }
}
