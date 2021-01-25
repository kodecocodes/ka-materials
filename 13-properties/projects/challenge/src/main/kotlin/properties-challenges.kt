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

import kotlin.properties.Delegates

class IceCream {
  var name: String = ""
  val ingredients: ArrayList<String> by lazy {
    arrayListOf<String>()
  }
}

class Car(val make: String, val color: String, val tank: FuelTank = FuelTank())

class FuelTank {
  var lowFuel = true
  var level: Double by Delegates.observable(0.0) {
      _, _, new ->
    lowFuel = new < 0.1
  }
}

fun main() {

/*

Challenge 1

Rewrite the IceCream class below to use default values and lazy initialization:

    class IceCream {
      val name: String
      val ingredients: ArrayList<String>
    }

1. Use a default value for the name property.
2. Lazily initialize the ingredients list.

*/

  val mintChocolateChip = IceCream()
  mintChocolateChip.name = "Min Chocolate Chip"
  mintChocolateChip.ingredients.add("mint")
  mintChocolateChip.ingredients.add("chocolate chips")

/*

Challenge 2

At the beginning of the chapter, you saw a Car class. Dive into the inner workings of the car and rewrite the FuelTank class below with delegated property observer functionality:

    class FuelTank {
      var level = 0.0 // decimal percentage between 0 and 1
    }

1. Add a lowFuel property of Boolean type to the class.
2. Flip the lowFuel Boolean when the level drops below 10%.
3. Ensure that when the tank fills back up, the lowFuel warning will turn off.
4. Add a FuelTank property to Car and fill the tank. Then drive around for awhile.

*/

  val camaro = Car("Chevrolet", "Silver")

  // Fill the tank
  camaro.tank.level = 1.0
  println(camaro.tank.lowFuel)

  // Drive around for awhile
  camaro.tank.level = 0.05
  println(camaro.tank.lowFuel)
}