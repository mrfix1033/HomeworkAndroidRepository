fun main() {
    var n = 1
    var number = 0.0
    for (i in 1..n) number += 1 / i

    println("1) $number")

    var a = 3
    var b = 5
    var sum = 0
    for (i in a..b) sum += i * i
    println("2) The sum of the squares of numbers from $a to $b (inclusive) is equal to $sum")

    print("3) ")
    for (i in a..b) repeat(i - a + 1) { print("$i ") }
    println()

    n = 19
    var isSimple = true
    for (i in 2..Math.sqrt(n.toDouble()).toInt())
        if (n % i == 0) {
            isSimple = false
            break
        }
    println("4) The number $n is${if (isSimple) "" else "n't"} simple")

    var trying = 3
    do {
        println("Что это такое: синий, большой, с усами и полностью набит зайцами?")
        when (readln().lowercase()) {
            "троллейбус" -> {
                println("Правильно!")
                break
            }
            "сдаюсь" -> {
                println("Правильный ответ: троллейбус")
                break
            }
            else -> {
                trying--
                println(if (trying > 0) "Неверно, подумай еще" else "Попытки кончились")
            }
        }
    } while (trying > 0)
}