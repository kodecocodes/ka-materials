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

fun <T> List<T>.toBulletedList(): String {
  val separator = "\n - "
  return this.map { "$it" }.joinToString(separator, prefix = separator, postfix = "\n")
}

//fun List<Any>.toBulletedList(): String {
//}


interface Checkable {
  fun checkIsOK(): Boolean
}

class Mover<T: Checkable>(
    thingsToMove: List<T>,
    val truckHeightInInches: Int = (12 * 12)
) {

  private var thingsLeftInOldPlace = mutableListOf<T>()
  private var thingsInTruck = mutableListOf<Any>()
  private var thingsInNewPlace = mutableListOf<T>()

  private var thingsWhichFailedCheck = mutableListOf<T>()

  init {
    thingsLeftInOldPlace.addAll(thingsToMove)
  }

  fun moveEverythingToTruck(startingContainer: Container<T>?) {
    var currentContainer = startingContainer
    while (thingsLeftInOldPlace.count() > 0) {
      val item = thingsLeftInOldPlace.removeAt(0)

      if (item.checkIsOK()) {
        if (currentContainer != null) {
          if (!currentContainer.canAddAnotherItem()) {
            moveContainerToTruck(currentContainer)
            currentContainer = currentContainer.getAnother()
          }

          currentContainer.addItem(item)
          println("Packed your $item!")
        } else {
          thingsInTruck.add(item)
          println("Moved your $item to the truck!")
        }
      } else {
        thingsWhichFailedCheck.add(item)
        println("Could not move your $item to the truck :[")
      }
    }

    currentContainer?.let { moveContainerToTruck(it)}
  }

  private fun moveContainerToTruck(container: Container<T>) {
    thingsInTruck.add(container)
    println("Moved a container with your ${container.contents().toBulletedList()} to the truck!")
  }

  fun moveEverythingIntoNewPlace() {
//    val breakableThings = thingsInTruck.filterIsInstance<BreakableThing>()
//    break
//    val items = thingsInTruck.filterIsInstance<T>()

    val containers = thingsInTruck.filterIsInstance<Container<T>>()
    for (container in containers) {
      thingsInTruck.remove(container)
      while (container.canRemoveAnotherItem()) {
        val itemInContainer = container.removeItem()
        println("Unpacked your $itemInContainer!")
        tryToMoveItemIntoNewPlace(itemInContainer)
      }
    }

    while (thingsInTruck.count() > 0) {
      @Suppress("UNCHECKED_CAST")
      val item = thingsInTruck.removeAt(0) as? T

      if (item != null) {
        tryToMoveItemIntoNewPlace(item)
      } else {
        println("Something in the truck was not of the expected generic type: $item")
      }
    }
  }

  private fun tryToMoveItemIntoNewPlace(item: T) {
    if (item.checkIsOK()) {
      thingsInNewPlace.add(item)
      println("Moved your $item into your new place!")
    } else {
      thingsWhichFailedCheck.add(item)
      println("Could not move your $item into your new place :[")
    }
  }

  fun finishMove() {
    println("OK, we finished! We were able to move your:${thingsInNewPlace.toBulletedList()}")
    if (thingsWhichFailedCheck.isNotEmpty()) {
      println("But we need to talk about your:${thingsWhichFailedCheck.toBulletedList()}")
    }
  }
}

class CheapThing(
    val name: String
): Checkable {

  override fun toString(): String {
    return name
  }

  override fun checkIsOK(): Boolean = true
}

class BreakableThing(
    val name: String,
    var isBroken: Boolean = false
): Checkable {

  fun smash() {
    isBroken = true
  }

  override fun toString(): String {
    return name
  }

  override fun checkIsOK(): Boolean {
    return !isBroken
  }
}

interface Container<T> {
  fun canAddAnotherItem(): Boolean
  fun addItem(item: T)

  fun canRemoveAnotherItem(): Boolean
  fun removeItem(): T

  fun getAnother(): Container<T>

  fun contents(): List<T>
}

class CardboardBox: Container<BreakableThing> {
  private var items = mutableListOf<BreakableThing>()

  override fun contents(): List<BreakableThing> {
    return items.toList()
  }

  override fun canAddAnotherItem(): Boolean {
    return items.count() < 2
  }

  override fun addItem(item: BreakableThing) {
    items.add(item)
  }

  override fun canRemoveAnotherItem(): Boolean {
    return items.count() > 0
  }

  override fun removeItem(): BreakableThing {
    val lastItem = items.last()
    items.remove(lastItem)
    return lastItem
  }

  override fun getAnother(): Container<BreakableThing> {
    return CardboardBox()
  }
}

fun main() {
  val names = listOf("Bob", "Carol", "Ted", "Alice")
  println("Names: ${names.toBulletedList()}")
  val firstName = names.first()
  println(firstName)

//  val firstInt: Int = names.first()

  val things = mutableListOf<Any>(1, 2)
  things.add("Steve")
  println("Things: ${things.toBulletedList()}")

  val map = mapOf(
      Pair("one", 1),
      Pair("two", "II"),
      Pair("three", 3.0f)
  )

//  val one = map.get(1)
//  val one = map[1]

  val valuesForKeysWithE = map.keys
      .filter { it.contains("e") }
      .map { "Value for $it: ${map[it]}" }

  println("Values for keys with E: ${valuesForKeysWithE.toBulletedList()}")


  val cheapThings = listOf(
      CheapThing("Cinder Block table"),
      CheapThing("Box of old books"),
      CheapThing("Ugly old couch")
  )
  val cheapMover = Mover(cheapThings)

  cheapMover.moveEverythingToTruck(null)
  cheapMover.moveEverythingIntoNewPlace()
  cheapMover.finishMove()

  val television = BreakableThing("Flat-Screen Television")
  val breakableThings = listOf(
      television,
      BreakableThing("Mirror"),
      BreakableThing("Guitar")
  )
  val expensiveMover = Mover(breakableThings)

  expensiveMover.moveEverythingToTruck(CardboardBox())

  television.smash()

  expensiveMover.moveEverythingIntoNewPlace()
  expensiveMover.finishMove()

  val ints = listOf(1, 2, 3)
  val numbers: List<Number> = ints
//  val moreInts: List<Int> = numbers

  val mutableInts = mutableListOf(1, 2, 3)
//  val mutableNumbers: MutableList<Number> = mutableInts

  fun compare(comparator: Comparable<Number>) {
    val int: Int = 1
    comparator.compareTo(int)
    val float: Float = 1.0f
    comparator.compareTo(float)

    val intComparable: Comparable<Int> = comparator
    intComparable.compareTo(int)
//    intComparable.compareTo(float)
  }
}
