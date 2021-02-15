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

    int expirationMonth = 6;
    int validExpirationYear = 2030;
    int invalidExpirationYear = 1989;
    String cvv = "123";

    String goodCardNumber = "1234567890123456";

    // A card with a good expiration date and no CVV
    CreditCard goodExpNoCVV = new CreditCard(goodCardNumber, expirationMonth, validExpirationYear);
    UserExtensions.attemptToAddCard(user, goodExpNoCVV);

    // A card with a good expiration date and a CVV
    CreditCard goodExpWithCVV = new CreditCard("0987654321098765", expirationMonth, validExpirationYear, cvv);
    UserExtensions.attemptToAddCard(user, goodExpWithCVV);

    // A card with a bad expiration date and a CVV
    CreditCard badExpWithCVV = new CreditCard("9876543210987654", expirationMonth, invalidExpirationYear, cvv);
    UserExtensions.attemptToAddCard(user, badExpWithCVV);

    // A card with a bad expiration date and no CVV
    CreditCard badExpNoCVV = new CreditCard("8765432109876543", expirationMonth, invalidExpirationYear);
    UserExtensions.attemptToAddCard(user, badExpNoCVV);

    // A card with identical information to the good expiration/cvv card.
    CreditCard duplicate = new CreditCard(goodCardNumber, expirationMonth, validExpirationYear, cvv);
    UserExtensions.attemptToAddCard(user, duplicate);

    System.out.println("The user has " + user.getCreditCards().size()  + " credit cards");
  }
}
