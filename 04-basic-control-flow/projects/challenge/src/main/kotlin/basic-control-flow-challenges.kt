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

import kotlin.math.log2
import kotlin.math.sqrt

fun main() {

  /*
  1. What's wrong with the following code?

  val firstName = "Joe"

  if (firstName == "Joe") {
    val lastName = "Howard"
  } else if (firstName == "Ray") {
    val lastName = "Wenderlich"
  }
  val fullName = firstName + " " + lastName

  */

  // `lastName` is no longer in scope when setting `fullName`.
  // A correct solution:
  val firstName = "Joe"
  var lastName = ""

  if (firstName == "Joe") {
    lastName = "Howard"
  } else if (firstName == "Ray") {
    lastName = "Wenderlich"
  }

  val fullName = firstName + " " + lastName

  /*
  2. In each of the following statements, what is the value of the Boolean answer constant?
  */

  val answer1 = true && true
  // true

  val answer2 = false || false
  // false
  val answer3 = (true && 1 != 2) || (4 > 3 && 100 < 1)
  // true

  val answer4 = ((10 / 2) > 3) && ((10 % 2) == 0)
  // true

  /*
  3. Suppose the squares on a chessboard are numbered left to right, top to bottom, with 0 being the top-left square
  and 63 being the bottom-right square. Rows are numbered top to bottom, 0 to 7. Columns are numbered left to right,
  0 to 7. Given a current position on the chessboard, expressed as a row and column number, calculate the next position
  on the chessboard, again expressed as a row and column number. The ordering is determined by the numbering from 0 to
  63. The position after 63 is again 0.
  */

  val row = 7
  val column = 7

  var nextRow = row
  var nextColumn = column + 1
  if (nextColumn > 7) {
    nextColumn = 0
    nextRow += 1
  }
  if (nextRow > 7) {
    nextRow = 0
  }
  println("The position after ($row, $column) is ($nextRow, $nextColumn)")

  /*
  4. Given the coefficients a, b and c, calculate the solutions to a quadratic equation with these coefficients. Take
  into account the different number of solutions (0, 1 or 2). If you need a math refresher, this Wikipedia article on
  the quadratic equation will help https://en.wikipedia.org/wiki/Quadratic_formula.
  */

  val a = 1.0
  val b = -5.0
  val c = 6.0

  val d = b * b - 4 * a * c
  if (d > 0) {
    val x1 = (-b + sqrt(d)) / (2 * a)
    val x2 = (-b - sqrt(d)) / (2 * a)
    println("The solutions are $x1 and $x2")
  } else if (d.equals(0.0)) {
    val x = -b / (2 * a)
    println("Both solutions are $x")
  } else {
    println("This equation has no solutions")
  }

  /*
  5. Given a month (represented with a String in all lowercase) and the current year (represented with an Int),
  calculate the number of days in the month. Remember that because of leap years, "february" has 29 days when the year
  is a multiple of 4 but not a multiple of 100.  February also has 29 days when the year is a multiple of 400.
  */

  val month = "february"
  val year = 2016

  if (month == "january" || month == "march" || month == "may" || month == "july" || month == "august" ||
      month == "october" || month == "december") {
    println("This month has 31 days")
  } else if (month == "april" || month == "june" || month == "september" || month == "november") {
    println("This month has 30 days")
  } else if (month == "february" && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
    println("This month has 29 days")
  } else if (month == "february") {
    println("This month has 28 days")
  } else {
    println("This is not a valid month")
  }

  /*
  6. Given a number, determine if this number is a power of 2. (Hint: you can use log2(number) to find the base 2
  logarithm of number. log2(number) will return a whole number if number is a power of two. You can also solve the
  problem using a loop and no logarithm.)
  */

  val number = 1024.0

  // Solution using logarithms:
  val log = log2(number)
  if (log == log.toInt().toDouble()) {
    println("$number is a power of 2")
  } else {
    println("$number is not a power of 2")
  }

  // Solution without using logarithms:
  var dividend = number
  while (dividend.toInt() % 2 == 0) {
    dividend /= 2
  }
  if (dividend.equals(1.0)) {
    println("$number is a power of 2")
  } else {
    println("$number is not a power of 2")
  }

  /*
  7. Print a table of the first 10 powers of 2.
  */

  var exponent = 0
  var power = 1
  while (exponent <= 10) {
    println("$exponent, $power")
    exponent += 1
    power *= 2
  }

  /*
  8. Given a number n, calculate the n-th Fibonacci number.  (Recall Fibonacci is 1, 1, 2, 3, 5, 8, 13, ... Start with
  1 and 1 and add these values together to get the next value.  The next value is the sum of the previous two.  So the
  next value in this case is 8+13 = 21.)
  */

  val goal = 10  // the value of n

  var current = 1
  var previous = 1
  var done = 2
  while (done < goal) {
    val next = current + previous
    previous = current
    current = next
    done += 1
  }
  println("Fibonacci number $goal is $current")

  /*
  9. Given a number n, calculate the factorial of n.  (Example: 4 factorial is equal to 1 * 2 * 3 * 4.)
  */

  val n = 5

  var accumulator = 1
  done = 1
  while (done < n) {
    done += 1
    accumulator *= done
  }
  println("$n! is $accumulator")

  /*
  10. Given a number between 2 and 12, calculate the odds of rolling this number using two six-sided dice. Compute it
  by exhaustively looping through all of the combinations and counting the fraction of outcomes that give you that
  value. Don't use a formula.
  */

  val targetValue = 7

  var combinationsFound = 0
  var valueOnFirstDice = 1
  while (valueOnFirstDice <= 6) {
    var valueOnSecondDice = 1
    while (valueOnSecondDice <= 6) {
      if (valueOnFirstDice + valueOnSecondDice == targetValue) {
        combinationsFound += 1
      }
      valueOnSecondDice += 1
    }
    valueOnFirstDice += 1
  }
  val percentage = (combinationsFound.toDouble() / 36 * 100).toInt()
  println("The odds of rolling a $targetValue are $combinationsFound in 36 or $percentage%")

}
