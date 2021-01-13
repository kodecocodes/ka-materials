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

/*

 ### Challenge 1: You be the compiler
 Which of the following are valid statements?

 var name: String? = "Ray"
 var age: Int = null
 val distance: Float = 26.7
 var middleName: String? = null

*/

  var name: String? = "Ray"
//  var age: Int = null // INVALID
//  val distance: Float = 26.7 // INVALID
  var middleName: String? = null


/*
 ### Challenge 2: Divide and conquer

First, create a function that returns the number of times an integer can be divided by another integer without a remainder. The function should return null if the division doesn’t produce a whole number. Name the function divideIfWhole.

Then, write code that tries to extract the nullable result of the function. There should be two cases: upon success, print "Yep, it divides $answer times", and upon failure, print "Not divisible :[".

Finally, test your function:

    1. Divide 10 by 2. This should print `"Yep, it divides 5 times"`
    2. Divide 10 by 3. This should print `"Not divisible :["`

Hint 1: Use the following as the start of the function signature:

    fun divideIfWhole(value: Int, divisor: Int)

You’ll need to add the return type, which will be a nullable!

Hint 2: You can use the modulo operator (%) to determine if a value is divisible by another; recall that this operation returns the remainder from the division of two numbers. For example, 10 % 2 = 0 means that 10 is divisible by 2 with no remainder, whereas 10 % 3 = 1 means that 10 is divisible by 3 with a remainder of 1.
*/

  fun divideIfWhole(value: Int, divisor: Int): Int? {
    return if (value % divisor == 0) {
      value / divisor
    } else {
      null
    }
  }

  var answer = divideIfWhole(10, 2)
  if (answer != null) {
    println("Yep, it divides $answer times")
  } else {
    println("Not divisible :[")
  }

  answer = divideIfWhole(10, 3)
  if (answer != null) {
    println("Yep, it divides $answer times")
  } else {
    println("Not divisible :[")
  }

/*:
 ### Challenge 3: Refactor and reduce

 The code you wrote in the last challenge used `if` statements. In this challenge, refactor that code to use the Elvis operator instead. This time, make it print `"It divides X times"` in all cases, but if the division doesn’t result in a whole number, then `X` should be `0`.
*/

  val answer1 = divideIfWhole(10, 2) ?: 0
  println("It divides $answer1 times.")

  val answer2 = divideIfWhole(10, 3) ?: 0
  println("It divides $answer2 times.")
}

