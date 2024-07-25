package module5

fun main() {
    cycle@ while (true) {
        println(
            "Выберите режим:\n" +
                    "1) из 10-ой СС в 2-ую СС\n" +
                    "2) из 2-ой СС в 10-ую СС\n" +
                    "3) выход"
        )
        val answer: String
        when (readln()) {
            "1" -> {
                println("Введите число в 10-ой СС")
                var num = readln()
                val isMinus = num[0] == '-'
                if (isMinus) num = num.substring(1)
                for (c in num)
                    if (c !in '0'..'9') {
                        println("Некорректное число!")
                        continue@cycle
                    }
                answer = (if (isMinus) "-" else "") + Integer.toBinaryString(num.toInt())
            }

            "2" -> {
                println("Введите число в 2-ой СС")
                var num = readln()
                for (c in if (num[0] == '-') num.substring(1) else num)
                    if (c !in '0'..'1') {
                        println("Некорректное число!")
                        continue@cycle
                    }
                answer = num.toInt(2).toString()
            }

            "3" -> break
            else -> {
                println("Вы ввели не число!")
                continue
            }
        }
        println("Ответ: $answer")
    }

    val string = "А буду я у дуба"
    fun isPalindrome(string: String): Boolean {
        val newString = string.replace(" ", "").lowercase()
        for (i in newString.indices)
            if (newString[i] != newString[newString.length - 1 - i]) return false
        return true
    }
    println("Строка \"$string\" ${if (isPalindrome(string)) "" else "не "}является палиндромом")
}