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

enum class DayOfTheWeek(val isWeekend: Boolean = false) {
  Monday,
  Tuesday,
  Wednesday,
  Thursday,
  Friday,
  Saturday(true),
  Sunday(true);

  fun daysUntil(other: DayOfTheWeek): Int {
    return if (this.ordinal < other.ordinal) {
      other.ordinal - this.ordinal
    } else {
      other.ordinal - this.ordinal + DayOfTheWeek.values().count()
    }
  }

  companion object {
    fun today(): DayOfTheWeek {
      val calendarDayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
      var adjustedDay = calendarDayOfWeek - 2
      val days = DayOfTheWeek.values()
      if (adjustedDay < 0) {
        adjustedDay += days.count()
      }
      val today = days.first { it.ordinal == adjustedDay }
      return today
    }
  }
}

sealed class AcceptedCurrency {
  abstract val valueInDollars: Float
  var amount: Float = 0.0f

  class Dollar: AcceptedCurrency() {
    override val valueInDollars = 1.0f
  }

  class Euro: AcceptedCurrency() {
    override val valueInDollars = 1.25f
  }

  class Crypto: AcceptedCurrency() {
    override val valueInDollars = 2534.92f
  }

  val name: String
    get() = when (this) {
      is Euro -> "Euro"
      is Dollar -> "Dollars"
      is Crypto -> "NerdCoin"
    }

  fun totalValueInDollars(): Float {
    return amount * valueInDollars
  }
}

fun main() {
  for (day in DayOfTheWeek.values()) {
    println("Day ${day.ordinal}: ${day.name}, is weekend: ${day.isWeekend}")
  }

  val dayIndex = 0
  val dayAtIndex = DayOfTheWeek.values()[dayIndex]
  println("Day at $dayIndex is $dayAtIndex")

  val tuesday = DayOfTheWeek.valueOf("Tuesday")
  println("Tuesday is day ${tuesday.ordinal}")

  val today = DayOfTheWeek.today()
  val isWeekend = "It is${if (today.isWeekend) "" else " not"} the weekend"
  val secondDay = DayOfTheWeek.Friday
  val daysUntil = today.daysUntil(secondDay)
  println("It is $today. $isWeekend. There are $daysUntil days until $secondDay.")

  when (today) {
    DayOfTheWeek.Friday -> println("It's $today, I'm in love")
  }

  val currency = AcceptedCurrency.Crypto()
  println("You've got some ${currency.name}!")
  currency.amount = .27541f
  println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in Dollars")

  Downloader().downloadData("foo.com/bar",
      progress = { downloadState ->
        when (downloadState) {
          null -> println("No download state yet")
          DownloadState.Starting -> println("Starting download...")
          DownloadState.InProgress -> println("Downloading data...")
          DownloadState.Error -> println("An error occurred. Download terminated.")
          DownloadState.Success -> println("Download completed successfully.")
        }
      },
      completion = { error, list ->
        error?.let { println("Got error: ${error.message}") }
        list?.let { println("Got list with ${list.size} items") }
      })
}
