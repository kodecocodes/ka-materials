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

import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.EmptyCoroutineContext

class Building(val name: String, var floors: Int = 0, private val scope: CoroutineScope) {

  val random = Random()

  suspend fun makeFoundation() = scope.launch {
    delay(300)
    speakThroughBullhorn("[${Thread.currentThread().name}] The foundation is ready")
  }

  suspend fun buildFloor(floor: Int) = withContext(scope.coroutineContext) {
    delay(100)

    if (random.nextBoolean()) {
      throw Exception("[${Thread.currentThread().name}] Something went wrong on the $floor'th floor")
    }

    speakThroughBullhorn("[${Thread.currentThread().name}] The $floor'th floor is raised")
    ++floors
  }

  suspend fun placeWindows(floor: Int) = scope.launch {
    delay(100)
    speakThroughBullhorn("[${Thread.currentThread().name}] Windows are placed on floor number $floor")
  }

  suspend fun installDoors(floor: Int) = scope.launch {
    delay(100)
    speakThroughBullhorn("[${Thread.currentThread().name}] Doors are installed on floor number $floor")
  }

  suspend fun provideElectricity(floor: Int) = scope.launch {
    delay(100)
    speakThroughBullhorn("[${Thread.currentThread().name}] Electricity is provided on floor number $floor")
  }

  suspend fun buildRoof() = scope.launch {
    delay(200)
    speakThroughBullhorn("[${Thread.currentThread().name}] The roof is ready")
  }

  suspend fun fitOut(floor: Int) = scope.launch {
    delay(200)
    speakThroughBullhorn("[${Thread.currentThread().name}] Floor number $floor is furnished")
  }

  fun speakThroughBullhorn(message: String) = println(message)

}
