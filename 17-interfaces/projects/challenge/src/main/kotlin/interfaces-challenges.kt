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

/*

Pet shop tasks

Create a collection of interfaces for tasks that need doing at a pet shop. The pet shop has dogs, cats, fish and birds.
The pet shop duties can be broken down into these tasks:

* All pets need to be fed.

* Pets that can fly need to be caged.

* Pets that can swim need a tank.

* Pets that walk need exercise.

* Tanks, cages, and litter boxes need to occasionally be cleaned.

*/

interface Feedable {
  fun feed()
}

interface Cleanable {
  fun clean()
}

interface Cageable : Cleanable {
  fun cage()
}

interface Tankable : Cleanable {
  fun tank()
}

interface Walkable {
  fun walk()
}

fun main() {

  //: 1. Create classes for each animal and adopt the appropriate interfaces. Feel free to simply use a println() statement for the method implementations.
  class Dog : Feedable, Walkable {
    override fun feed() {
      println("Woof...thanks!")
    }

    override fun walk() {
      println("Walk the dog")
    }
  }

  class Cat : Feedable, Cleanable {
    override fun feed() {
      println("Yummy meow")
    }

    override fun clean() {
      println("Litter box cleaned")
    }
  }

  class Fish : Feedable, Tankable {
    override fun feed() {
      println("Fish goes blub")
    }

    override fun tank() {
      println("Fish has been tanked")
    }

    override fun clean() {
      println("Fish tank has been cleaned")
    }
  }

  class Bird : Feedable, Cageable {
    override fun feed() {
      println("Tweet!")
    }

    override fun cage() {
      println("Cage the bird")
    }

    override fun clean() {
      println("Clean the cage")
    }
  }

  //: 2. Create homogeneous arrays for animals that need to be fed, caged, cleaned, walked, and tanked. Add the appropriate animals to these arrays. The arrays should be declared using the interface as the element type, for example `var caged: Array<Cageable>`.

  val dog = Dog()
  val cat = Cat()
  val fish = Fish()
  val bird = Bird()

  val walkingDuties: Array<Walkable> = arrayOf(dog)
  val feedingDuties: Array<Feedable> = arrayOf(dog, cat, fish, bird)
  val tankingDuties: Array<Tankable> = arrayOf(fish)
  val cagingDuties: Array<Cageable> = arrayOf(bird)
  val cleaningDuties: Array<Cleanable> = arrayOf(cat, fish, bird)

// Kotlin's type system prevents you from adding something that
// can't be walked to a homogeneous list of `Walkable`!
// val invalidWalkingDuties: Array<Walkable> = arrayOf(dog, fish)

//: 3. Write loops that will perform the proper tasks (such as feed, cage, walk) on each element of each array.

  for (walkable in walkingDuties) {
    walkable.walk()
  }

  for (feedable in feedingDuties) {
    feedable.feed()
  }

  for (tankable in tankingDuties) {
    tankable.tank()
  }

  for (cageable in cagingDuties) {
    cageable.cage()
  }

  for (cleanable in cleaningDuties) {
    cleanable.clean()
  }
}
