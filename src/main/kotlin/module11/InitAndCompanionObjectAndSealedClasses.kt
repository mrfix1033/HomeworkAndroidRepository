package module11

import kotlinx.coroutines.delay

fun input(text: String) = run {
    println(text)
    readln()
}

fun inputInt(text: String) = run {
    var ret = ""
    do {
        ret = input(text)
    } while (ret.toIntOrNull() == null)
    ret.toInt()
}

fun inputFloat(text: String) = run {
    var ret: String
    do {
        ret = input(text)
    } while (ret.toFloatOrNull() == null)
    ret.toFloat()
}

class Component(val name: String)

private val milkComponent = Component("Молоко")

sealed class Coffee(
    val sugar: Int,
    val volume: Float,
    val additionalComponents: List<Component> = emptyList()
) {
    class Americano(sugar: Int, volume: Float) : Coffee(sugar, volume)
    class Cappuccino(sugar: Int, volume: Float, milkVolume: Float) :
        Coffee( sugar, volume, listOf(milkComponent)) {

        }

    class Latte(sugar: Int, volume: Float) : Coffee( sugar, volume)
    fun handleAdditionalComponents() {
        return inputFloat("Количество молока: ")
    }
}

suspend fun main() {

    val coffeeAssortment: Map<String, Coffee> = mapOf(
        Pair("Американо", Coffee.Americano)
    )
//    ,
//    Pair("Капучино", Coffee.Cappuccino),
//    Pair("Латте", Coffee.Latte)

    suspend fun SelectMenu(coffee: Coffee) {
        for (i in 0..100 step 10) {
            print("$i% ")
            delay(100L)  // todo 500L
        }
        println("Ваш кофе готов: ${coffee.name}, сахар: ${coffee.sugar}, объем: ${coffee.volume}")
    }

    suspend fun SelectedMenu() {
        val coffeeName = input("Выберите кофе (${coffeeAssortment.joinToString { it.name }}): ")
        val sugar = inputInt("Количество сахара: ")
        val volume = inputFloat("Объем кофе: ")
        coffeeAssortment[coffeeName](sugar, volume)
        SelectMenu()
    }

    while (true)
        SelectedMenu()
}