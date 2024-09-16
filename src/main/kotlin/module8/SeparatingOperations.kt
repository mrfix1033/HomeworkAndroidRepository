package module8

fun main() {
    val numbers = (1..20).toList()
    val numberOfEvenNumbers = numbers.count { it and 1 == 0 }
    println("Кол-во четных чисел в диапазоне от 1 по 20: $numberOfEvenNumbers")
    println()

    val sumOfNumbersUntil7Index = numbers.take(7).sum()
    println(sumOfNumbersUntil7Index)
    println()

    val numberStrings = listOf("one", "two", "three")
    val flattenNumberStrings = numberStrings.map { it.toList() }.flatten()
    println(flattenNumberStrings)
    println()

    val stringWithMaxLength = numberStrings.maxWith(compareBy { it.length })
    println("Максимальная по длине строка: $stringWithMaxLength")
    println()

    class Product(val name: String, val count: Int)

    val products = listOf(
        Product("Яблоко", 99999),
        Product("Банана", 8888),
        Product("Груши", 777)
    )
    val totalCountProducts = products.fold(0) { acc, product -> acc + product.count }
    println("Всего продуктов на складе: $totalCountProducts")
}