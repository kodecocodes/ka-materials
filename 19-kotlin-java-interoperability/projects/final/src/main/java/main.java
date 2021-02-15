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

import java.util.HashMap;

class JavaApplication {
  public static void main(String[] args) {
    User user = new User();
    user.setFirstName("Testy");
    user.setLastName("McTesterson");

    Address address = new Address(
        "345 Nonexistent Avenue NW",
        null,
        "Washington",
        "DC",
        "20016",
        AddressType.Shipping
    );
//    address.setAddressType(AddressType.Billing);

    UserExtensions.addOrUpdateAddress(user, address);

    LabelPrinter.printLabelFor(user);

    Address.JSONKeys keys = Address.JSONKeys.INSTANCE;

    HashMap<String, Object> addressJSON = new HashMap<>();

    addressJSON.put(keys.streetLine1, address.streetLine1);
    addressJSON.put(keys.streetLine2, address.streetLine2);
    addressJSON.put(keys.city, address.city);
    addressJSON.put(keys.stateOrProvince, address.stateOrProvince);
    addressJSON.put(keys.postalCode, address.postalCode);
    addressJSON.put(keys.country, address.country);
    addressJSON.put(keys.addressType, address.addressType.name());

    System.out.println("Address JSON:\n" + addressJSON);

    System.out.println("Sample first line of address: " + Address.sampleFirstLine);

    Address canadian = Address.canadianSample(AddressType.Shipping);
    System.out.println(canadian);
  }
}
