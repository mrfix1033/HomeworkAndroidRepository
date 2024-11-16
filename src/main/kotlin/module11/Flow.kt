package module11

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
suspend fun main() {
    class Person(val name: String, val role: String) {
        override fun toString(): String {
            return "Пользователь: $name, $role"
        }
    }

    val persons = listOf(
        Person("Sergey", "Junior-programmer"),
        Person("Andrey", "Middle-programmer"),
        Person("Rinat", "Team-lead"),
        Person("Aleksey", "Director")
    )

    fun getPersonsFlow() = flow {
        delay(50L)
        persons.forEach { emit(it) }
    }

    fun getPhoneFlow(length: Int) = flow {
        repeat(length) {
            val number = StringBuilder("+7917")
            repeat(7) {
                delay(40L)
                number.append(Random.nextInt(10))
            }
            emit(number.toString())
        }
    }

    withContext(newSingleThreadContext("FlowThread")) {
        val personsCoroutine = mutableListOf<Person>()
        val phones = mutableListOf<String>()
        launch {
            launch {
                getPhoneFlow(persons.size).collect { phones.add(it) }
                println("Конец")
            }
            launch {
                getPersonsFlow().collect { personsCoroutine.add(it) }
                println("Конец")
            }
        }.join()
        val personsAndPhones = MutableList(persons.size * 2)
        { if (it % 2 == 0) personsCoroutine[it / 2].toString() else phones[it / 2] }
        println(personsAndPhones)
    }
}