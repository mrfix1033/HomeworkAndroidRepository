package module7

import kotlin.math.sqrt

fun main() {
    val integer = 2
    println("Квадрат числа $integer = ${integer.square()}")

    val string = "Строка"
    println("Самоконкатенация \"$string\" = ${string.concat(string)}")
    println("Последний индекс: ${string.getLastIndex()}")
    println("Квадратный корень из ${integer.square()}: ${integer.square().squareRoot()}")
}

fun Int.square() = this * this
fun String.concat(second: String) = this + second
fun String.getLastIndex() = this.lastIndex
fun Int.squareRoot() = sqrt(this.toDouble())
