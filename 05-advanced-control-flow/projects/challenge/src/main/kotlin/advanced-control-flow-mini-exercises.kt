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

import kotlin.math.sqrt

fun main() {
  // FOR LOOPS
  val range = 1..10
  for (i in range) {
    val square = i * i
    println("$square")
  }

  for (i in range) {
    val squareRoot = sqrt(i.toDouble())
    println("$squareRoot")
  }

  var sum = 0
  for (row in 1 until 8 step 2) {  //(1,3,5,7)
    for (column in 0 until 8) {
      sum += row * column
    }
  }
  println(sum)


  // WHEN EXPRESSIONS
  val myAge = 30

  when (myAge) {
    in 0..2 -> println("Infant")
    in 3..12 -> println("Child")
    in 13..19 -> println("Teenager")
    in 20..39 -> println("Adult")
    in 40..60 -> println("Middle aged")
    in 61..Int.MAX_VALUE -> println("Elderly")
    else -> println("Invalid age")
  }

  val (name, age) = Pair("Joe", 24)
  when (age) {
    in 0..2 -> println("$name is a infant")
    in 3..12 -> println("$name is a child")
    in 13..19 -> println("$name is a teenager")
    in 20..39 -> println("$name is an adult")
    in 40..60 -> println("$name is middle aged")
    in 61..Int.MAX_VALUE -> println("$name is elderly")
    else -> println("Invalid age")
  }
}
