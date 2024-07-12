import java.util.*

fun main() {
    val registration = Registration()
    registration.setEmail("mrfix1033@mail.ru")
    println("1) User's email: ${registration.getEmail()}")
    println("1) Does the user have a password: ${registration.hasPassword()}")
    registration.setPassword("qwertyasdfgh")
    println("1) Does the user have a password: ${registration.hasPassword()}")

    val utils = UtilsAccessModifiers()
    val matrix = Array(4) { Array(4) { 0 } }
    println("3) An initialized matrix: ${matrix.contentDeepToString()}")
    utils.fillMatrixWithRange(matrix)
    println("3) A filled matrix: ${matrix.contentDeepToString()}")

    println("2) An only even numbers: ${utils.getEvenNumbersFromMatrix(matrix).contentToString()}")

    val array = Array(9) { 0 }
    println("3) An initialized array: ${array.contentToString()}")
    utils.fillArray(array, -4)
    println("3) A filled array: ${array.contentToString()}")

    print("4) A positive numbers: ")
    fun checkIsPositive(num: Int): Boolean = num > 0
    for (num in array) if (checkIsPositive(num)) print("$num ")
}

class Registration {
    private var email: String = ""
    private var password: String = ""

    fun setEmail(newEmail: String) {
        email = newEmail
    }

    fun getEmail() = email.uppercase(Locale.getDefault())

    fun setPassword(newPassword: String) {
        if (newPassword.length < 6) {
            println("Пароль меньше 6-ти символов")
            return
        }
        password = newPassword
    }

    fun hasPassword() = password.isNotEmpty()
}

class UtilsAccessModifiers {
    fun getEvenNumbersFromMatrix(matrix: Array<Array<Int>>): Array<Int> {
        val array = ArrayList<Int>()
        for (inner in matrix) for (num in inner) if (num.and(1) == 0)
            array.add(num)
        return array.toTypedArray()
    }

    fun fillMatrixWithRange(matrix: Array<Array<Int>>) {
        var i = 1
        for (inner in matrix) i = fillArray(inner, i)
    }

    fun fillArray(inner: Array<Int>, startFrom: Int): Int {
        var i = startFrom
        for (iOfNum in inner.indices) inner[iOfNum] = i++
        return i
    }
}