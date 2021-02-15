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

import java.util.*
import kotlin.concurrent.timerTask
import kotlin.system.exitProcess

enum class DownloadState {
  Starting,
  InProgress,
  Error,
  Success
}

class Downloader {

  private val maxData = 100
  var downloadState: DownloadState? = null
  private var fakeData: MutableList<Int> = mutableListOf()

  fun downloadData(fromUrl: String, progress: (state: DownloadState?) -> Unit, completion: (error: Error?, data: List<Int>?) -> Unit) {
    println("\"Downloading\" from URL: ${fromUrl}")
    postProgress(progress)
    downloadState = DownloadState.Starting
    keepAddingData(completion)
  }

  private fun keepAddingData(completion: (error: Error?, data: List<Int>?) -> Unit) {
    addMoreData { error ->
      when (downloadState) {
        DownloadState.Error -> completion(error, null)
        DownloadState.Success -> completion(null, fakeData.toList())
        else -> keepAddingData(completion)
      }
    }
  }

  private fun postProgress(progress: (state: DownloadState?) -> Unit) {
    progress(downloadState)

    when (downloadState) {
      DownloadState.Error -> exitProcess(1)
      DownloadState.Success -> exitProcess(0)
      else -> Timer().schedule(timerTask { postProgress(progress) }, 200)
    }
  }

  private fun addMoreData(completion: (error: Error?) -> Unit) {
    Timer().schedule(timerTask {
      val error = randomlyThrowError()
      if (error != null) {
        downloadState = DownloadState.Error
        completion(error)
      } else {
        downloadState = DownloadState.InProgress
        for (i in 0..20) {
          fakeData.add(i)
          if (fakeData.size == maxData) {
            downloadState = DownloadState.Success
            break
          }
        }

        completion(null)
      }
    }, 500)
  }

  private fun randomlyThrowError(): Error? {
    val randomNumber: Int = (0..10).random()
    if (randomNumber == 8) {
      return Error("Your download was eaten by a shark.")
    } else {
      return null
    }
  }
}

// Via https://stackoverflow.com/a/45687695/681493
fun ClosedRange<Int>.random() =
    Random().nextInt(endInclusive - start) + start