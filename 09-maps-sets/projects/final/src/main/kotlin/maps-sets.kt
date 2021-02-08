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

import java.util.HashMap

fun main() {

  /*
   * Maps
   */

  // Creating maps

  var yearOfBirth = mapOf("Anna" to 1990, "Brian" to 1991, "Craig" to 1992, "Donna" to 1993)

  var namesAndScores = mutableMapOf("Anna" to 2, "Brian" to 2, "Craig" to 8, "Donna" to 6)
  println(namesAndScores) // > {Anna=2, Brian=2, Craig=8, Donna=6}

  namesAndScores = mutableMapOf()

  var pairs = HashMap<String, Int>()

  pairs = HashMap<String, Int>(20)

  // Accessing values

  //// Using the index operator

  namesAndScores = mutableMapOf("Anna" to 2, "Brian" to 2, "Craig" to 8, "Donna" to 6)
  // Restore the values

  println(namesAndScores["Anna"])
  // > 2

  val gregScore = namesAndScores["Greg"]
  println(gregScore) // > null

  //// Using properties and methods

  println(namesAndScores.get("Craig"))
  // > 8

  namesAndScores.isEmpty() // false
  namesAndScores.size      // 4

  // Modifying mutable maps

  //// Adding pairs

  val bobData = mutableMapOf("name" to "Bob", "profession" to "CardPlayer", "country" to "USA")
  bobData.put("state", "CA")
  bobData["city"] = "San Francisco"

  //// Updating values

  bobData.put("name", "Bobby") // Bob

  bobData["profession"] = "Mailman"

  val pair = "nickname" to "Bobby D"
  bobData += pair

  println(bobData)
  // > {name=Bobby, profession=Mailman, country=USA, state=CA, city=San Francisco, nickname=Bobby D}

  //// Removing pairs

  bobData.remove("city")
  bobData.remove("state", "CA")

  println(bobData)
  // > {name=Bobby, profession=Mailman, country=USA, nickname=Bobby D}

  // Iterating through maps

  for ((player, score) in namesAndScores) {
    println ("$player - $score")
  }
  // > Anna - 2
  // > Brian - 2
  // > Craig - 8
  // > Donna - 6

  for (player in namesAndScores.keys) {
    print("$player, ") // no newline
  }
  println() // print a newline
  // > Anna, Brian, Craig, Donna,

  // Running time for map operations

  class Bob {}
  val bob = Bob()

  val mapp = hashMapOf(bob to 2)

  println("some string".hashCode())
  // > 1395333309

  println(1.hashCode())
  // > 1
  println(false.hashCode())
  // > 1237

  /*
   * Sets
   */

  // Creating sets

  val names = setOf("Anna", "Brian", "Craig", "Anna")
  println(names)
  // > [Anna, Brian, Craig]

  val hashSet = HashSet<Int>()

  val someArray = arrayOf(1, 2, 3, 1)

  var someSet = mutableSetOf(*someArray)
  println(someSet) // > [1, 2, 3]

  // Accessing elements

  println(someSet.contains(1))
  // > true

  println(4 in someSet)
  // > false

  println(someSet.first())
  println(someSet.last())

  for (number in someSet) {
    println(number)
  }

  // Adding and removing elements

  someSet.add(5)

  val removedOne = someSet.remove(1)
  println(removedOne) // > true

  println(someSet)
  // > [2, 3, 5]
}
