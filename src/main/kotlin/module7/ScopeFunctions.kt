package module7

fun main() {
    val string = "let-function"
    string.let { println("Строка - \"${it}\"; длина - ${it.length}") }

    data class City(var name: String, var population: Int?)
    val myCity = City("Москва", null)
    println(myCity.apply { population = 1000 })

    val array = arrayOf(9, 2, 4)
    with(array) {
        println("Массив: ${contentToString()}; Размер: $size; Сумма чисел: ${sum()}")
    }
}
