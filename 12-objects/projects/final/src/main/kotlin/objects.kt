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

data class Student(val id: Int, val firstName: String, val lastName: String) {
  var fullName = "$lastName, $firstName"
}

object StudentRegistry {
  val allStudents = mutableListOf<Student>()

  fun addStudent(student: Student) {
    allStudents.add(student)
  }

  fun removeStudent(student: Student) {
    allStudents.remove(student)
  }

  fun listAllStudents() {
    allStudents.forEach {
      println(it.fullName)
    }
  }
}

object JsonKeys {
  const val JSON_KEY_ID = "id"
  const val JSON_KEY_FIRSTNAME = "first_name"
  const val JSON_KEY_LASTNAME = "last_name"
}

class Scientist private constructor(val id: Int, val firstName: String, val lastName: String) {

  companion object Factory {
    var currentId = 0

    fun newScientist(firstName: String, lastName: String): Scientist {
      currentId += 1
      return Scientist(currentId, firstName, lastName)
    }
  }

  var fullName = "$firstName $lastName"
}

object ScientistRepository {
  val allScientists = mutableListOf<Scientist>()

  fun addScientist(scientist: Scientist) {
    allScientists.add(scientist)
  }

  fun removeScientist(scientist: Scientist) {
    allScientists.remove(scientist)
  }

  fun listAllScientists() {
    allScientists.forEach {
      println("${it.id}: ${it.fullName}")
    }
  }
}

interface Counts {
  fun studentCount(): Int
  fun scientistCount(): Int
}

fun main() {

  // Singletons

  //// object keyword

  val marie = Student(1, "Marie", "Curie")
  val albert = Student(2, "Albert", "Einstein")
  val richard = Student(3, "Richard", "Feynman")

  StudentRegistry.addStudent(marie)
  StudentRegistry.addStudent(albert)
  StudentRegistry.addStudent(richard)

  StudentRegistry.listAllStudents()
  // > Curie, Marie
  // > Einstein, Albert
  // > Feynman, Richard

  // Java static members

  //// Companion object

  val emmy = Scientist.newScientist("Emmy", "Noether")
  val isaac = Scientist.Factory.newScientist("Isaac", "Newton")
  val nick = Scientist.newScientist("Nikola", "Tesla")

  ScientistRepository.addScientist(emmy)
  ScientistRepository.addScientist(isaac)
  ScientistRepository.addScientist(nick)

  ScientistRepository.listAllScientists()
  // > 1: Emmy Noether
  // > 2: Isaac Newton
  // > 3: Nikola Tesla

  //// Accessing from Java

  /* Scientist isaac = Scientist.Factory.newScientist("Isaac", "Newton") */

  // Anonymous classes

  val counter = object : Counts {
    override fun studentCount(): Int {
      return StudentRegistry.allStudents.size
    }

    override fun scientistCount(): Int {
      return ScientistRepository.allScientists.size
    }
  }

  println(counter.studentCount()) // > 3
  println(counter.scientistCount()) // > 3
}