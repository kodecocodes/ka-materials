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

import kotlin.math.*

fun main() {
  // COMMENTS
  // This is a comment. It is not executed.

  // This is also a comment.
  // Over multiple lines.

  /* This is also a comment.
     Over many..
     many...
     many lines. */

  /* This is a comment.

   /* And inside it
      is
      another comment.
   */

  Back to the first.
  */


  // PRINT
  println("Hello, Kotlin Apprentice reader!")


  // ARITHMETIC
  println(2 + 6)

  println(10 - 2)

  println(2 * 4)

  println(24 / 3)

  println(2 + 6)

  println(22 / 7)

  println(22.0 / 7.0)

  println(28 % 10)

  println("%.0f".format(28.0 % 10.0))

  println(1.shl(3)) // infix function

  println(32 shr 2)

  println(((8000 / (5 * 10)) - 32) shr (29 % 5))

  println(350 / 5 + 2)

  println(350 / (5 + 2))


  // MATH FUNCTIONS
  println(sin(45 * PI / 180))

  println(cos(135 * PI / 180))

  sqrt(2.0)

  max(5, 10)

  min(-5, -10)

  max(sqrt(2.0), PI / 2)


  // VARIABLES & CONSTANTS
  val number: Int = 10
  //number = 0 /* Val cannot be reassigned */

  val pi: Double = 3.14159 // val pi: Double = 3.14159

  var variableNumber: Int = 42
  variableNumber = 0
  variableNumber = 1_000_000

  // ARITHMETIC WITH VARIABLES
  var counter: Int = 0
  counter += 1
  counter -= 1
  println(counter)

  counter = 10
  counter *= 3
  counter /= 2
  println(counter)
}