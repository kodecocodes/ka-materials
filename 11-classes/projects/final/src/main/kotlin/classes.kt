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

import java.util.*

class Person(var firstName: String, var lastName: String) {
  val fullName
    get() = "$firstName $lastName"
}

class SimplePerson(val name: String)

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

  // Creating classes

  val john = Person(firstName = "Johnny", lastName = "Appleseed")
  println(john.fullName) // > Johnny Appleseed

  // Reference types

  var var1 = SimplePerson(name = "John")

  var var2 = var1

  //// Working with references

  var homeOwner = john

  john.firstName = "John"

  println(john.firstName)      // > John
  println(homeOwner.firstName) // > John

  homeOwner.lastName = "Smith"
  println(john.fullName)      // > John Smith
  println(homeOwner.fullName) // > John Smith

  //// Object identity

  println(homeOwner === john) // > true

  val impostorJohn = Person(firstName = "John", lastName = "Appleseed")

  john === homeOwner // true
  john === impostorJohn // false
  impostorJohn === homeOwner // false

  // Assignment of existing variables changes the instances the variables reference.
  homeOwner = impostorJohn
  john === homeOwner // false

  homeOwner = john
  john === homeOwner // true

  var imposters = (0..100).map {
    Person(firstName = "John", lastName = "Appleseed")
  }

  imposters.map {
    it.firstName == "John" && it.lastName == "Appleseed"
  }.contains(true) // true

  println(imposters.contains(john)) // > false

  val mutableImposters = mutableListOf<Person>()
  mutableImposters.addAll(imposters)
  mutableImposters.contains(john) // false
  mutableImposters.add(Random().nextInt(5), john)
  println(mutableImposters.contains(john)) // > true

  val indexOfJohn = mutableImposters.indexOf(john)
  if (indexOfJohn != -1) {
    mutableImposters[indexOfJohn].lastName = "Bananapeel"
  }

  println(john.fullName) // > John Bananapeel


  //// Methods and mutability

  val jane = Student(firstName = "Jane", lastName = "Appleseed")
  val history = Grade(letter = "B", points = 9.0, credits = 3.0)
  var math = Grade(letter = "A", points = 16.0, credits = 4.0)

  jane.recordGrade(history)
  jane.recordGrade(math)

  //// Mutability and constants

  // Error: jane is a `val` constant
  // jane = Student(firstName = "John", lastName = "Appleseed")

  var bob = Student(firstName = "Bob", lastName = "Appleseed")
  bob = Student(firstName = "Bobby", lastName = "Appleseed")


  // Understanding state and side effects

  println(jane.credits) // 7.0

  math = Grade(letter = "A", points = 20.0, credits = 5.0)
  jane.recordGrade(math)

  println(jane.credits) // 12.0, not 8.0!

  // Data classes

  class Student(var firstName: String, var lastName: String, var id: Int) {

    override fun hashCode(): Int {
      val prime = 31
      var result = 1

      result = prime * result + firstName.hashCode()
      result = prime * result + id
      result = prime * result + lastName.hashCode()

      return result
    }

    override fun equals(other: Any?): Boolean {
      if (this === other)
        return true

      if (other == null)
        return false

      if (javaClass != other.javaClass)
        return false

      val obj = other as Student?

      if (firstName != obj?.firstName)
        return false

      if (id != obj.id)
        return false

      if (lastName != obj.lastName)
        return false

      return true
    }

    override fun toString(): String {
      return "Student (firstName=$firstName, lastName=$lastName, id=$id)"
    }

    fun copy(firstName: String = this.firstName, lastName: String = this.lastName, id: Int = this.id)
        = Student(firstName, lastName, id)
  }

  val albert = Student(firstName = "Albert", lastName = "Einstein", id = 1)
  val richard = Student(firstName = "Richard", lastName = "Feynman", id = 2)
  val albertCopy = albert.copy()

  println(albert)  // > Student (firstName=Albert, lastName=Einstein, id=1)
  println(richard) // > Student (firstName=Richard, lastName=Feynman, id=2)
  println(albert == richard) // > false
  println(albert == albertCopy) // > true
  println(albert === albertCopy) // > false

  data class StudentData(var firstName: String, var lastName: String, var id: Int)

  val marie = StudentData("Marie", "Curie", id = 1)
  val emmy = StudentData("Emmy", "Noether", id = 2)
  val marieCopy = marie.copy()

  println(marie) // > StudentData(firstName=Marie, lastName=Curie, id=1)
  println(emmy)  // > StudentData(firstName=Emmy, lastName=Noether, id=2)
  println(marie == emmy) // > false
  println(marie == marieCopy) // > true
  println(marie === marieCopy) // > false

  //// Destructuring declarations

  val (firstName, lastName, id) = marie

  println(firstName) // > Marie
  println(lastName)  // > Curie
  println(id)        // > 1
}