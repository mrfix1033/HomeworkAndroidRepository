package module8

fun main() {
    val list = listOf(5, 3, 6, 3, 8, 4, 8, 3, 4, 5, 6)
    println("Сумма элементов с 3-го по 9-ый равна ${list.subList(2, 9).sum()}")
    println()

    println("Соединенные элементы массива: ${list.fold(StringBuilder(), StringBuilder::append)}")
    println()

    data class Player(val name: String, val points: Int, val money: Int)

    val listPlayers = listOf(
        Player("mrfix1033", 100, 2440),
        Player("jorrito", 110, 2300),
        Player("noobmaster", 90, 2500)
    )
    var money = 0
    var points = 0
    listPlayers.forEach { points += it.points; money += it.money }
    println("Всего очков: $points; всего монет: $money")
    println()

    val fruits = listOf("Яблоко", "Абрикос", "Банан", "Виноград", "Вишня", "Кокос", "яблоко")
    println(fruits.filter { it.length and 1 == 0 }.groupBy { it.first().lowercaseChar() })
}