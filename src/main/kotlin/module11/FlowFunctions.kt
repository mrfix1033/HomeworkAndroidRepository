package module11

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.toList
import kotlin.math.max
import kotlin.system.measureTimeMillis

suspend fun main() {
    val lowercaseLetters = "abcdefghijklmnopqrstuvwxyz"
    val digits = "1234567890"
    val availableChars = lowercaseLetters + lowercaseLetters.uppercase() + digits
    fun createPassword() = run {
        var upper = true
        buildString(6) {
            repeat(6) {
                append(availableChars.random().let { if (upper) it.uppercase() else it })
                upper = !upper
            }
        }
    }

    fun getListOfPassword(input: String, length: Int) = MutableList(length) {
        var generatedPassword = ""
        do {
            generatedPassword = createPassword()
        } while (generatedPassword[0] != input[0])
        generatedPassword
    }

    fun getListId(length: Int) = run {
        var id = 0
        MutableList(length) {
            (++id).toString().let {  // дополняем нулями
                buildString {
                    repeat(max(0, 6 - it.length)) { append('0') }
                    append(it)
                }
            }
        }
    }

    fun getIdFlow(length: Int) = getListId(length).asFlow()
    fun getPasswordFlow(input: String, length: Int) = getListOfPassword(input, length).asFlow()


    println("Первый символ пароля: ")
    val input = readln()
    println("Количество: ")
    val length = readln().toInt()

    measureTimeMillis {
        val map = mapOf(pairs = getIdFlow(length).toList().zip(getPasswordFlow(input, length).toList()).toTypedArray())
        println(map)
    }.let(::println)
}