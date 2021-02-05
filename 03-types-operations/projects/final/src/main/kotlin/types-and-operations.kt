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

  // CONVERTING TYPES
  var integer: Int = 100
  var decimal: Double = 12.5
  // integer = decimal // Type mismatch. Required: Int. Found: Double.
  integer = decimal.toInt()

  val hourlyRate: Double = 19.5
  val hoursWorked: Int = 10
  val totalCost: Double = hourlyRate * hoursWorked
  println(totalCost)


  // TYPE INFERENCE
  val typeInferredInt = 42 /* Type = Int */
  val typeInferredDouble = 3.14159 /* Type = Double */

  val wantADouble = 3
  val actuallyDouble = 3.toDouble()
  //val actuallyDouble: Double = 3.0
  //val wantADouble = 3.0


  // CHARACTERS
  val characterA: kotlin.Char = 'a'
  val stringDog = "Dog"


  // STRING CONCATENATION
  var message = "Hello" + " my name is "
  val name = "Joe"
  message += name

  val exclamationMark: Char = '!'
  message += exclamationMark

  // STRING TEMPLATES
  message = "Hello my name is $name!" // "Hello my name is Joe!"

  val oneThird = 1.0 / 3.0
//  val oneThirdLongString = "One third is $oneThird as a decimal."
  val oneThirdLongString = "One third is ${1.0 / 3.0} as a decimal."

  // LONG STRINGS
  val bigString = """
        |You can have a string
        |that contains multiple
        |lines
        |by
        |doing this.
    """.trimMargin()
  println(bigString)


  // TUPLES
  val coordinates: Pair<Int, Int> = Pair(2, 3)
  val coordinatesInferred = Pair(2, 3)
  val coordinatesWithTo = 2 to 3

  val coordinatesDoubles = Pair(2.1, 3.5)
  val coordinatesMixed = Pair(2.1, 3)

  val x1 = coordinates.first
  val y1 = coordinates.second

  val (x, y) = coordinates

  val coordinates3D = Triple(2, 3, 1)
  val (x3, y3, z3) = coordinates3D
  //val x3 = coordinates3D.first
  //val y3 = coordinates3D.second
  //val z3 = coordinates3D.third

  val (x4, y4, _) = coordinates3D
  println(x4)
  println(y4)

  // AS
  val string = "Hello there"
  val charSequence = string as CharSequence

  // NUMBER TYPES
  val a: Short = 12
  val b: Byte = 120
  val c: Int = -100000

  val answer = a + b + c // Answer will be an Int
  println(answer)

  // ANY, UNIT, AND NOTHING TYPES
  val anyNumber: Any = 42
  val anyString: Any = "42"

  fun add(): Unit {
    val result = 2 + 2
    println(result)
  }

  fun doNothingForever(): Nothing {
    while (true) {

    }
  }
}