package module11

import java.io.File

fun main() {
    run {
        fun writeToFile(file: File, vararg data: String) = file.writeText(data.joinToString(separator = "\n"))
        fun readFromFile(file: File): List<String> = file.readLines()

        val file = File("test.txt")
        writeToFile(file, "123", "456")
        println(readFromFile(file))
    }
    run {
        val path = "C:/folder"
        val filename = "test.txt"
        val number = 7
        var file = File(path)
        if (!file.exists()) file.mkdirs()
        file = File(file, filename)
        for (i in 2..(number * 2) step 2)
            file.appendText(i.toString() + "\n")
    }
    run {
        val file = File("test.txt")
        file.readLines().let { lines ->
            listOf(0, 1, -2, -1).forEach { println(lines[(lines.size + it) % lines.size]) }
        }
    }
}