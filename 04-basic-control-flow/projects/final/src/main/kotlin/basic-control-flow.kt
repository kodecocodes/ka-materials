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

  // COMPARISON OPERATORS

  //val yes: Bool = true
  //val no: Bool = false
  val yes = true
  val no = false

  val doesOneEqualTwo = (1 == 2)
  val doesOneNotEqualTwo = (1 != 2)
  val alsoTrue = !(1 == 2)
  val isOneGreaterThanTwo = (1 > 2)
  val isOneLessThanTwo = (1 < 2)

  val and = true && true
  val or = true || false

  val andTrue = 1 < 2 && 4 > 3
  val andFalse = 1 < 2 && 3 > 4

  val orTrue = 1 < 2 || 3 > 4
  val orFalse = 1 == 2 || 3 == 4

  val andOr = (1 < 2 && 3 > 4) || 1 < 4

  val guess = "dog"
  val dogEqualsCat = guess == "cat"

  val order = "cat" < "dog"
  println("ORDER = " + order)

  // IF-STATEMENTS
  if (2 > 1) {
    println("Yes, 2 is greater than 1.")
  }

  val animal = "Fox"
  if (animal == "Cat" || animal == "Dog") {
    println("Animal is a house pet.")
  } else {
    println("Animal is not a house pet.")
  }

  // TERNARY OPERATOR
  val a = 5
  val b = 10

  /*
  val min: Int
  if (a < b) {
  min = a
  } else {
  min = b
  }
  */
  val min = if (a < b) a else b

  /*
  val max: Int
  if (a > b) {
  max = a
  } else {
  max = b
  }
  */

  val max = if (a > b) a else b

  val hourOfDay = 12

  val timeOfDay = if (hourOfDay < 6) {
    "Early morning"
  } else if (hourOfDay < 12) {
    "Morning"
  } else if (hourOfDay < 17) {
    "Afternoon"
  } else if (hourOfDay < 20) {
    "Evening"
  } else if (hourOfDay < 24) {
    "Late evening"
  } else {
    "INVALID HOUR!"
  }
  println(timeOfDay)

  val name = "Dick Lucas"

  if (1 > 2 && name == "Dick Lucas") {
    // ...
  }

  if (1 < 2 || name == "Dick Lucas") {
    // ...
  }

  // SCOPE
  var hoursWorked = 45

  var price = 0
  if (hoursWorked > 40) {
    val hoursOver40 = hoursWorked - 40
    price += hoursOver40 * 50
    hoursWorked -= hoursOver40
  }
  price += hoursWorked * 25

  println(price)
  //println(hoursOver40)


  // WHILE LOOPS
  //while (true) { // Commented out as this will loop forever
  //}

  // Made up sequence (it's powers of 2 minus 1, i.e. 3, 7, 15, 31, 63, etc)
  var sum = 1
  while (sum < 1000) {
    sum = sum + (sum + 1)
  }
  println(sum)

  sum = 1
  do {
    sum = sum + (sum + 1)
  } while (sum < 1000)
  println(sum)

  sum = 1
  while (sum < 1) {
    sum = sum + (sum + 1)
  }
  println(sum)

  sum = 1
  do {
    sum = sum + (sum + 1)
  } while (sum < 1)
  println(sum)

  sum = 1
  while (true) {
    sum = sum + (sum + 1)
    if (sum >= 1000) {
      break
    }
  }
  println(sum)

}
