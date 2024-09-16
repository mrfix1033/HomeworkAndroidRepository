package module8

fun main() {
    val strings = listOf("one", "two", "three")
    val reversedStringsCollection = strings.map(String::reversed)
    println("Список с перевернутыми строками: $reversedStringsCollection")
    println()

    val numbers = (1..5).toList()
    val squaredNumbersWhichLessOrEven3 = numbers.filter { it < 4 }.map { it * it }
    println("Список чисел в квадрате, которые меньше трех: $squaredNumbersWhichLessOrEven3")
    println()

    val enLocale = listOf("red", "blue", "white")
    val ruLocale = listOf("красный", "синий", "белый")

    val zipped = enLocale.zip(ruLocale) {enString, ruString -> "Значение $enString, перевод: $ruString"}
    println(zipped)
    println()

    val months = listOf("Jan", "Feb", "Mar", "Apr", "May")
    val totalLength = months.fold(0) {acc, s -> acc + s.length}
    println("Сумма длин строк: $totalLength")
    println()
}
