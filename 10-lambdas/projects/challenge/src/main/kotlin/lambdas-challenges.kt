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

/*

Challenge 1: Repeating yourself

Your first challenge is to write a function that will run a given lambda a given number of times.

Declare the function like so:

    fun repeatTask(times: Int, task: () -> Unit)

The function should run the task lambda times number of times.

Use this function to print "Kotlin Apprentice is a great book!" 10 times.

*/

  fun repeatTask(times: Int, task: () -> Unit) {
    for (time in 0 until times) {
      task()
    }
  }

  repeatTask(10) {
    println("Kotlin Apprentice is a great book!")
  }

/*

Challenge 2: Lambda sums

In this challenge, you’re going to write a function that you can reuse to create different mathematical sums.

Declare the function like so:

    fun mathSum(length: Int, series: (Int) -> Int) -> Int

The first parameter, length, defines the number of values to sum. The second parameter, series, is a lambda that can be used to generate a series of values. series should have a parameter that is the position of the value in the series and return the value at that position.

mathSum should calculate length number of values, starting at position 1, and return their sum.

Use the function to find the sum of the first 10 square numbers, which equals 385. Then use the function to find the sum of the first 10 Fibonacci numbers, which equals 143.

For the Fibonacci numbers, you can use the function you wrote in the challenges of the functions chapter — or grab it from the solutions if you’re unsure what you’ve done is correct.


*/

  fun mathSum(length: Int, series: (Int) -> Int): Int {
    var result = 0
    for (i in 0..length) {
      result += series(i)
    }
    return result
  }

  println(mathSum(10) { it * it }) // > 385

  fun fibonacci(number: Int): Int {
    if (number <= 0) {
      return 0
    }
    if (number == 1 || number == 2) {
      return 1
    }
    return fibonacci(number - 1) + fibonacci(number - 2)
  }

  println(mathSum(10, ::fibonacci)) // > 143


/*

Challenge 3: Functional ratings

In this final challenge, you will have a list of app names with associated ratings they’ve been given. Note — these are all fictional apps!

Create the data map like so:

    val appRatings = mapOf(
      "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
      "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
      "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
    )

First, create a map called averageRatings which will contain a mapping of app names to average ratings. Use forEach to iterate through the appRatings map, then use reduce to calculate the average rating and store this rating in the averageRatings map.

Finally, use filter and map chained together to get a list of the app names whose average rating is greater than 3.

*/

  val appRatings = mapOf(
      "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
      "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
      "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
  )

  val averageRatings = mutableMapOf<String, Double>()
  appRatings.forEach {
    val total = it.value.reduce(Int::plus) // + is a function too!
    averageRatings[it.key] = total.toDouble() / it.value.size
  }
  println(averageRatings) // > {Calendar Pro=3.375, The Messenger=3.0, Socialise=2.0}

  val goodApps = averageRatings.filter {
    it.value > 3
  }.map {
    it.key
  }
  println(goodApps) // > [Calendar Pro]
}
