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

class MyMath {
  companion object {
    fun factorial(number: Int): Int {
      return (1..number).fold(1) { a, b -> a * b }
    }
  }
}

fun main() {

  // Method refresher

  val numbers = arrayListOf(1, 2, 3)
  numbers.removeAt(numbers.lastIndex)
  println(numbers) // > [1, 2]

  //// Comparing methods to getters and setters

  //// Turning a function into a method

  val months = arrayOf(
    "January", "February", "March",
    "April", "May", "June",
    "July", "August", "September",
    "October", "November", "December"
  )

  class SimpleDate1(var month:String)

  fun monthsUntilWinterBreak(from: SimpleDate1): Int {
    return months.indexOf("December") - months.indexOf(from.month)
  }

  class SimpleDate2(var month:String) {
    fun monthsUntilWinterBreak(from: SimpleDate2): Int {
      return months.indexOf("December") - months.indexOf(from.month)
    }
  }

  val date2 = SimpleDate2("October")
  println(date2.monthsUntilWinterBreak(date2)) // > 2

  //date.monthsUntilWinterBreak() // Error!

  // Introducing this

  class SimpleDate3(var month: String) {
    fun monthsUntilWinterBreak(): Int {
      return months.indexOf("December") - months.indexOf(this.month)
    }
  }

  val date3 = SimpleDate3("September")
  println(date3.monthsUntilWinterBreak()) // > 3

  class SimpleDate4(var month: String) {
    fun monthsUntilWinterBreak(): Int {
      return months.indexOf("December") - months.indexOf(month)
    }
  }

  val date4 = SimpleDate4("August")
  println(date4.monthsUntilWinterBreak()) // > 4

  // Companion object methods

  println(MyMath.factorial(6)) // 720

  // Extension methods

  class SimpleDate() {
    var month:String = "January"

    fun monthsUntilWinterBreak(): Int {
      return months.indexOf("December") - months.indexOf(month)
    }
  }

  fun SimpleDate.monthsUntilSummerBreak(): Int {
    val monthIndex = months.indexOf(month)
    return if (monthIndex in 0..months.indexOf("June")) {
      months.indexOf("June") - months.indexOf(month)
    } else if (monthIndex in months.indexOf("June")..months.indexOf("August")) {
      0
    } else {
      months.indexOf("June") + (12 - months.indexOf(month))
    }
  }

  val date = SimpleDate()

  date.month = "December"
  println(date.monthsUntilSummerBreak()) // > 6

  fun Int.abs(): Int {
    return if (this < 0) -this else this
  }

  println(4.abs())    // > 4
  println((-4).abs()) // > 4

  //// Companion object extensions

  fun MyMath.Companion.primeFactors(value: Int): List<Int> {
    var remainingValue = value
    var testFactor = 2
    val primes = mutableListOf<Int>()

    while (testFactor * testFactor <= remainingValue) {
      if (remainingValue % testFactor == 0) {
        primes.add(testFactor)
        remainingValue /= testFactor
      } else {
        testFactor += 1
      }
    }

    if (remainingValue > 1) {
      primes.add(remainingValue)
    }

    return primes
  }

  println(MyMath.primeFactors(81)) // > [3, 3, 3, 3]
}