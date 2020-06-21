import kotlin.system.exitProcess

val letters = listOf(
    "a", "b", "c", "d", "e",
    "f", "g", "h", "i", "j",
    "k", "l", "m", "n", "o",
    "p", "q", "r", "s", "t",
    "u", "v", "w", "x", "y", "z"
)

fun rotate(string: String, byCharacters: Int): String {

  val rotatedLetters= string.map { char ->
    val isUppercase = char.isUpperCase()
    var stringToFind = char.toString()
    if (isUppercase) {
      stringToFind = char.toLowerCase().toString()
    }

    val index = letters.indexOf(stringToFind)
    if (index == -1) {
      return@map char.toString()
    }

    val rotatedIndex = (index + byCharacters) % letters.size
    val letter = letters[rotatedIndex]
    if (isUppercase) {
      letter.toUpperCase()
    } else {
      letter
    }
  }

  return rotatedLetters.joinToString("")
}

val starting = "aZ"
val rotation = 3
val expected = "dC"

val actual = rotate(starting, rotation)

if (actual == expected) {
  println("SUCCESS")
} else {
  println("FAIL! got $actual")
}


fun valueFromArgsForPrefix(prefix: String): String? {
  val arg = args.firstOrNull { it.startsWith(prefix) }

  if (arg == null) return null

  val pieces = arg.split("=")
  return if (pieces.size == 2) {
    pieces[1]
  } else {
    null
  }
}

val stringToRotatePrefix = "rotate="
val numberToRotatePrefix = "places="

val stringToRotate = valueFromArgsForPrefix(stringToRotatePrefix)
if (stringToRotate == null) {
  println("No string to rotate provided")
  exitProcess(0)
} else {
  val numberToRotate = valueFromArgsForPrefix(numberToRotatePrefix)?.toInt()
  if (numberToRotate == null) {
    println("No number to rotate provided")
    println("Result: $stringToRotate")
    exitProcess(0)
  } else {
    val rotated = rotate(stringToRotate, numberToRotate)
    println("$stringToRotate rotated $numberToRotate places is $rotated")

    val rerotated = rotate(rotated, numberToRotate)
    println("$rotated rotated $numberToRotate places is $rerotated")

    if (rotated == rerotated && numberToRotate != letters.size) {
      println("You cracked the encryption and decryption code!")
    } else {
      println("try again!")
    }
  }
}
