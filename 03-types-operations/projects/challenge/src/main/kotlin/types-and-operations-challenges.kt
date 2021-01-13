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

  // Challenge 1 - Create a constant called coordinates and assign a pair containing two and three to it.

  val coordinates = Pair(2, 3)
  println(coordinates)

  // Challenge 2 - Extract the values 2 and 3 from coordinates into two variables called row and column.

  val (row, column) = coordinates
  println("$row, $column")

  // Challenge 3 - Which of the following are valid statements?

//  val character: Character = "Dog" // INVALID
  val character: Char = 'd' // VALID
  val string: String = "Dog" // VALID
//  val string: String = 'd' // INVALID

  // Challenge 4 - Is this valid code?

  val date = Triple(15, 8, 2015)
//  val day = date.First // INVALID
  val day = date.first

  // Challenge 5 - What is wrong with the following code?

//  val name = "Joe"
//  name += " Howard" // val is immutable
  var name = "Joe"
  name += " Howard"

  // Challenge 6 - What is the type of the constant named value?

  val triple = Triple(100, 1.5, 10)
  val value = triple.second // Double

  // Challenge 7 - What is the value of the constant named month?

  val newDate = Triple(15, 8, 2015)
  val month = newDate.second // Int

  // Challenge 8 - What is the value of the constant named summary?

  val number = 10
  val multiplier = 5
  val summary = "$number multiplied by $multiplier equals ${number * multiplier}"
  println(summary)

  // Challenge 9 - What is the sum of a and b, minus c? What is its type?

  val a = 4
  val b: Short = 100
  val c: Byte = 12
  val sum: Int = a + b + c
  println(sum)

  // Challenge 10 - What is the numeric difference between kotlin.math.PI and kotlin.math.PI.toFloat()?

  println(kotlin.math.PI - kotlin.math.PI.toFloat())
}
