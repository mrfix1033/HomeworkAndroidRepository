import kotlin.math.roundToInt

fun main() {
    println("1) Enter a number:")
    var numberForFactorial = readln().toInt()
    var factorial = 1
    var numberNow = 2
    while (numberNow <= numberForFactorial) {
        factorial *= numberNow
        numberNow++
    }
    println("1) The factorial of the number $numberForFactorial is $factorial")

    var rublesPerKilogram = 299.99
    var kilograms = 1
    while (kilograms <= 10) {
        println("2) ${(rublesPerKilogram * kilograms * 100).roundToInt() / 100.0} rubles per $kilograms kilogram(-s)")
        kilograms++
    }

    var a = 3
    var b = 5
    var count = b - a + 1
    while (a <= b) {
        println("3) Number $a")
        a++
    }
    println("3) The number of all numbers is equal to $count")

    var n = 123456
    while (n != 0) {
        println("4) Digit ${n % 10}")
        n /= 10
    }

    n = 2
    while (n < 19) {
        println("5) $n -> ${if ((n and 3) == 0) n shl 1 else n}")
        n += 2
    }

    var sum = 350.0
    var month = 1
    while (month++ <= 9) sum *= 1.07
    println("6) The total amount - ${(sum * 100).roundToInt() / 100.0}")
}
