package inheritance

fun main() {
    val dog = Dog(30f, "Шурик")
    val cat = Cat(10f, "Маруся")
    dog.toEat()
    cat.toEat()
    dog.toScratchBehindEar()
    cat.toWashUp()
}

open class Animal(val weight: Float, val name: String) {
    open fun toEat() {
        println("Я кушаю. Ам-ням-ням.")
    }
}

class Dog(weight: Float, name: String) : Animal(weight, name) {
    override fun toEat() {
        println("Я собака, я кушаю. Ам-ням-ням")
    }

    fun toScratchBehindEar() {
        println("Я собака и я чешу за ушком...")
    }
}

class Cat(weight: Float, name: String) : Animal(weight, name) {
    override fun toEat() {
        println("Я кошка, я кушаю. Ам-ням-ням")
    }

    fun toWashUp() {
        println("Я кошка и я умываюсь... (хлип, хлип)")
    }
}