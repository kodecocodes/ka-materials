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

interface Vehicle {
  fun accelerate()
  fun stop()
}

enum class Direction {
  LEFT, RIGHT
}

interface DirectionalVehicle {
  fun accelerate()
  fun stop()
  fun turn(direction: Direction)
  fun description(): String
}

interface OptionalDirectionalVehicle {
  fun turn(direction: Direction = Direction.LEFT)
}

interface SpaceVehicle {
  fun accelerate()
  fun stop() {
    println("Whoa, slow down!")
  }
}

interface VehicleProperties {
  val weight: Int
  val name: String
    get() = "Vehicle"
}

interface WheeledVehicle : Vehicle {
  val numberOfWheels: Int
  var wheelSize: Double
}

interface Wheeled {
  val numberOfWheels: Int
  val wheelSize: Double
}

interface SizedVehicle {
  var length: Int
}

fun main() {

  // Introducing interfaces

  //val vehicle = Vehicle() // Error: Interface Vehicle does not have constructors

  //// Interface syntax

  class Unicycle : Vehicle {
    var peddling = false

    override fun accelerate() {
      peddling = true
    }

    override fun stop() {
      peddling = false
    }
  }

  //// Methods in interfaces

  class OptionalDirection : OptionalDirectionalVehicle {
    override fun turn(direction: Direction) {
      println(direction)
    }
  }

  val car = OptionalDirection()
  car.turn() // > LEFT
  car.turn(Direction.RIGHT) // > RIGHT

  // Default method implementations

  class LightFreighter : SpaceVehicle {
    override fun accelerate() {
      println("Proceed to hyperspace!")
    }

  }

  val falcon = LightFreighter()
  falcon.accelerate() // > Proceed to hyperspace!
  falcon.stop() // > "hoa, slow down!

  class Starship : SpaceVehicle {
    override fun accelerate() {
      println("Warp factor 9 please!")
    }

    override fun stop() {
      super.stop()
      println("That kind of hurt!")
    }
  }

  val enterprise = Starship()
  enterprise.accelerate() // > Warp factor 9 please!
  enterprise.stop() // > "Whoa, slow down!\nThat kind of hurt!"

  //// Properties in interfaces

  class Car : VehicleProperties {
    override val weight: Int = 1000
  }

  class Tank : VehicleProperties {
    override val weight: Int
      get() = 10000

    override val name: String
      get() = "Tank"
  }

  //// Interface inheritance

  class Bike : WheeledVehicle {
    var peddling = false
    var brakesApplied = false

    override val numberOfWheels = 2

    override var wheelSize = 622.0

    override fun accelerate() {
      peddling = true
      brakesApplied = false
    }

    override fun stop() {
      peddling = false
      brakesApplied = true
    }
  }

  // Implementing multiple interfaces

  class Tricycle : Wheeled, Vehicle {
    var peddling = false
    var brakesApplied = false

    override val numberOfWheels: Int
      get() = 3

    override val wheelSize: Double
      get() = 100.0

    override fun accelerate() {
      peddling = true
      brakesApplied = false
    }

    override fun stop() {
      peddling = false
      brakesApplied = true
    }
  }

  // Interfaces in the standard library

  // Iterator

  val cars = listOf("Lamborghini", "Ferrari", "Rolls-Royce")
  val numbers = mapOf("Brady" to 12, "Manning" to 18, "Brees" to 9)

  for (car in cars) {
    println(car)
  }
  for (qb in numbers) {
    println("${qb.key} wears ${qb.value}")
  }

  //// Comparable

  class Boat : SizedVehicle, Comparable<Boat> {
    override var length: Int = 0
    override fun compareTo(other: Boat): Int {
      return when {
        length > other.length -> 1
        length == other.length -> 0
        else -> -1
      }
    }
  }

  val titanic = Boat()
  titanic.length = 883

  val qe2 = Boat()
  qe2.length = 963

  println(titanic > qe2) // > false

}