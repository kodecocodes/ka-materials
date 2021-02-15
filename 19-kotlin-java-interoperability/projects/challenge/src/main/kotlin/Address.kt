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

enum class AddressType {
  Billing,
  Shipping,
  Gift
}

data class Address @JvmOverloads constructor (
    @JvmField val streetLine1: String,
    @JvmField val streetLine2: String?,
    @JvmField val city: String,
    @JvmField val stateOrProvince: String,
    @JvmField val postalCode: String,
    @JvmField var addressType: AddressType,
    @JvmField val country: String = "United States"
) {

  fun forPostalLabel(): String {
    var printedAddress = streetLine1
    streetLine2?.let { printedAddress += "\n$it" }
    printedAddress += "\n$city, $stateOrProvince $postalCode"
    printedAddress += "\n${country.toUpperCase()}"
    return printedAddress
  }

  override fun toString(): String {
    return forPostalLabel()
  }

  object JSONKeys {
    const val streetLine1 = "street_1"
    const val streetLine2 = "street_2"
    const val city = "city"
    const val stateOrProvince = "state"
    const val postalCode = "zip"
    const val addressType = "type"
    const val country = "country"
  }

  companion object {
    const val sampleFirstLine = "123 Fake Street"

    @JvmStatic
    fun canadianSample(type: AddressType): Address {
      return Address(sampleFirstLine,
          "4th floor",
          "Vancouver",
          "BC",
          "A3G 4B2",
          type,
          "Canada")
    }
  }
}
