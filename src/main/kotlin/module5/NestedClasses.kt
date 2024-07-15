package module5

const val additionPartPrefix = "  "

class HumanNestedClasses(weight: Double) : WeightPrintable(weight) {
    val head: Head = Head(weight * 0.05)
    val body: Body = Body(weight * 0.47)
    val legs: Legs = Legs(weight * 0.48, 95.0)

    class Head(weight: Double) : HumanPart("голова", weight) {
        override fun print(prefix: String) {
            println(prefix + HumanPartsStringBuilder(this))
        }

    }

    class Body(weight: Double) : HumanPart("туловище", weight) {
        override fun print(prefix: String) {
            println(prefix + HumanPartsStringBuilder(this))
        }

    }

    class Legs private constructor(weight: Double) : HumanPart("ноги", weight) {
        class Leg(weight: Double, val legHeight: Double) : HumanPart("нога", weight) {
            override fun print(prefix: String) {
                println(
                    prefix + HumanPartsStringBuilder(
                        this,
                        "\n${prefix + additionPartPrefix}длина ноги: $legHeight"
                    )
                )
            }
        }

        private lateinit var legs: Array<Leg>

        constructor(weight: Double, legsHeight: Double) : this(weight) {
            legs = arrayOf(Leg(weight / 2, legsHeight), Leg(weight / 2, legsHeight))
        }

        override fun print(prefix: String) {
            println(prefix + HumanPartsStringBuilder(this))
            for (leg in legs)
                leg.print(prefix + additionPartPrefix)
        }
    }

    override fun print(prefix: String) {
        println(prefix + "Человек, вес: $weight")
        head.print(prefix + additionPartPrefix)
        body.print(prefix + additionPartPrefix)
        legs.print(prefix + additionPartPrefix)
    }
}

abstract class HumanPart(val partName: String, weight: Double) : WeightPrintable(weight)

abstract class WeightPrintable(val weight: Double) : PrintableNestedClasses

interface PrintableNestedClasses {
    fun print(prefix: String)
}

class HumanPartsStringBuilder(
    private val partName: String,
    private val weight: Double,
    private val additional: String
) {
    constructor(humanPart: HumanPart) : this(
        humanPart.partName,
        humanPart.weight
    )

    constructor(partName: String, weight: Double) : this(
        partName,
        weight,
        ""
    )

    constructor(humanPart: HumanPart, additional: String) : this(
        humanPart.partName,
        humanPart.weight,
        additional
    )

    override fun toString(): String {
        return "Часть тела: $partName, вес: $weight" + if (additional.isNotEmpty()) ", дополнительно: $additional" else ""
    }
}

fun main() {
    val human = HumanNestedClasses(70.0)
    val body = HumanNestedClasses.Body(30.0)  // тело отдельно от туловища быть не может, ну ладно
    human.print("1.1) ")
    body.print("1.2) ")
    println("-".repeat(30))

    val array = arrayOf("Иванов", "Петров", "Сидоров", "Процветов", "Протасов")  // делаем кривую табуляцию
    println("Массив: ${array.contentToString()}")
    while (true) {
        print("Введите начало строки или оставьте строку пустой, чтобы выйти: ")
        val input = readln()
        if (input.isEmpty()) break
        var tabCompleteArray = arrayOf<String>()
        for (string in array) if (string.startsWith(input)) tabCompleteArray += string
        println("Результат: ${tabCompleteArray.contentToString()}")
    }
    println("-".repeat(30))

    val numbersArray = arrayOf(5, 4, 3, 0, 5, 6, 7, 0, 2)
    var firstZeroIndex = -1
    var numberOfElementsBetweenZeros = 0
    for ((i, e) in numbersArray.withIndex()) {
        if (e != 0) continue
        if (firstZeroIndex > 0) {
            numberOfElementsBetweenZeros = i - firstZeroIndex - 1
            break
        }
        firstZeroIndex = i
    }
    println("Массив: ${numbersArray.contentToString()}")
    println("Количество чисел между нулями: $numberOfElementsBetweenZeros")
}