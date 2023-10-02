package com.rockthejvm

object ObjectOrientaion extends App{
  // java equivalent: public static void main(String[] args)

  class Animal{
    val age: Int = 0
    def eat() = println("I'm eating")
  }
  val anAnimal = new Animal

  //inheritance
  class Dog(val name: String) extends Animal
  val aDog = new Dog("Lassie")

  // constructor arguments are not fields: need to put a val before the constructor arguments
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, can restrict by adding protected or private
    def walk(): Unit
  }

  //"interface" ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")

    override def ?!(thought: String): Unit = println(s"I was thiking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation  = object method argument, only available for methods with ONE argument
  aCroc ?! "What if we could fly"

  // Operators in scala are actually
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2)
//  println(anotherBasicMath )

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
  }

  /*
  class

   */
  object MySingleton {
    val mySpecialValue = 53278
    def mySpecialMethod(): Int = 5327
    def apply(x: Int): Int = x + 1
  }
  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65)
  println(MySingleton.mySpecialValue)

  object Animal { // companions - companion object
    // companions can access each other's private fields/methods
    // singleton animal and instances of animal are different things
    val canLiveIndefinitely = false
  }
  val animalsCanLiveForever = Animal.canLiveIndefinitely //"static" fields/methods

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 54) //Person.apply("bob", 54)

  //exceptions
  try{
    val x: String = null
    x.length
  }catch {
    case e: Exception => "some faulty error message"
  } finally {
    // execute some code no matter what
  }

//generics
  abstract class MyList[T]{
  def head: T
  def tail: MyList[T]
}

  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head // string

  // Point #1: in Scala we ususally operate with Immuteable values/objects
  // Any modification to an object must return ANOTHER object

  /*
  Benefits:
    1) works miracles in multithreaded/distributed env
    2) helps making sense of the code ("reasoning about")
   */
    val reversedList = aList.reverse


}
