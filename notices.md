# Scala Basics

---

## Values, Variables and Types
* Vals are immutable
* Compiler can infer types
* Variablen mit var
* Side effect: changing a var, println or displaying on screen
* prevent side effects (code is difficulter to understand)
* all vars and vals have types

---

## Expressions
* If ist eine Expression
* Code blocks sind Expressions
* Instruction/Java: werden ausgeführt, Expressions/Scala werden evaluiert

---

## Functions
* when you need loops, use recursion

---

## Type Inference
Compiler kann Typen schlussfolgern:
* Bei Variablen: val x = 42 => Int
* Bei Funktionen: def s(x:Int) = x + 1 => Int

---

## Recursion
* tail recursion: letze Aktion in einer Funktion ist der rekursive Aufruf => Stack kann wieder verwendet werden (Sonst: Probleme mit StackOverflow)
* Annotation von tail recursion mit _@tailrec_

---

## Call-by-name and Call-by-value
* by value: def m(x: Long) Wert wird vor dem Aufruf berechnet, innerhalb der Funktion dann immer der gleiche Wert
* by name: def m(x: => Long) Expression wird literal übergeben => Bei jedem Gebrauch innerhalb der Funktion wird die Expression evaluiert.

---

## Default and named arguments
* default: def f(a: Int = 1)
* named: f(a = 42)

---

## Smart operations on Strings
* siehe Java
* Append: +:, Depend: :+
* s interpolation: s"hello $name"
* f interpolation: f"format $fnumber%2.2f"
* raw interpolation raw"$rawStr"

---

# Object-Oriented Programming in Scala

---

## Basics
* classes
* instantiating
* parameters vs fields
* defining mehtods, calling methods, this, overloading

---

## Method notations
* infix
  * method with one parameter
  * Operator notation, e.g. mary likes "1860" <=> mary.likes("1860")
  * operator = Methode mit einem Parameter
* prefix: x = -1 <=> x.unary_-
* postfix: no paremeters => mary.isAlive <=> mary isAlive
* apply: methodennamen kann weggelassen werden, nur bei apply()

---

## Objects
* Scala doesnt have static values/methods
* scala object = only instance, own class
* scala object = singleton pattern in one line
* companions: can acces each other's private members
* scala is more OO than Java
* scala applications: object with def main(...)

---

## Inheritance and traits
* single class inheritance
* acces modifiers: private, protected
* constructors: this() und direkt in der Class-Notation
* override: in der Subclass, auch im Constructor möglich: class Dog(override val type:String)
* overloading: Methode mit verschiedenen Signature
* prevent overriding: final (members or class), sealed
* super
* type substituion => polymorphism
* scala offers class-based inheritance
* abstract class, trais
  * abstract class: "thing"
  * traits: behaviour
  
---
  
## Generics
* types:

    trait List[T] {
        def add(elem: T)
    }
 
* methods:

    object List {
        def single[A](element: A): List[A] = ???
    }
* multiple type parameters:
    
    trait Map[Key, Value] {...}   
    
* Variance: if B extends A, should List[B] extend List[A]?

   * yes (covariant): trait List[+A]
   * no (invariant, default): trait List[A]
   * hello no! (contravariant): trait List[-A] 

* bounded types: class Garage[T <: Car](car: T)

---

# Anonymous Classes
* instantiate types and override fields or methods on the spot
* pass in required constructor arguments if needed
* implement all abstract fields/methods
       

    trait Animal {
      def eat: Unit
    }
    
    val p = new Animal {
     override def eat: Unit = println("nomnom")
    }         
    
# Case classes    
* quick lightweightt data structures with little boilerplate
* companions already implemented
* sensible equals, hashCode and toString methods
* auto-promoted params to fields
* cloning, case objects

# Exceptions
* exceptions crash your program
* how to throw exceptions
* how to catch exceptions
* define custom exceptions