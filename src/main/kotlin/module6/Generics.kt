package module6

fun main() {
    print(1, "Строка", true, listOf(1, 2, 3), sep = "\n")
    println()

    val personArseniy = Person("Арсений", "+73456789012")
    val personAlexander = Person("Александр", 83456789012)
    print(personArseniy, personAlexander, sep = "\n")
    println()

    wrapAndPrint(10, '{')
    wrapAndPrint("Hello", '[')
    wrapAndPrint(listOf(10, 16, 3), '"')
    wrapAndPrint('f', '(')
}

fun <T> print(vararg args: T, sep: String = " ", end: String = "\n") {
    args.forEachIndexed { ind, elem ->
        kotlin.io.print(elem.toString())
        if (ind != args.lastIndex) kotlin.io.print(sep)
    }
    kotlin.io.print(end)
}

data class Person<T>(val name: String, val phoneNumber: T)

fun <T> wrapAndPrint(out: T, wrapChar: Char) {
    val endWrapChar = when (wrapChar) {
        '{' -> '}'
        '[' -> ']'
        '(' -> ')'
        else -> wrapChar
    }
    print(wrapChar, out, endWrapChar, sep = "")
}
