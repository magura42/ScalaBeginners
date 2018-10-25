package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  //println(x.length) => NullPointerExcpetion

  // 1. throwing and catching exceptions

  //val aWeiredValue: String = throw new NullPointerException // is a expression

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes
  // Exception: wrong with the programm, error: wrong with the system

  // 2. how to catch exceptions
  def getInt(withException: Boolean): Int =
    if (withException) throw new RuntimeException("no int for you")
    else 42

  try { //try/catch/finally is an expression
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    println("finally!")
  }

  val potentialFail: Int = try {
    // code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally!")

  }
  println(potentialFail)

  // 3. how to define your own exception
  class MyException extends Exception
  val ex = new MyException
  //throw ex

  /*
    1. Crash your programm with an OutOfMemoryError
    2. Crash with a StackOverflowError
    3. PocketCalculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)

      Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
        - MathCalculationException for division by 0
   */

  // 1.
  //val array = Array.ofDim(Int.MaxValue)

  // 2.
  def infinite: Int = 1 + infinite
  //val noLimit = infinite

  // 3.
  object PocketCalculator {

    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x<0 && y<0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new OverflowException
      else result
    }

    def divide(x: Int, y: Int): Int =
      if (y == 0) throw new MathCalculationException
      else x / y

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
  }

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException

  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.add(123, 456))

  //println(PocketCalculator.divide(42,0))
  println(PocketCalculator.divide(42,7))
}


