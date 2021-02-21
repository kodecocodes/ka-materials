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

  val intermediateCategory = participants
      .filter { it.strength in 40..80 }
      .take(4)

  if (intermediateCategory.size < 4) throw IllegalArgumentException("Invalid number of participants. Try again")

  Battlefield.beginBattle(intermediateCategory[0], intermediateCategory[1]) { firstFinalist ->
    firstFinalist.report("Passed to the final")
    Battlefield.beginBattle(intermediateCategory[2], intermediateCategory[3]) { secondFinalist ->
      secondFinalist.report("Passed to the final")
      Battlefield.beginBattle(firstFinalist, secondFinalist) { winner ->
        winner.report("Win!")
      }
    }
  }

  getNElementsOfFibonacci(15).forEach {
    println(it)
  }
}

fun getNElementsOfFibonacci(n: Int): Sequence<Int> {
  val sequence = generateSequence(1 to 1) {
    it.second to it.first + it.second
  }.map { it.first }

  return sequence.take(n)
}