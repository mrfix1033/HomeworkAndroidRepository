package module5

fun main() {
    outer@ while (true) {
        print("Введите название месяца: ")
        println(
            "Время года: ${
                when (readln().lowercase()) {
                    "декабрь", "январь", "февраль" -> Season.WINTER
                    "март", "апрель", "май" -> Season.SPRING
                    "июнь", "июль", "август" -> Season.SUMMER
                    "сентябрь", "октябрь", "ноябрь" -> Season.AUTUMN
                    else -> "некорректный месяц"
                }
            }"
        )
        while (true) {
            print("Желаете продолжить? (1 - да, 2 - нет): ")
            when (readln()) {
                "1" -> break
                "2" -> break@outer
                // иначе спросить еще раз
            }
        }
    }

    val string = "Шумоизоляция"
    var arrayChars = arrayOf<Char>()
    var arrayCountedChars = arrayOf<Char>()
    for (char in string) {
        if (char in arrayChars) {
            if (char !in arrayCountedChars)
                arrayCountedChars += char
        } else arrayChars += char
    }
    println("Кол-во символов, которые встречаются не один раз в строке \"$string\" - ${arrayCountedChars.size}")
    println("Сами символы: ${arrayCountedChars.contentToString().substring(1).substringBeforeLast("]")}")
}

enum class Season(val nameOfSeason: String) {
    WINTER("зима"),
    SPRING("весна"),
    SUMMER("лето"),
    AUTUMN("осень");

    override fun toString() = nameOfSeason
}