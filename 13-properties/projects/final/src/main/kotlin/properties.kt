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

import kotlin.math.roundToInt
import kotlin.properties.Delegates

class Car(val make: String, val color: String)

class Contact(var fullName: String, var emailAddress: String)

class Contact2(var fullName: String, val emailAddress: String)

class Contact3(var fullName: String, val emailAddress: String, var type: String = "Friend")

class Person(val firstName: String, val lastName: String) {
  val fullName = "$firstName $lastName"
}

class Address {
  var address1: String
  var address2: String? = null
  var city = ""
  var state: String

  init {
    address1 = ""
    state = ""
  }
}

class TV(var height: Double, var width: Double) {
  var diagonal: Int
    get() {
      val result = Math.sqrt(height * height + width * width)
      return result.roundToInt()
    }
    set(value) {
      val ratioWidth = 16.0
      val ratioHeight = 9.0
      val ratioDiagonal = Math.sqrt(
        ratioWidth * ratioWidth + ratioHeight * ratioHeight
      )
      height = value * ratioHeight / ratioDiagonal
      width = height * ratioWidth / ratioHeight
    }
}

class Level(val id: Int, var boss: String, var unlocked: Boolean) {
  companion object {
    @JvmStatic var highestLevel = 1
  }
}

class DelegatedLevel(val id: Int, var boss: String) {
  companion object {
    var highestLevel = 1
  }

  var unlocked: Boolean by Delegates.observable(false) { _, old, new ->
    if (new && id > highestLevel) {
      highestLevel = id
    }
    println("$old -> $new")
  }
}

class Circle(var radius: Double = 0.0) {
  val pi: Double by lazy {
    ((4.0 * Math.atan(1.0 / 5.0)) - Math.atan(1.0 / 239.0)) * 4.0
  }
  val area: Double by lazy {
    pi * radius * radius
  }
  val circumference: Double
    get() = pi * radius * 2
}

class LightBulb {
  companion object {
    const val maxCurrent = 40
  }

  var current by Delegates.vetoable(0) { _, _, new ->
    if (new > maxCurrent) {
      println("Current too high, falling back to previous setting.")
      false
    } else {
      true
    }
  }
}

class Lamp {
  lateinit var bulb: LightBulb
}

val Circle.diameter: Double
  get() = 2.0 * radius

fun main() {

  // Constructor properties

  val contact = Contact(fullName = "Grace Murray", emailAddress = "grace@navy.mil")

  val name = contact.fullName // Grace Murray
  val email = contact.emailAddress // grace@navy.mil

  contact.fullName = "Grace Hopper"
  val grace = contact.fullName // Grace Hopper

  var contact2 = Contact2(fullName = "Grace Murray", emailAddress = "grace@navy.mil")

  // Error: Val cannot be reassigned
  //contact2.emailAddress = "grace@gmail.com"

  //// Default values

  var contact3 = Contact3(fullName = "Grace Murray", emailAddress = "grace@navy.mil")

  // Property initializers

  val person = Person("Grace", "Hopper")
  person.fullName // Grace Hopper

  val address = Address()

  // Custom accessors

  val tv = TV(height = 53.93, width = 95.87)
  val size = tv.diagonal // 110

  tv.width = tv.height
  val diagonal = tv.diagonal // 76

  tv.diagonal = 70
  println(tv.height) // 34.32...
  println(tv.width)  // 61.01...

  // Companion object properties

  val level1 = Level(id = 1, boss = "Chameleon", unlocked = true)
  val level2 = Level(id = 2, boss = "Squid", unlocked = false)
  val level3 = Level(id = 3, boss = "Chupacabra", unlocked = false)
  val level4 = Level(id = 4, boss = "Yeti", unlocked = false)

  // Error: can't access members of the companion object on an instance
  // val highestLevel = level3.highestLevel

  val highestLevel = Level.highestLevel // 1

  // Delegated properties

  //// Observable properties

  val delegatedlevel1 = DelegatedLevel(id = 1, boss = "Chameleon")
  val delegatedlevel2 = DelegatedLevel(id = 2, boss = "Squid")

  println(DelegatedLevel.highestLevel) // 1

  delegatedlevel2.unlocked = true

  println(DelegatedLevel.highestLevel) // 2

  ////// Limiting a variable

  val light = LightBulb()
  light.current = 50
  var current = light.current // 0
  light.current = 40
  current = light.current // 40

  //// lazy properties

  val circle = Circle(5.0) // got a circle, pi has not been run

  val circumference = circle.circumference // 31.42
  // also, pi now has a value

  // lateinit

  val lamp = Lamp()
  //println(lamp.bulb) // Whoops! kotlin.UninitializedPropertyAccessException
  lamp.bulb = LightBulb()

  // Extension properties

  val unitCircle = Circle(1.0)
  println(unitCircle.diameter) // > 2.0
}