package module6

fun main() {
    printFavoriteBook("Пентестинг на Android")
    printFavoriteBook(null)

    println(DivideIfWhole(25, 5))
    println(DivideIfWhole(75, 5))
    println(DivideIfWhole(75, 5) ?: 0)

    val array = arrayOf("Привет", "как", null, "дела")
    val newArray: Array<String> = array.filterNotNull().toTypedArray()
    println("Старый массив: ${array.contentToString()}")
    println("Новый массив: ${newArray.contentToString()}")
}

fun printFavoriteBook(bookName: String?) {
    println(bookName ?: "Нет любимой книги")
}

fun DivideIfWhole(a: Int, b: Int): Int? {  // getNumberOfMultipliers - думаю подошло бы лучше)
    var ad = a  // a divisible
    var count = 0
    while (ad % b == 0 && ad != 1) {
        count++
        ad /= b
    }
    return if (ad == 1) count else null
}