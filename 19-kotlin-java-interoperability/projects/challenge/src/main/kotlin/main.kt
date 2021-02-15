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
  val user = User()
  user.firstName = "Bob"
  user.lastName = "Barker"

  println("User info:\n$user")

  val billingAddress = Address("123 Fake Street",
      "4th floor",
      "Los Angeles",
      "CA",
      "90291",
      AddressType.Billing)

  println("Billing Address:\n$billingAddress\n")

  user.addOrUpdateAddress(billingAddress)

  val shippingAddress = Address("987 Unreal Drive",
      null,
      "Burbank",
      "CA",
      "91523",
      AddressType.Shipping)

  user.addOrUpdateAddress(shippingAddress)

  println("User info after adding addresses:\n$user")

  println("Shipping Label:")
  printLabelFor(user)

  val anotherUser = User()
//  anotherUser.addresses = null
  println("Another User has ${anotherUser.addresses.count()} addresses")
  println("Another User first name: ${anotherUser.firstName ?: "(not set)"}")

  println("Sample First Line: ${Address.sampleFirstLine}")
  println("Sample Canadian Address:\n${Address.canadianSample(AddressType.Billing)}")

  val isGood = CreditCard.isValidExpirationDate(6, 2030)
  println("Expiration date is ${if (isGood) "valid" else "invalid"}")
}
