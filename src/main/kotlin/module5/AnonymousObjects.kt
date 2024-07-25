package module5;

fun main() {
    val arrayStrings = arrayOf("строка", "самая длинная", "ответ 13")
    val longestString = arrayStrings.maxWith { s1, s2 -> s1.length - s2.length }
    println("В массиве ${arrayStrings.contentToString()} самая длинная строка - $longestString, её длина ${longestString.length}")

    val matrix = arrayOf(
        arrayOf(1, 2, 3, 4),
        arrayOf(2, 3, 4, 1),
        arrayOf(3, 4, 1, 2),
        arrayOf(4, 1, 2, 3)
    )

    fun getSumOfSideDiagonal(matrix: Array<Array<Int>>): Int {
        if (matrix.isEmpty() || matrix.size != matrix[0].size) return -1
        var sum = 0
        for (ind in matrix.indices)
            sum += matrix[ind][matrix.size - 1 - ind]
        return sum
    }

    println("Сумма элементов побочной диагонали матрицы = ${getSumOfSideDiagonal(matrix)}")

    val defaultPrinter = object : Printer("Samsung", "SCX-4200", 0.1) {
        override fun print(strings: Array<String>) {
            for (string in strings)
                println(string)
        }
    }

    val printerWithNumeration = object : Printer("Samsung", "SCX-4200N", 1.0) {
        override fun print(strings: Array<String>) {
            for ((i, string) in strings.withIndex())
                println("${i + 1}) $string")
        }
    }

    printerWithNumeration.print(arrayOf("1 строка", "2 строка"))
}

abstract class Printer(val manufacturer: String, val model: String, val toner: Double) {
    abstract fun print(strings: Array<String>)
}