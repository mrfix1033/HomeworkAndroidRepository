import kotlin.math.pow

fun main() {
    println("1) ${pow(4.0, 2.5)}")
    println("2) ${multiplicationFromAToB(4, 6)}")
    println("3) ${getGCD(20, 25)}")
}

fun pow(num: Double, power: Double): Double {
    return num.pow(power)
}

fun multiplicationFromAToB(a: Int, b: Int): Int {
    var multiplication = 1
    for (i in a..b) multiplication *= i
    return multiplication
}

fun getGCD(a: Int, b: Int): Int {
    val remains = a % b
    if (remains == 0) return b
    return getGCD(b, remains)
}