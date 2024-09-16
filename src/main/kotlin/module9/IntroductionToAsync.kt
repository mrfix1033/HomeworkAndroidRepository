package module9

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main() {
    data class Person(val name: String, val age: Int, val clazz: String)
    data class Weather(val city: String, val description: String, val temp: Int)

    val personList = listOf(
        Person("Дерек", 19, "3D"),
        Person("Алексей", 54, "11R"),
        Person("Григорий", 32, "4V")
    )
    val weatherList = listOf(
        Weather("Москва", "Облачно с прояснениями", 18),
        Weather("Иннополис", "Солнечно", 27),
        Weather("Санкт-Петербург", "Солнечно", 24)
    )
    val randomIntegersList = List(10) { Random.nextInt(1, 100) }

    println("Начало загрузки...")

    startLoad(personList, weatherList, randomIntegersList)

    println("Программа завершена")
}

suspend fun startLoad(vararg iterables: Iterable<Any>) {
    coroutineScope {
        val tasks = MutableList<Job?>(iterables.size) { null }
        val returns = MutableList<Any?>(iterables.size) { null }
        for ((i, iterable) in iterables.withIndex())
            tasks[i] = launch {
                returns[i] = action(iterable)
            }
        (tasks as Collection<Job>).joinAll()

        returns.forEach(::println)

        println("Данные загружены")
    }
}

suspend fun <T> action(iterable: Iterable<T>): Iterable<T> {
    for (elem in iterable) {
        println(elem)
        delay(1000L)
    }
    return iterable
}