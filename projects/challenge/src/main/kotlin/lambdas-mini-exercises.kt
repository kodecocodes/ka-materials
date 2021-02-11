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

  // Mini-exercises

  //// 1

  val nameList = listOf("Anna", "Bob", "Craig", "Donna")

  var namesConcat = nameList.fold("") { a, b ->
    a + b
  }
  println(namesConcat) // > AnnaBobCraigDonna

  //// 2

  namesConcat = nameList.filter {
    it.length > 4
  }.fold("") { a, b ->
    a + b
  }
  println(namesConcat) // > CraigDonna

  //// 3

  val namesAndAges = mapOf("Anna" to 16, "Bob" to 35, "Craig" to 15, "Donna" to 28)

  val youngPeople = namesAndAges.filter {
    it.value < 18
  }
  println(youngPeople) // > {Anna=16, Craig=15}

  //// 4

  val youngPeopleNames = namesAndAges.filter {
    it.value < 18
  }.map {
    it.key
  }
  println(youngPeopleNames) // > [Anna, Craig]
}
