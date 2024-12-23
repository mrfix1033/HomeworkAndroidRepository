package module11

import kotlinx.coroutines.delay

fun input(text: String) = run {
    println(text)
    readln()
}

fun inputInt(text: String) = run {
    var ret: String
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

class Component(val name: String) {
    override fun toString() = name
}

private val milkComponent = Component("молоко")

sealed class Coffee(
    val sugar: Int,
    val volume: Float,
    val components: Map<Component, Any> = emptyMap()
) {
    abstract val name: String

    class Americano(sugar: Int, volume: Float) : Coffee(sugar, volume) {
        companion object {
            const val name = "Американо"
        }

        override val name: String
            get() = Americano.name
    }

    class Cappuccino(sugar: Int, volume: Float, milkVolume: Float) :
        Coffee(sugar, volume, mapOf(Pair(milkComponent, milkVolume))) {
        companion object {
            const val name = "Капучино"
        }

        override val name: String
            get() = Cappuccino.name
    }

    class Latte(sugar: Int, volume: Float) : Coffee(sugar, volume) {
        companion object {
            const val name = "Латте"
        }

        override val name: String
            get() = Latte.name
    }
}

suspend fun main() {

    suspend fun SelectMenu(coffee: Coffee) {
        for (i in 0..100 step 10) {
            print("$i% ")
            delay(100L)  // todo 500L
        }
        println("\nВаш кофе готов: ${coffee.name}, сахар: ${coffee.sugar}, объем: ${coffee.volume}".let {
            if (coffee.components.isEmpty()) it else "$it, ${
                coffee.components.map { entry -> "${entry.key}: ${entry.value}" }.joinToString()
            }"
        })
    }

    suspend fun SelectedMenu() {
        val coffeeName =
            input("Выберите кофе (${Coffee.Latte.name}, ${Coffee.Americano.name}, ${Coffee.Cappuccino.name}): ")
        val sugar = inputInt("Количество сахара: ")
        val volume = inputFloat("Объем кофе: ")
        var coffee: Coffee? = null
        while (coffee == null)
            when (coffeeName) {
                Coffee.Americano.name -> {
                    coffee = Coffee.Americano(sugar, volume)
                }

                Coffee.Cappuccino.name -> {
                    coffee = Coffee.Cappuccino(sugar, volume, inputFloat("Количество молока: "))
                }

                Coffee.Latte.name -> {
                    coffee = Coffee.Latte(sugar, volume)
                }
            }
        SelectMenu(coffee)
    }

    while (true)
        SelectedMenu()
}