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
    magicString.count(Char::isDigit)
}

//2. Нужно осуществить проверку номера телефона. Он должен начинаться с +7 и содержать 10 цифр, не считая +7. Если телефон верно введен, выведите true, иначе false.
//3. Дана строка. Вывести символы, составляющие эту строку, но в обратном порядке.
//4. Дана строка «kotlin2023course». Подсчитать количество содержащихся в ней цифр.