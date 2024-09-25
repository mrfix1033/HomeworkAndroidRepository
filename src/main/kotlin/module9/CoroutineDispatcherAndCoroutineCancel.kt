package module9

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

private val personList = mutableListOf<Person>()
private val resultList = mutableMapOf<Person, Int>()

suspend fun main() {
    println("Программа работы с базой данных сотрудников")
    val personManager = PersonManager()
    delay(1000L)

    while (true) {
        print(
            "\nДобавить сотрудника:\n" +
                    "1.Да\n" +
                    "2.Нет (завершить работу)"
        )
        if (personList.isNotEmpty()) println("\n3.Прочитать базу данных")
        println()
        when (readln()) {
            "1" -> {
                var name: String
                while (true) {
                    println("Введите имя сотрудника: ")
                    name = readln()
                    if (name.isEmpty()) println("Имя не может быть пустым!")
                    else break
                }

                var salary: Int?
                while (true) {
                    println("Введите зарплату сотрудника: ")
                    salary = readln().toIntOrNull()
                    if (salary == null) println("Вы ввели не число!")
                    else break
                }

                val person = Person(name, salary!!)
                personManager.addPerson(person)
                println("Сотрудник $name добавлен!")
            }

            "2" -> break
            "3" -> {
                if (personList.isEmpty()) continue
                for (person in personList)
                    println("Сотрудник: ${person.name}; Зарплата: ${person.salary}")
            }
        }
    }

    coroutineScope {
        val generateAndPrintJob = launch {
            for (person in personList) addPassword(person)
            readDataPersonList()
        }

        launch {
            println("Идёт вывод паролей... Введите 0 для остановки")
            if (readln() == "0") {
                generateAndPrintJob.cancelAndJoin()
                println("Завершение полной работы")
            }
        }
    }
}

private suspend fun addPassword(person: Person) {
    val password = Random.nextInt(1000000000)
    resultList[person] = password
    delay(500L)
}

private suspend fun readDataPersonList() {
    for (i in resultList) {
        println("Сотрудник: ${i.key}; пароль: ${i.value}")
        delay(1000L)
    }
}

private data class Person(val name: String, val salary: Int)

private class PersonManager {
    fun addPerson(person: Person) = personList.add(person)
}