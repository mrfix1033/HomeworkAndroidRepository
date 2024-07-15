open class BirdForOverriding(val type: String, val wingspan: Double, val canFly: Boolean) {
    open fun eat() {
        println("кушаем")
    }

    open fun walk() {
        println("топ-топ")
    }
}

class EagleOverrode(type: String, wingspan: Double, canFly: Boolean) : BirdForOverriding(type, wingspan, canFly) {
    override fun eat() {
        println("(схватили жертву)")
    }

    override fun walk() {
        println("грозный топ-топ")
    }
}

class Pigeon(type: String, wingspan: Double, canFly: Boolean) : BirdForOverriding(type, wingspan, canFly) {
    override fun eat() {
        println("тык-тык")
    }
}

fun main() {
    val eagle: BirdForOverriding = EagleOverrode("грозный", 2.0, true)
    eagle.eat()
    val pigeon: BirdForOverriding = Pigeon("темно-серый", 0.5, true)
    pigeon.walk()
    println("-".repeat(30))

    val arrayStrings = arrayOf("строка", "самая длинная", "ответ 13")
    val longestString = arrayStrings.maxWith{s1, s2 -> s1.length - s2.length}
    println("В массиве ${arrayStrings.contentToString()} самая длинная строка - $longestString, её длина ${longestString.length}")

    val string = "ПриВет, кАк деЛа"
//    val upperChars = string.filter { c -> c.isUpperCase() }
    var upperChars = arrayOf<Char>()
    for (char in string) if (char.isUpperCase()) upperChars += char
    println("В строке \"$string\" символы в верхнем регистре - ${upperChars.joinToString()}; их количество - ${upperChars.size}")
}