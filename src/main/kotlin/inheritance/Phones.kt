package inheritance

open class Smartphone(private val price: Int) {
    fun click(x: Int, y: Int) {
        println("Клик в точку с x=$x y=$y")
    }

    fun turnDownScreen() {
        println("Экран выключен")
    }

    fun turnUpScreen() {
        println("Экран включен")
    }

    fun call(number: Long) {
        println("Звоним по номеру $number")
    }

    fun getPrice() = price
}

// создать древовидное наследование? я не очень понял, предположим, что так XD

open class IPhone(price: Int) : Smartphone(price) {
    fun enableCamera() {
        println("Открываю приложение \"Камера\"")
        println("Открыто")
    }

    fun closeCamera() {
        println("Закрыто")  // (да, даже логирование немного не в себе от скорости работы)
        println("Закрываю приложение \"Камера\"")
    }
}

open class Sony(price: Int, private val displayType: String) : IPhone(price) {  // это ещё только марка... (поэтому он открытый)
    fun openSonyPicturesEntertainmentApplication() {
        println("Sony Pictures Entertainment presents...")
    }

    fun getDisplayType() = displayType
}

open class Nokia(price: Int) : IPhone(price) {
    open fun fallingDown() {
        println("Хозяивн урпониыл месня ивиот яенеработыбю")
    }
}

// но только не...
class Nokia3310(price: Int) : Nokia(price) {
    override fun fallingDown() {
        println("Хозяин уронил меня и я отскочил в него •ᴗ•")
    }
}

fun main() {
    // рекламная интеграция, остальные не проплатили
    val nokia: Nokia = Nokia3310(299)
    nokia.fallingDown()
}
