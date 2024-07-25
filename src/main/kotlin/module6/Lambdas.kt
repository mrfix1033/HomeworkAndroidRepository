package module6

fun main() {
    fun repeat(count: Int, func: () -> Unit) = run { for (i in 1..count) func() }
    repeat(3) { println("Привет!") }
    println()

    val arithmeticMeanLambda = { array: Array<Int> -> array.sum() / array.size }
    val arrayNumbers = arrayOf(-1, -2, 2, 1)
    println("Среднее арифметическое массива ${arrayNumbers.contentToString()} = ${arithmeticMeanLambda(arrayNumbers)}")
    println()

    println("Исходный массив: ${arrayNumbers.contentToString()}\n" +
            "Только с положительными числами: ${arrayNumbers.filter { n -> n > 0 }}"
    )
    println()

    val difficultLambda = { array: Array<Int> -> array.map { elem -> if (elem.and(1) == 0) elem / 2 else elem * 3 } }
    println("Массив, обработанный \"сложной\" лямбдой: ${difficultLambda(arrayNumbers)}")
}