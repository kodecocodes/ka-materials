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

/*:
 ## Advanced Control Flow
 ### Challenge 1

 In the following for loop:

 ```
 var sum = 0
 for(i in 0..5) {
   sum += i
 }
 ```
 What will be the value of `sum`, and how many iterations will happen?
 */
  var sum = 0
  for (i in 0..5) {
    sum += i
  }
  println(sum)

// sum = 15, 6 iterations (0, 1, 2, 3, 4, 5)

/*:
 ### Challenge 2

 In the while loop below:
 ````
 var aLotOfAs = ""
 while aLotOfAs.count < 10 {
   aLotOfAs += "a"
 }
 ````
 How many instances of the character “a” will there be in `aLotOfAs`? Hint: `aLotOfAs.count` will tell you how many characters there are in the string `aLotOfAs`.
 */
  var aLotOfAs = ""
  while (aLotOfAs.length < 10) {
    aLotOfAs += "a"
  }
  println(aLotOfAs)
  println(aLotOfAs.length)
// aLotOfAs contains 10 instances of "a"

/*:
 ### Challenge 3
 Consider the following switch statement:

 ```
when {
    x == y && y == z -> println("x = y = z")
    z == 0 -> println("On the x/y plane")
    y == 0 -> println("On the x/z plane")
    x == 0 -> println("On the y/z plane")
    else -> println("Nothing special")
  }
 ```

 What will this code print when coordinates is each of the following?
 ```
 val (x, y, z) = Triple(1, 5, 0)
 val (x, y, z) = Triple(2, 2, 2)
 val (x, y, z) = Triple(3, 0, 1)
 val (x, y, z) = Triple(3, 2, 5)
 val (x, y, z) = Triple(0, 2, 4)
 ```
 */
  val (x, y, z) = Triple(1, 5, 0)
// "On the x/y plane"

//val (x, y, z) = Triple(2, 2, 2)
// "x = y = z"

//val (x, y, z) = Triple(3, 0, 1)
// "On the x/z plane"

//val (x, y, z) = Triple(3, 2, 5)
// "Nothing special"

// val (x, y, z) = Triple(0, 2, 4)
// "On the y/z plane"

  when {
    x == y && y == z -> println("x = y = z")
    z == 0 -> println("On the x/y plane")
    y == 0 -> println("On the x/z plane")
    x == 0 -> println("On the y/z plane")
    else -> println("Nothing special")
  }

/*:
 ### Challenge 4
 A closed range can never be empty. Why?
 */
// Ranges must always be increasing.  With a closed range the second number is always included in the range.

  val halfOpenRange = 100 until 100 // empty
  val closedRange = 100..100   // contains the number 100

  println(halfOpenRange.isEmpty())
  println(closedRange.isEmpty())

/*:
 ### Challenge 5
 Print a countdown from 10 to 0.  (Note: do not use the downTo method)
 */
  for (i in 0..10) {
    println(10 - i)
  }

/*:
 ### Challenge 6

 Print 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0.
 */
  var value = 0.0

  repeat(10) {
    println(value)
    value += 0.1
  }

  // Alternate solution
  for (counter in 0..10) {
    println(counter.toDouble() * 0.1)
  }

}
