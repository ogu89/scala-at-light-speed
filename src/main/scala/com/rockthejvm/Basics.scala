package com.rockthejvm

object Basics extends App{

  val meaningOfLife: Int = 42
  val aBoolean = false

  val aString = "I love Scala"
  val aComposedString = "I" + " " + "Love" + "Scala"
  val anInterporlatedString = s"The meaning of life is $meaningOfLife"

  val anExpression = 2 + 3
  val ifExpression = if(meaningOfLife > 43) 56 else 999
  val chainedIfExpression =
    if(meaningOfLife > 43)56
    else if (meaningOfLife < 0) -2
    else if(meaningOfLife > 999) 78
    else 0

  // code blocks
  val aCodeBlock = {
    val aLocalValue = 67

    // value of block is the value of the last expression
    aLocalValue + 3
  }

  // define a funcion
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  def factorial(n: Int): Int =
    if(n <= 1) 1
    else n * factorial(n-1)

  // In Scala we don't use loops or interation, we use RECURSION!!!!!1


  // THe Unit Type = no meaningful value === "void in other languages
  // type of SIDE EFFECTS
  println("I love Scala")

  myUnitRturningFunction()
  def myUnitRturningFunction(): Unit = {
    println("I don't love returning Unit")
  }

//  theUnit()
  val theUnit = ("iiii")
}
