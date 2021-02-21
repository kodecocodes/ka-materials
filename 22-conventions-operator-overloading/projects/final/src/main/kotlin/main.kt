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
  // your company
  val company = Company("MyOwnCompany")

  // departments
  val developmentDepartment = Department("Development")
  val qaDepartment = Department("Quality Assurance")
  val hrDepartment = Department("Human Resources")

  // employees
  var Julia = Employee(company, "Julia", 100_000)
  var John = Employee(company, "John", 86_000)
  var Peter = Employee(company, "Peter", 100_000)

  var Sandra = Employee(company, "Sandra", 75_000)
  var Thomas = Employee(company, "Thomas", 73_000)
  var Alice = Employee(company, "Alice", 70_000)

  var Bernadette = Employee(company, "Bernadette", 66_000)
  var Mark = Employee(company, "Mark", 66_000)

  company += developmentDepartment
  company += qaDepartment
  company += hrDepartment

  developmentDepartment += Julia
  developmentDepartment += John
  developmentDepartment += Peter

  qaDepartment += Sandra
  qaDepartment += Thomas
  qaDepartment += Alice

  hrDepartment += Bernadette
  hrDepartment += Mark

  qaDepartment -= Thomas

  if (Thomas !in qaDepartment) {
    println("${Thomas.name} no longer works here")
  }

  ++Julia
  --Peter
  Mark += 2500
  Alice -= 2000

  println((Alice..Mark).joinToString { it.name })

  qaDepartment[0]?.plusAssign(1000)
  qaDepartment[1] = Thomas

  developmentDepartment.forEach {
    // do something
  }
}