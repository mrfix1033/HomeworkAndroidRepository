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

fun DivideIfWhole(a: Int, b: Int): Int? {
    return if (a % b == 0) a / b else null
}