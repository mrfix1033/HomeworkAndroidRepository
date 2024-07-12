class Box(val width: Int, val height: Int, val depth: Int) {
    fun getVolume() = width * height * depth
}

class CarConstructors(val mass: Int, val speed: Int) {
    private var isMoving: Boolean = false

    fun startMoving() {
        isMoving = true
        println("Начинаем движение...")
    }

    fun stopMoving() {
        isMoving = false
        println("Останавливаемся...")
    }

    fun isMoving() = isMoving
}

fun main() {
    val box = Box(2, 3, 4)
    println("1) A box volume is ${box.getVolume()}")

    var N = 10
    var array = Array(N) { 0 }
    for (i in array.indices) array[i] = i shl 1
    println("2) Array is: ${array.contentToString()}")
    println("2) Minimum is: ${array.min()}")
    println("2) Maximum is: ${array.max()}")

    array = arrayOf(3, 67, 1, 55, 65, 89, 23)
    print("3) ${array.contentToString()}\n3) or\n3) ")
    for (element in array) print("$element ")
    println()

    val a = 34
    println(
        "4) ${
            if (a == 0) "Нулевое" else (if (a > 0) "Положительное" else "Отрицательное") + " " + (if (a.and(1) == 1) "не" else "") + "четное"
        } число"
    )

    println("5) Task №5")
    val car = CarConstructors(1800, 450)
    car.startMoving()
    println("Is the car moving: ${car.isMoving()}")
    car.stopMoving()
}