package module6

fun main() {
    val taskString = "Занятие"
    println("Строка \"$taskString\" состоит из следующих символов:")
    taskString.forEach(::println)

    fun phoneNumberVerify(number: String) =
        number.startsWith("+7") && number.length == 12 && number.substring(1).all(Char::isDigit)

    println(phoneNumberVerify("+79999999999"))
    println(phoneNumberVerify("+7999999999"))
    println(phoneNumberVerify("+79999999f99"))
    println(phoneNumberVerify("79999999999"))
    println(phoneNumberVerify("799999999999"))
    println(phoneNumberVerify("+89999999999"))

    println("Символы строки \"$taskString\" с конца:")
    taskString.reversed().forEach(::println)

    val magicString = "kotlin2023course"
    println("Количество цифр в строке \"$magicString\" = ${magicString.count(Char::isDigit)}")
}