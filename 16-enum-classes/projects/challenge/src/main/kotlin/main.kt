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
  Wednesday(true),
  Thursday(true),
  Friday,
  Saturday,
  Sunday;

  fun daysUntil(other: DayOfTheWeek): Int {
    return if (this.ordinal < other.ordinal) {
      other.ordinal - this.ordinal
    } else {
      other.ordinal - this.ordinal + DayOfTheWeek.values().count()
    }
  }

  fun daysUntilWeekend(): Int {
    return daysUntil(DayOfTheWeek.firstWeekendDay())
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

    fun forIndex(index: Int): DayOfTheWeek? {
      return DayOfTheWeek.values().firstOrNull { it.ordinal == index }
    }

    fun forString(string: String): DayOfTheWeek? {
      return DayOfTheWeek.values().firstOrNull { it.name == string }
    }

    fun firstWeekendDay(): DayOfTheWeek {
      return DayOfTheWeek.values().first { it.isWeekend }
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

  companion object {
    fun checkSufficientFunds(fundsAvailable: List<AcceptedCurrency>, purchasePriceInDollars: Float): Boolean {
      val totalFundsInDollars = fundsAvailable.fold(0.0f, { accumulator, currency -> accumulator + currency.valueInDollars })
      return totalFundsInDollars >= purchasePriceInDollars
    }
  }

  operator fun plus(otherFunds: AcceptedCurrency): AcceptedCurrency {
    if (this::class == otherFunds::class) {
      this.amount += otherFunds.amount
      return this
    } else {
      // NOTE: There are other ways to think about this, but this is probably the most straightforward one.
      val dollars = Dollar()
      dollars.amount = this.valueInDollars + otherFunds.valueInDollars
      return dollars
    }
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
    else -> println("I'm tired of this warning about not all cases being handled")
  }

  val dayAtIndex3 = DayOfTheWeek.forIndex(3)
  println("Day at index 3: $dayAtIndex3")

  val dayAtIndex7 = DayOfTheWeek.forIndex(7)
  println("Day at index 7: $dayAtIndex7")

  val thursdayString = "Thursday"
  val thursdayDay = DayOfTheWeek.forString(thursdayString)
  println("Day of the week for string \"$thursdayString\": $thursdayDay")

  val blernsdayString = "Blernsday"
  val blerndsayDay = DayOfTheWeek.forString(blernsdayString)
  println("Day of the week for string \"$blernsdayString\": $blerndsayDay")

  val firstWeekendDay = DayOfTheWeek.firstWeekendDay()
  val daysUntilWeekendFromWednesday = DayOfTheWeek.Wednesday.daysUntilWeekend()
  println("From Wednesday there are $daysUntilWeekendFromWednesday days until the weekend, which starts on $firstWeekendDay")

  val daysUntilWeekendFromSaturday = DayOfTheWeek.Saturday.daysUntilWeekend()
  println("From Saturday there are $daysUntilWeekendFromSaturday days until the weekend, which starts on $firstWeekendDay")

  val currency = AcceptedCurrency.Crypto()
  println("You've got some ${currency.name}!")
  currency.amount = .27541f
  println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in Dollars")

  val dollars = AcceptedCurrency.Dollar()
  dollars.amount = 2000f

  val sufficentBalance = AcceptedCurrency.checkSufficientFunds(listOf(currency, dollars), 1000f)
  println("You ${if (sufficentBalance) "do" else "do not"} have enough money to buy the thing!")

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
