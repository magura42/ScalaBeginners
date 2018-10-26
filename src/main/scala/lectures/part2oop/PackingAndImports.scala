package lectures.part2oop

import playground.{Cinderella, PrinceCharming}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackingAndImports extends App {

  // package object:
  sayHello
  println(SPEED_OF_LIGHT)

  val princess = new Cinderella
  val prince = new PrinceCharming

  // use alias
  val date = new Date()
  val sqlDate = new SqlDate(2018,5,4)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
