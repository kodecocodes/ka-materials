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

class Person(var firstName: String, var lastName: String) {
  val fullName
    get() = "$firstName $lastName"
}

class Grade(val letter: String, val points: Double, val credits: Double)

class Student(
  val firstName: String,
  val lastName: String,
  val grades: MutableList<Grade> = mutableListOf(),
  var credits: Double = 0.0) {
  val gpa: Double
    get() {
      var totalPoints = 0.0
      grades.forEach {
        totalPoints += it.points
      }
      return totalPoints/credits
    }

  fun recordGrade(grade: Grade) {
    grades.add(grade)
    credits += grade.credits
  }
}

fun main() {

  // Mini-exercise

  val john = Person(firstName = "Johnny", lastName = "Appleseed")

  var homeOwner = john

  homeOwner.lastName = "Smith"
  println(john.fullName)      // > John Smith
  println(homeOwner.fullName) // > John Smith

  // Mini-exercise

  fun memberOf(person: Person, group: Array<Person>): Boolean {
    return group.contains(person)
  }

  val groupWithJohn = arrayOf(
    Person("A", "B"),
    Person("C", "D"),
    john,
    Person("E", "F"),
    Person("G", "H")
  )

  val groupWithoutJohn = arrayOf(
    Person("A", "B"),
    Person("C", "D"),
    Person("E", "F"),
    Person("G", "H"),
    Person("I", "J")
  )

  println(memberOf(john, groupWithJohn)) // > true
  println(memberOf(john, groupWithoutJohn)) // > false

  // Mini-exercise

  val jane = Student(firstName = "Jane", lastName = "Appleseed")
  val history = Grade(letter = "B", points = 9.0, credits = 3.0)
  var math = Grade(letter = "A", points = 16.0, credits = 4.0)

  jane.recordGrade(history)
  jane.recordGrade(math)

  println(jane.gpa)
}