import java.util.*

fun main() {
    val registration = Registration()
    registration.setEmail("mrfix1033@mail.ru")
    println("1) User's email: ${registration.getEmail()}")
    println("1) Does the user have a password: ${registration.hasPassword()}")
    registration.setPassword("qwertyasdfgh")
    println("1) Does the user have a password: ${registration.hasPassword()}")

    val utils = Utils()
    val matrix = Array(5) { Array(5) { 0 } }
    println("3) An initialized matrix: ${matrix.contentDeepToString()}")
    utils.fillMatrixWithRange(matrix)
    println("3) A filled matrix: ${matrix.contentDeepToString()}")

    println("2) An only even numbers: ${utils.getEvenNumbersFromMatrix(matrix).contentToString()}")

    val array = Array(9) { 0 }
    println("3) An initialized array: ${array.contentDeepToString()}")
    utils.fillArray(array)
    println("3) A filled matrix: ${array.contentDeepToString()}")
    utils.printPositiveNumber(array)
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

class Utils {
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

    fun fillArray(inner: Array<Int>, vararg startFrom: Int): Int {
        for (iOfNum in inner.indices) inner[iOfNum] = startFrom[0]++
        return startFrom[0]
    }

    fun printPositiveNumber(array: Array<Int>) {
        print("4) A positive numbers: ")
        for (num in array) if (num > 0) print("$num ")
    }

}