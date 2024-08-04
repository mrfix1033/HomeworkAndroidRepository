package module6

fun main() {
    val numberString = "12.3"
    println("Целое число: ${numberString.split('.')[0].toInt()}")
    println("Число с плавающей точкой: ${numberString.toFloat()}")
    println("Число с плавающей точкой в 2-ой СС: ${floatToBinary(numberString.toFloat(), 8)}")
    println()

    fun <T> printType(obj: T) {
        when (obj) {
            is Int -> println("Это целое число")
            is Float, is Double -> println("Это число с плавающей точкой")
            is Char -> println("Это символ")
            is String -> println("Это строка")
            else -> println("Неизвестный тип ${obj.toString()}")
        }
    }

    printType(10)
    printType(13.3f)
    printType(13.3)
    printType('з')
    printType("строка")
    println()

    /**
     * если это будет целое число, то возвращает инкремент, если строка - инкремент длины строки, если массив целых чисел - сумму элементов массива, иначе null
     */
    fun <T> magicMethod(obj: T): Int? {
        return when (obj) {
            is Int -> obj + 1
            is String -> obj.length + 1
            is Array<*> -> if (obj.all { e -> e is Int }) (obj as Array<Int>).sum() else null
            is IntArray -> obj.sum()
            else -> null
        }
    }

    println(magicMethod(10))
    println(magicMethod("Вернёт 9"))
    println(magicMethod(arrayOf("будет null", 5)))
    println(magicMethod(arrayOf(0, 1, 2)))
    val intArray = IntArray(5) { index -> index * 2 }
    println(intArray.contentToString())
    println(magicMethod(intArray))
    println(magicMethod(null))
}

fun floatToBinary(number: Float, _precision: Int = 6): String {
    var precision = _precision
    val integerPart = number.toInt()
    var decimalPart = number - integerPart

    val binaryInteger = Integer.toBinaryString(integerPart)

    var binaryDecimal = ""

    while (decimalPart > 0 && precision > 0) {
        decimalPart *= 2
        if (decimalPart >= 1) {
            binaryDecimal += "1"
            decimalPart--
        } else {
            binaryDecimal += "0"
        }
        precision--
    }

    return "$binaryInteger.$binaryDecimal"
}