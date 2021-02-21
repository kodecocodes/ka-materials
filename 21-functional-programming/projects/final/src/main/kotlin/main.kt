import java.util.*

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
  val firstRobot = Robot("Experimental Space Navigation Droid")
  val secondRobot = Robot("Extra-Terrestrial Air Safety Droid")

  Battlefield.beginBattle(firstRobot, secondRobot, fun(robot) {
    robot.report("Win!")
  })

  pow(2, 4)

  var result = 0

  val sum = { a: Int, b: Int ->
    result = a + b
  }

  sum(5, 18)

  val string = "Hello world"
  string.print()

  val participants = arrayListOf<Robot>(
    Robot("Extra-Terrestrial Neutralization Bot"),
    Robot("Generic Evasion Droid"),
    Robot("Self-Reliant War Management Device"),
    Robot("Advanced Nullification Android"),
    Robot("Rational Network Defense Droid"),
    Robot("Motorized Shepherd Cyborg"),
    Robot("Reactive Algorithm Entity"),
    Robot("Ultimate Safety Guard Golem"),
    Robot("Nuclear Processor Machine"),
    Robot("Preliminary Space Navigation Machine")
  )

  val topCategory = participants
    .filter { it.strength > 80 }
    .take(3)
    .sortedBy { it.name }

  val random = Random()
  val sequence = generateSequence {
    random.nextInt(100)
  }

  sequence
    .take(15)
    .sorted()
    .forEach { println(it) }

  val factorial = generateSequence(1 to 1) {
    it.first + 1 to it.second * (it.first + 1)
  }

  println(factorial.take(10).map { it.second }.last())
}

val pow: (Int, Int) -> Double = { base, exponent ->
  Math.pow(base.toDouble(), exponent.toDouble())
}

val root: (Int) -> Double = { Math.sqrt(it.toDouble()) }

fun calculateEven() {
  var result = 0

  (0..20).forEach(fun(value) {
    if (value % 3 == 0) return

    if (value % 2 == 0) result += value
  })

  println(result)
}

inline fun someFunction(crossinline body: () -> Unit) {
  yetAnotherFunction {
    body()
  }
}

fun yetAnotherFunction(body: () -> Unit) {

}