import kotlin.math.roundToInt

class Helicopter {
    var name: String = ""
    var weight: Double = 0.0
    var speed: Double = 0.0
    var height = 0

    fun setValues(name: String, weight: Double, speed: Double, height: Int) {
        this.name = name
        this.weight = weight
        this.speed = speed
        this.height = height
    }

    fun printInfo() {
        println("Спроектировали вертолет с названием $name скоростью полета $speed весом $weight высотой полета $height")
    }
}

class Pet {
    var weight = 0.0
    var name = ""
    var type = ""


    fun setValues(type: String, name: String, weight: Double) {
        this.weight = weight
        this.name = name
        this.type = type
    }

    fun printInfo() {
        println("Домашнее животное: $type \nКличка: $name \nВес: $weight")
    }
}

//class Main {
    fun main(args: Array<String>) {
        var helicopter = Helicopter()
        helicopter.setValues("Ка-226Т", 2895.0, 190.0, 5000)
        helicopter.printInfo()
        println()

        var pet = Pet()
        pet.setValues("Мартышка", "Андрюша", 17.6)
        pet.printInfo()
        println()

        var num = 5.87  //-4.7
        var intNum = num.toInt()  // truncate
        println("3) Integer (truncate): $intNum")
        intNum = num.roundToInt()  // round
        println("3) Integer (round): $intNum")
        intNum = Math.ceil(num).toInt()  // round-up
        println("3) Integer (round-up): $intNum")
        intNum = Math.floor(num).toInt()  // round-down
        println("3) Integer (round-down): $intNum")
    }
//}