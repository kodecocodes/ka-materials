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

  // Introducing null

  var name = "Joe Howard"
  var age = 30
  var occupation = "Software Developer & Author"

  // Introducing nullable types

  var errorCode: Int?
  errorCode = 100
  errorCode = null

  // Checking for null

  var result: Int? = 30
  println(result)

  //println(result + 1) // Operator call corresponds to a dot-qualified call 'result.plus(1)' which is not allowed on a nullable receiver 'result`.

  //// Not-null assertion operator

  var authorName: String? = "Joe Howard"
  var authorAge: Int? = 24

  val ageAfterBirthday = authorAge!! + 1
  println("After their next birthday, author will be $ageAfterBirthday")

//  authorAge = null
  println("After two birthdays, author will be ${authorAge!! + 2}")

  //// Null checks

  var nonNullableAuthor: String
  var nullableAuthor: String?

  if (authorName != null) {
    nonNullableAuthor = authorName
  } else {
    nullableAuthor = authorName
  }

  // Safe call

  var nameLength = authorName?.length
  println("Author's name has length $nameLength.")

  val nameLengthPlus5 = authorName?.length?.plus(5)
  println("Author's name length plus 5 is $nameLengthPlus5.")

  //// The let() function

  authorName?.let {
    nonNullableAuthor = authorName
  }

  authorName?.let {
    nameLength = authorName.length
  }

  // Elvis operator

  var nullableInt: Int? = 10
  var mustHaveResult = nullableInt ?: 0

  mustHaveResult = if (nullableInt != null) nullableInt else 0

  nullableInt = null
  mustHaveResult = nullableInt ?: 0
}