package module5

fun main() {
    val happyNewYearGreetings = fun(whom: String, year: Int) = println("Поздравляю тебя, $whom, с Новым $year годом!!!")
    happyNewYearGreetings("Арсений", 2023)

    val isEven = fun(number: Int) = number.and(1) == 0
    val array = arrayOf(5, 4, 2, 8)
    println("Числа являются чётными соответсвенно: ${checkArrayElement(array, isEven).contentToString()}")

    val concat = fun(s1: String, s2: String) = s1 + s2
    println(concat(concat(concat(concat("Первая", " "), "плюс"), " "), "вторая"))
}

fun checkArrayElement(array: Array<Int>, func: (Int) -> Boolean) = array.map(func).toTypedArray()