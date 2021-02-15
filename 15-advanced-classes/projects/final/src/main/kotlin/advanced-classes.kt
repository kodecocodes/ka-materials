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

sealed class Shape {
  class Circle(val radius: Int): Shape()
  class Square(val sideLength: Int): Shape()
}

//class Car(val carName: String) {
//  class Engine(val engineName: String) {
//    override fun toString(): String {
//      return "$engineName in a $carName" // Error cannot see outer scope
//    }
//  }
//}

class Car(val carName: String) {
  inner class Engine(val engineName: String) {
    override fun toString(): String {
      return "$engineName engine in a $carName"
    }
  }
}

fun main() {

  // Introducing inheritance

  data class Grade(val letter: Char, val points: Double, val credits: Double)

  open class Person constructor(var firstName: String, var lastName: String) {
    fun fullName() = "$firstName $lastName"
  }

  /*
  From earlier chapter

  class Student(var firstName: String, var lastName: String, var grades: MutableList<Grade> = mutableListOf<Grade>()) {
    fun recordGrade(grade: Grade) {
      grades.add(grade)
    }
  }
  */

  open class Student(firstName: String, lastName: String, var grades: MutableList<Grade> = mutableListOf<Grade>())
    : Person(firstName, lastName) {
    open fun recordGrade(grade: Grade) {
      grades.add(grade)
    }
  }

  val john = Person(firstName = "Johnny", lastName = "Appleseed")
  val jane = Student(firstName = "Jane", lastName = "Appleseed")

  john.fullName() // Johnny Appleseed
  jane.fullName() // Jane Appleseed

  val history = Grade(letter = 'B', points = 9.0, credits = 3.0)
  jane.recordGrade(history)

  open class BandMember(firstName: String, lastName: String): Student(firstName, lastName) {
    open val minimumPracticeTime: Int
      get() { return  2 }
  }

  class OboePlayer(firstName: String, lastName: String): BandMember(firstName, lastName) {
    override val minimumPracticeTime: Int = super.minimumPracticeTime * 2
  }

  //// Polymorphism

  fun phonebookName(person: Person): String {
    return "${person.lastName}, ${person.firstName}"
  }

  val person = Person(firstName = "Johnny", lastName = "Appleseed")
  val oboePlayer = OboePlayer(firstName = "Jane", lastName = "Appleseed")

  phonebookName(person)     // Appleseed, Johnny
  phonebookName(oboePlayer) // Appleseed, Jane

  //// Runtime hierarchy checks

  var hallMonitor = Student(firstName = "Jill", lastName = "Bananapeel")

  hallMonitor = oboePlayer

  println(hallMonitor is OboePlayer) // true, since assigned it to oboePlayer
  println(hallMonitor !is OboePlayer) // also have !is for "not-is"
  println(hallMonitor is Person) // true, because Person is ancestor of OboePlayer

  //(oboePlayer as Student).minimumPracticeTime // Error: No longer a band member!

  println((hallMonitor as? BandMember)?.minimumPracticeTime) // > 4

  fun afterClassActivity(student: Student): String {
    return "Goes home!"
  }

  fun afterClassActivity(student: BandMember): String {
    return "Goes to practice!"
  }

  println(afterClassActivity(oboePlayer))            // Goes to practice!
  println(afterClassActivity(oboePlayer as Student)) // Goes home!

  //// Inheritance, methods, and overrides

  class StudentAthlete(firstName: String, lastName: String): Student(firstName, lastName) {
    val failedClasses = mutableListOf<Grade>()

    override fun recordGrade(grade: Grade) {
      super.recordGrade(grade)

      if (grade.letter == 'F') {
        failedClasses.add(grade)
      }
    }

    val isEligible: Boolean
      get() = failedClasses.size < 3
  }

  val math = Grade(letter = 'B', points = 9.0, credits = 3.0)
  val science = Grade(letter = 'F', points = 9.0, credits = 3.0)
  val physics = Grade(letter = 'F', points = 9.0, credits = 3.0)
  val chemistry = Grade(letter = 'F', points = 9.0, credits = 3.0)

  val dom = StudentAthlete(firstName = "Dom", lastName = "Grady")
  dom.recordGrade(math)
  dom.recordGrade(science)
  dom.recordGrade(physics)
  println("${dom.fullName()} is ${if (dom.isEligible) "eligible" else "ineligible"}") // eligible
  dom.recordGrade(chemistry)
  println("${dom.fullName()} is ${if (dom.isEligible) "eligible" else "ineligible"}") // ineligible

  //// Introducing super

  //// When to call super

  class StudentAthlete2(firstName: String, lastName: String): Student(firstName, lastName) {
    var failedClasses = mutableListOf<Grade>()

    override fun recordGrade(grade: Grade) {
      var newFailedClasses = mutableListOf<Grade>()
      for (grade in grades) {
        if (grade.letter == 'F') {
          newFailedClasses.add(grade)
        }
      }
      failedClasses = newFailedClasses

      super.recordGrade(grade)
    }

    val isEligible: Boolean
      get() = failedClasses.size < 3
  }

  //// Preventing inheritance

  class FinalStudent(firstName: String, lastName: String): Person(firstName, lastName)
  //class FinalStudentAthlete(firstName: String, lastName: String): FinalStudent(firstName, lastName) // Build error!

  open class AnotherStudent(firstName: String, lastName: String): Person(firstName, lastName) {
    open fun recordGrade(grade: Grade) {}
    fun recordTardy() {}
  }

  class AnotherStudentAthlete(firstName: String, lastName: String): AnotherStudent(firstName, lastName) {
    override fun recordGrade(grade: Grade) {} // OK
//    override fun recordTardy() {} // Build error!
  }

  // Abstract classes

  abstract class Mammal(val birthDate: String) {
    abstract fun consumeFood()
  }

  class Human(birthDate: String): Mammal(birthDate) {
    override fun consumeFood() {
      // ...
    }
    fun createBirthCertificate() {
      // ...
    }
  }

  val human = Human("1/1/2000")
//  val mammal = Mammal("1/1/2000") // Error: Cannot create an instance of an abstract class

  // Sealed classes

  fun size(shape: Shape): Int {
    return when (shape) {
      is Shape.Circle -> shape.radius
      is Shape.Square -> shape.sideLength
    }
  }

  val circle1 = Shape.Circle(4)
  val circle2 = Shape.Circle(2)
  val square1 = Shape.Square(4)
  val square2 = Shape.Square(2)

  // Secondary constructors

  open class Shape {
    constructor(size: Int) {
      // ...
    }

    constructor(size: Int, color: String) : this(size) {
      // ...
    }
  }

  class Circle : Shape {
    constructor(size: Int) : super(size) {
      // ...
    }

    constructor(size: Int, color: String) : super(size, color) {
      // ...
    }
  }

  // Nested and inner classes

  val mazda = Car("mazda")
  val mazdaEngine = mazda.Engine("rotary")
  println(mazdaEngine) // > rotary engine in a mazda

  // Visibility modifiers

  data class Privilege(val id: Int, val name: String)

  open class User(val username: String, private val id: String, protected var age: Int)

  class PrivilegedUser(username: String, id: String, age: Int): User(username, id, age) {
    private val privileges = mutableListOf<Privilege>()

    fun addPrivilege(privilege: Privilege) {
      privileges.add(privilege)
    }

    fun hasPrivilege(id: Int): Boolean {
      return privileges.map { it.id }.contains(id)
    }

    fun about(): String {
      //return "$username, $id" // Error: id is private
      return "$username, $age" // OK: age is protected
    }
  }

  val privilegedUser = PrivilegedUser(username = "sashinka", id = "1234", age = 21)
  val privilege = Privilege(1, "invisibility")
  privilegedUser.addPrivilege(privilege)
  println(privilegedUser.about()) // sashinka, 21

  // When and why to subclass

  data class Sport(val name: String)

  class Student2(firstName: String, lastName: String): Person(firstName, lastName) {
    var grades = mutableListOf<Grade>()
    var sports = mutableListOf<Sport>()
  }

  //// Single responsibility

  //// Strong types

  class Team {
    var players = mutableListOf<StudentAthlete>()

    val isEligible: Boolean
      get() {
        for (player in players) {
          if (!player.isEligible) {
            return false
          }
        }
        return true
      }
  }

  //// Shared base classes

  open class Button {
    fun press() {
    }
  }

  class Image

  class ImageButton(val image: Image): Button()

  class TextButton(val text: String): Button()
}