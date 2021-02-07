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

import kotlin.math.sqrt

fun main() {

/*:
 ### Challenge 1: It’s prime time

 When I’m acquainting myself with a programming language, one of the first things I do is write a function to determine
 whether or not a number is prime. That’s your first challenge.

 First, write the following function:

 ```kotlin
 fun isNumberDivisible(number: Int, divisor: Int): Boolean
 ```

 You’ll use this to determine if one number is divisible by another. It should return `true` when `number` is divisible
 by `divisor`.

 **Hint**: You can use the modulo (`%`) operator to help you out here.

 Next, write the main function:

 ```kotlin
 fun isPrime(number: Int): Boolean
 ```

 This should return `true` if `number` is prime, and `false` otherwise. A number is prime if it’s only divisible by 1
 and itself. You should loop through the numbers from 1 to the number and find the number’s divisors. If it has any
 divisors other than 1 and itself, then the number isn’t prime. You’ll need to use the `isNumberDivisible(_:by:)`
 function you wrote earlier.

 Use this function to check the following cases:

 ```kotlin
 isPrime(6) // false
 isPrime(13) // true
 isPrime(8893) // true
 ```

 **Hint 1**: Numbers less than 0 should not be considered prime. Check for this case at the start of the function and
 * return early if the number is less than 0.

 **Hint 2**: Use a `for` loop to find divisors. If you start at 2 and end before the number itself, then as soon as you
 * find a divisor, you can return `false`.

 **Hint 3**: If you want to get *really* clever, you can simply loop from 2 until you reach the square root of `number`
 * rather than going all the way up to `number` itself. I’ll leave it as an exercise for you to figure out why. It may
 * help to think of the number 16, whose square root is 4. The divisors of 16 are 1, 2, 4, 8 and 16.
 */

  fun isNumberDivisible(number: Int, divisor: Int): Boolean {
    return number % divisor == 0
  }

  fun isPrime(number: Int): Boolean {
    if (number < 0) {
      return false
    }

    /*
     We handle these cases up front because we want to make sure the range 2...root (used below) is valid, which is the

     case only when root >= 2, so for numbers >= 4.
     */
    if (number <= 3) {
      return true
    }

    val doubleNumber = number.toDouble()
    val root = (sqrt(doubleNumber)).toInt()
    for (divisor in 2..root) {
      if (isNumberDivisible(number, divisor)) {
        return false
      }
    }
    return true
  }
  println(isPrime(6))
  println(isPrime(13))
  println(isPrime(8893))


/*:
 ### Challenge 2: Recursive functions

 In this challenge, you’re going to see what happens when a function calls *itself*, a behavior called **recursion**.
 This may sound unusual, but it can be quite useful.

 You’re going to write a function that computes a value from the **Fibonacci sequence**. Any value in the sequence is
 the sum of the previous two values. The sequence is defined such that the first two values equal 1. That is,
 `fibonacci(1) = 1` and `fibonacci(2) = 1`.

 Write your function using the following declaration:

 ```swift
 fun fibonacci(number: Int): Int
 ```

 Then, verify you’ve written the function correctly by executing it with the following numbers:

 ```kotlin
 fibonacci(1)  // = 1
 fibonacci(2)  // = 1
 fibonacci(3)  // = 2
 fibonacci(4)  // = 3
 fibonacci(5)  // = 5
 fibonacci(6)  // = 8
 fibonacci(7)  // = 13
 fibonacci(10) // = 55
 ```

 **Hint 1**: For values of `number` less than 0, you should return 0.

 **Hint 2**: To start the sequence, hard-code a return value of 1 when `number` equals 1 or 2.

 **Hint 3**: For any other value, you’ll need to return the sum of calling `fibonacci` with `number - 1` and `number - 2`.
*/

  fun fibonacci(number: Int): Int {
    if (number <= 0) {
      return 0
    }

    if (number == 1 || number == 2) {
      return 1
    }

    return fibonacci(number - 1) + fibonacci(number - 2)
  }
  println(fibonacci(1))
  println(fibonacci(2))
  println(fibonacci(3))
  println(fibonacci(4))
  println(fibonacci(5))
  println(fibonacci(6))
  println(fibonacci(7))
  println(fibonacci(10))

}
