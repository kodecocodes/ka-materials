/*
 * Copyright (c) 2021 Razeware LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish, 
 * distribute, sublicense, create a derivative work, and/or sell copies of the 
 * Software in any work that is designed, intended, or marketed for pedagogical or 
 * instructional purposes related to programming, coding, application development, 
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works, 
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

fun main() {

  // FUNCTION BASICS
  fun printMyName() {
    println("My name is Joe Howard.")
  }
  printMyName()


  // FUNCTION PARAMETERS
  fun printMultipleOfFive(value: Int) {
    println("$value * 5 = ${value * 5}")
  }
  printMultipleOfFive(10)

  fun printMultipleOf(multiplier: Int, andValue: Int) {
    println("$multiplier * $andValue = ${multiplier * andValue}")
  }
  printMultipleOf(multiplier = 4, andValue = 2)

  fun printMultipleOfDefaultValue(multiplier: Int, value: Int = 1) {
    println("$multiplier * $value = ${multiplier * value}")
  }
  printMultipleOfDefaultValue(4, 2)

  printMultipleOfDefaultValue(4)


  // RETURN VALUES
  fun multiply(number: Int, multiplier: Int): Int {
    return number * multiplier
  }

  fun multiplyInferred(number: Int, multiplier: Int) = number * multiplier

  val result = multiplyInferred(4, 2)

  fun multiplyAndDivide(number: Int, factor: Int): Pair<Int, Int> {
    return Pair(number * factor, number / factor)
  }
  val (product, quotient) = multiplyAndDivide(4, 2)

  // Parameters as values
//  fun incrementAndPrint(value: Int) {
//    value += 1 // Val cannot be reassigned
//    print(value)
//  }

  fun incrementAndPrint(value: Int): Int {
    val newValue = value + 1
    println(newValue)
    return newValue
  }

  var value = 5
  value = incrementAndPrint(value)
  println(value)


  // OVERLOADING
  fun getValue(value: Int): Int {
    return value + 1
  }

  fun getValue(value: String): String {
    return "The value is $value"
  }

  val valueInt: Int = getValue(42)
  val valueString: String = getValue("Galloway")


  // FUNCTIONS AS VARIABLES
  fun add(a: Int, b: Int): Int {
    return a + b
  }

  var function = ::add
  function(4, 2)

  fun subtract(a: Int, b: Int): Int {
    return a - b
  }
  function = ::subtract
  function(4, 2)

  fun printResult(function: (Int, Int) -> Int, a: Int, b: Int) {
    val result = function(a, b)
    print(result)
  }
  printResult(::add, 4, 2)


  // LAND OF NO RETURN
  //fun noReturn() : Nothing {
  //
  //}

  fun infiniteLoop(): Nothing {
    while (true) {
    }
  }
}
