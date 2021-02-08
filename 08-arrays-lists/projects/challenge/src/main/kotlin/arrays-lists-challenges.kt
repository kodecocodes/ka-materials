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

import java.util.Random

fun main() {

  // Challenge 1 - Which of the following 1-10 are valid statements?

//  val array1 = Array<Int>()
//  val array2 = arrayOf()
  val array3: Array<String> = arrayOf()

  val array4 = arrayOf(1, 2, 3)

  println(array4[0])
//  println(array4[5])
  array4[0] = 4
  println(array4.joinToString())

  var array5 = arrayOf(1, 2, 3)

  array5[0] = array5[1]
//  array5[0] = "Six"
  array5 += 6
  for (item in array5) {
    println(item)
  }

  // Challenge 2 - Write a function that removes the first occurrence of a given integer from a list of integers. This is the signature of the function:
  // fun removeOne(item: Int, list: List<Int>): List<Int>

  fun removeOne(item: Int, list: List<Int>): List<Int> {
    val mutableList = list.toMutableList()
    mutableList.remove(item)
    return mutableList.toList()
  }

  val numbers = listOf(1, 2, 3, 4, 5)
  val newNumbers = removeOne(4, numbers)
  println(newNumbers.joinToString())

  // Challenge 3 - Write a function that removes all occurrences of a given integer from a list of integers. This is the signature of the function:
  // fun remove(item: Int, list: List<Int>): List<Int>

  fun remove(item: Int, list: List<Int>): List<Int> {
    val mutableList = list.toMutableList()
    while (item in mutableList) {
      mutableList.remove(item)
    }
    return mutableList.toList()
  }

  val repeatedFours = listOf(1, 2, 3, 4, 5, 4, 6, 9, 4, 5, 6, 11, 23, 12, 4)
  val noFours = remove(4, repeatedFours)
  println(noFours.joinToString())

  // Challenge 4 - Arrays and lists have a reverse() method that reverses all the elements in-place, that is, within the original array or list. Write a function that does a similar thing, without using reverse(), and returns a new array with the elements of the original array in reverse order. This is the signature of the function:
  // fun reverse(array: Array<Int>): Array<Int>

  fun reverse(array: Array<Int>): Array<Int> {
    val newArray = Array(array.size, { 0 })
    for (i in 0 until array.size) {
      newArray[i] = array[array.size - i - 1]
    }
    return newArray
  }

  val array5reversed = reverse(array5)
  println(array5reversed.joinToString())

  // Challenge 5 - The function below returns a random number between from (inclusive) and the to (exclusive):
  /*

import java.util.Random
val random = Random()
fun rand(from: Int, to: Int) : Int {
  return random.nextInt(to - from) + from
}

  */
  // Use it to write a function that shuffles the elements of an array in random order. This is the signature of the function:
  // fun randomized(array: Array<Int>): Array<Int>

  val random = Random()
  fun rand(from: Int, to: Int): Int {
    return random.nextInt(to - from) + from
  }

  fun randomized(array: Array<Int>): Array<Int> {
    val newArray = Array(array.size, { 0 })
    val usedIndices = mutableListOf<Int>()

    for (i in 0 until array.size) {
      var randomIndex = 0
      while (true) {
        randomIndex = rand(0, array.size)
        if (randomIndex !in usedIndices) {
          usedIndices.add(randomIndex)
          break
        }
      }
      newArray[i] = array[randomIndex]
    }

    return newArray
  }

  val arrayOrdered = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  val arrayRandomized = randomized(arrayOrdered)
  println(arrayRandomized.joinToString())

  // Challenge 6 - Write a function that calculates the minimum and maximum value in an array of integers. Calculate these values yourself; don’t use the methods min and max. Return null if the given array is empty.
  // fun minMax(numbers: Array<Int>): Pair<Int, Int>?
  // HINT: You can use the Int.MIN_VALUE and Int.MAX_VALUE constants within the function.

  fun minMax(numbers: Array<Int>): Pair<Int, Int>? {
    if (numbers.isEmpty()) return null

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    for (number in numbers) {
      if (number < min) {
        min = number
      }
      if (number > max) {
        max = number
      }
    }

    return Pair(min, max)
  }

  val integers = arrayOf(4, -54, -300, 23, 55666, 22, 1, -2223, 33, 11, 500000)
  val minMax = minMax(integers)
  println(minMax?.first)
  println(minMax?.second)
}
