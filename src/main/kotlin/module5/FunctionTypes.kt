package module5

fun main() {
    fun factorial(n: Int): Int = if (n < 2) 1 else n * factorial(n - 1)
    val numForFactorial = 10
    println("Факториал $numForFactorial=${factorial(numForFactorial)}")

    fun eGetter(n: Int): Long = if (n < 2) 10 else eGetter(n - 1) * 10
    val e = 9
    println("10e$e=${eGetter(e)}")

    fun arrayOddIndexesIncrementer(array: Array<Int>): Array<Int> {
        for (index in array.indices)
            if (index.and(1) == 1) continue
            else array[index]++
        return array
    }

    val array = arrayOf(1, 2, 3, 4, 5, 6, 7)
    arrayOddIndexesIncrementer(array)
    println("Новый массив: ${array.contentToString()}")
}