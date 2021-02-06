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
  // RANGES
  val closedRange = 0..5

  val halfOpenRange = 0 until 5

  val decreasingRange = 5 downTo 0
  for (i in decreasingRange) {
    println(i)
  }

  // FOR LOOPS
  val count = 10

  // TRIANGLE NUMBERS
  var sum = 0
  for (i in 1..count) {
    sum += i
  }
  println(sum)


  // FIBONACCI
  sum = 1
  var lastSum = 0
  repeat(10) {
    val temp = sum
    sum += lastSum
    lastSum = temp
  }
  println(sum)


  // SUM ODD NUMBERS
  sum = 0
  for (i in 1..count step 2) {
    sum += i
  }
  println(sum)

  // COUNT DOWN
  sum = 0
  for (i in count downTo 1 step 2) {
    sum += i
  }
  println(sum)

  // CHESS BOARD ITERATION
  sum = 0
  for (row in 0 until 8) {
    if (row % 2 == 0) {
      continue
    }

    for (column in 0 until 8) {
      sum += row * column
    }
  }
  println(sum)

  sum = 0
  rowLoop@ for (row in 0 until 8) {
    columnLoop@ for (column in 0 until 8) {
      if (row == column) {
        continue@rowLoop
      }
      sum += row * column
    }
  }
  println(sum)


  // WHEN EXPRESSION
  val number = 10

  when (number) {
    0 -> println("Zero")
    else -> println("Non-zero")
  }

  when (number) {
    10 -> println("It's ten!")
  }

  val string = "Dog"
  when (string) {
    "Cat", "Dog" -> println("Animal is a house pet.")
    else -> println("Animal is not a house pet.")
  }

  val numberName = when (number) {
    2 -> "two"
    4 -> "four"
    6 -> "six"
    8 -> "eight"
    10 -> "ten"
    else -> {
      println("Unknown number")
      "Unknown"
    }
  }

  println(numberName) // > ten


  val hourOfDay = 12
  val timeOfDay: String

//  timeOfDay = when (hourOfDay) {
//      0, 1, 2, 3, 4, 5 -> "Early morning"
//      6, 7, 8, 9, 10, 11 -> "Morning"
//      12, 13, 14, 15, 16 -> "Afternoon"
//      17, 18, 19 -> "Evening"
//      20, 21, 22, 23 -> "Late evening"
//      else -> "INVALID HOUR!"
//  }

  timeOfDay = when (hourOfDay) {
    in 0..5 -> "Early morning"
    in 6..11 -> "Morning"
    in 12..16 -> "Afternoon"
    in 17..19 -> "Evening"
    in 20..23 -> "Late evening"
    else -> "INVALID HOUR!"
  }
  println(timeOfDay)

  when {
    number % 2 == 0 -> println("Even")
    else -> println("Odd")
  }

  val (x, y, z) = Triple(3, 2, 5)

  when {
    x == 0 && y == 0 && z == 0 -> println("Origin")
    y == 0 && z == 0 -> println("On the x-axis.")
    x == 0 && z == 0 -> println("On the y-axis.")
    x == 0 && y == 0 -> println("On the z-axis.")
    else -> println("Somewhere in space")
  }

  when {
    x == 0 && y == 0 && z == 0 -> println("Origin")
    y == 0 && z == 0 -> println("On the x-axis at x = $x")
    x == 0 && z == 0 -> println("On the y-axis at y = $y")
    x == 0 && y == 0 -> println("On the z-axis at z = $z")
    else -> println("In space at x = $x, y = $y, z = $z")
  }

  when {
    x == y -> println("Along the y = x line.")
    y == x * x -> println("Along the y = x^2 line.")
  }
}