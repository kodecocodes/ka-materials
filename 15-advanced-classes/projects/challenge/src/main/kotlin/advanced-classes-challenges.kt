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

sealed class Resource {
  class Success(data: String) : Resource()
  class Loading : Resource()
  class Error(error: String) : Resource()
}

fun main() {

/*

Challenge 1

Create three simple classes called A, B, and C where C inherits from B and B inherits from A. In each class initializer, call println("I'm <X>!") where X is the name of the class. Create an instance of C called c.  What order do you see each println() called in?

*/

  open class A {
    init {
      println("I'm A!")
    }
  }

  open class B : A() {
    init {
      println("I'm B!")
    }
  }

  class C : B() {
    init {
      println("I'm C!")
    }
  }

  val c = C()

  val a = A()

/*

Challenge 2

Cast the instance of type C to an instance of type A. Which casting operation do you use and why? Create an instance of A called a. What happens if you try to cast a to C?

*/

  println(c as A) // I use `as` because I am sure that C is a sublcass of A and I know I don't have to handle the null case.
  println(a as? C) // I use `as?` because A is not a sublcass of C and I want to avoid a runtime exception.

/*

Challenge 3

Create a subclass of StudentAthlete called StudentBaseballPlayer and include properties for position, number, and battingAverage.  What are the benefits and drawbacks of subclassing StudentAthlete in this scenario?

*/

  data class Grade(val letter: Char, val points: Double, val credits: Double)

  open class Person constructor(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
  }

  open class Student(
    firstName: String,
    lastName: String,
    var grades: MutableList<Grade> = mutableListOf<Grade>()
  ) : Person(firstName, lastName) {
    open fun recordGrade(grade: Grade) {
      grades.add(grade)
    }
  }

  open class StudentAthlete(firstName: String, lastName: String) : Student(firstName, lastName) {
    val failedClasses = mutableListOf<Grade>()
    val sports = mutableListOf<Grade>()

    override fun recordGrade(grade: Grade) {
      super.recordGrade(grade)

      if (grade.letter == 'F') {
        failedClasses.add(grade)
      }
    }

    val isEligible: Boolean
      get() = failedClasses.size < 3
  }

  class StudentBaseballPlayer(
    firstName: String,
    lastName: String,
    val position: String,
    val number: Int,
    val battingAverage: Double
  ) : StudentAthlete(firstName, lastName)

  /*
  Benefits:
  - Automatically get properties all student athletes will have - grades and names
  - Type relationship with superclasses. StudentBaseballPlayer _is_ a Student
  - Baseball players have same rules of eligibility
  */

  /*
  Drawbacks:
  - Primary constructor is getting bloated
  - `sports` is a bit awkward to a baseball player object
  - Deep class hierarchy would make similar classes difficult.
    For instance, an almost identical class would need to be made for a
    `SoftballPlayer` who joined a league after graduating.
    They would no longer be a `Student`, only a `Person`!
   */


/*

Challenge 4

Create a sealed class Resource with subtypes Success, Loading, and Error. Give the Success type a string data property and the Error type a string error property. Can you imagine a use for this Resource type?

*/

  /*
  The `Resource` type would be useful for the return type of
  a long running call that runs in the background, such as a network call.
  You would return `Loading` while the call is running, `Success` with `data`
  if it succeeds, and `Error` with `error` if it does not.
   */
}