import java.io.File

println("Hello, scripting!")

if (args.isEmpty()) {
  println("[no args]")
} else {
  println("Args:\n ${args.joinToString("\n ")}")
}

fun currentFolder(): File {
  return File("").absoluteFile
}

fun File.contents(includingHidden: Boolean): List<File> {
  val fileList = this.listFiles().toList()
  return if (includingHidden) {
    fileList
  } else {
    fileList.filter { !it.isHidden }
  }
}

fun File.folders(includingHidden: Boolean): List<File> {
  return this.contents(includingHidden).filter { it.isDirectory }
}

fun File.files(includingHidden: Boolean): List<File> {
  return this.contents(includingHidden).filter { it.isFile }
}

fun File.fileNames(includingHidden: Boolean): List<String> {
  return this.files(includingHidden).map { it.name }
}

fun File.folderNames(includingHidden: Boolean): List<String> {
  return this.folders(includingHidden).map { it.name }
}

fun File.printFolderInfo(includingHidden: Boolean) {
  println("Contents of `${this.name}`:")
  if (this.folders(includingHidden).isNotEmpty()) {
    println("- Folders:\n   ${this.folderNames(includingHidden).joinToString("\n   ")}")
  }

  if (this.files(includingHidden).isNotEmpty()) {
    println("- Files:\n   ${this.fileNames(includingHidden).joinToString("\n   ")}")
  }

  println("Parent: ${this.parentFile?.name}")
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

val folderPrefix = "folder="
val folderValue = valueFromArgsForPrefix(folderPrefix)

val hiddenPrefix = "showHidden="
val hiddenStringValue = valueFromArgsForPrefix(hiddenPrefix)
val hiddenValue = hiddenStringValue?.toBoolean() ?: false

val current = currentFolder()
current.printFolderInfo(hiddenValue)

if (folderValue != null) {
  val folder = File(folderValue).absoluteFile
  folder.printFolderInfo(hiddenValue)
} else {
  println("No path provided, printing working directory info")
  currentFolder().printFolderInfo(hiddenValue)
}
