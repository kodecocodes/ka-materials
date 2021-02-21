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

fun File.contents(): List<File> {
  return this.listFiles().toList()
}

fun File.folders(): List<File> {
  return this.contents().filter { it.isDirectory }
}

fun File.files(): List<File> {
  return this.contents().filter { it.isFile }
}

fun File.fileNames(): List<String> {
  return this.files().map { it.name }
}

fun File.folderNames(): List<String> {
  return this.folders().map { it.name }
}

fun File.printFolderInfo() {
  println("Contents of `${this.name}`:")
  if (this.folders().isNotEmpty()) {
    println("- Folders:\n   ${this.folderNames().joinToString("\n   ")}")
  }

  if (this.files().isNotEmpty()) {
    println("- Files:\n   ${this.fileNames().joinToString("\n   ")}")
  }

  println("Parent: ${this.parentFile?.name}")
}

val current = currentFolder()
current.printFolderInfo()

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

if (folderValue != null) {
  val folder = File(folderValue).absoluteFile
  folder.printFolderInfo()
} else {
  println("No path provided, printing working directory info")
  currentFolder().printFolderInfo()
}
