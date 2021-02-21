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

class BuildingYard {

  suspend fun startProject(name: String, floors: Int) {
    val building = withContext(Dispatchers.Default) {
      val building = Building(name, scope = this)

      val cores = Runtime.getRuntime().availableProcessors()

      building.speakThroughBullhorn("The building of $name is started with $cores building machines engaged")
      // Any other phases can't be started until foundation is ready
      building.makeFoundation().join()

      (1..floors).forEach {
        // A floor should be raised before we can decorate it
        building.buildFloor(it).join()

        // These decorations could be made at the same time
        building.placeWindows(it)
        building.installDoors(it)
        building.provideElectricity(it)
        building.fitOut(it)
      }

      building.buildRoof().join()
      building
    }

    if (building.floors == floors) {
      building.speakThroughBullhorn("${building.name} is ready!")
    }
  }

}
