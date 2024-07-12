package inheritance

open class Smartphone {
    fun click(x: Int, y: Int) {
        println("Клик в точку с x=$x y=$y")
    }

    fun turnDownScreen() {
        println("Экран выключен")
    }

    fun turnUpScreen() {
        println("Экран включен")
    }
}

// создать древовидное наследование? я не очень понял, предположим, что так XD

open class IPhone : Smartphone() {
    fun enableCamera() {
        println("Открываю приложение \"Камера\"")
        println("Открыто")
    }

    fun closeCamera() {
        println("Закрыто")  // (да, даже логирование немного не в себе от скорости работы)
        println("Закрываю приложение \"Камера\"")
    }
}

open class Sony : IPhone() {  // это ещё только марка... (поэтому он открытый)
    fun openSonyPicturesEntertainmentApplication() {
        println("Sony Pictures Entertainment presents...")
    }
}

open class Nokia : IPhone() {
    open fun fallingDown() {
        println("Хозяивн урпониыл месня ивиот яенеработыбю")
    }
}

// но только не...
class Nokia3310 : Nokia() {
    override fun fallingDown() {
        println("Хозяин уронил меня и вот я отскочил в него •ᴗ•")
    }
}

fun main() {
    // рекламная интеграция, остальные не проплатили
    val nokia: Nokia = Nokia3310()
    nokia.fallingDown()
}
