package module11

import kotlinx.coroutines.flow.*
import kotlin.random.Random

suspend fun main() {
    run {
        val numbers = (1..5).asFlow()
        println(numbers.map { it * it }.reduce { prev, now -> prev + now })
    }
    println()
    run {
        data class Person(val name: String, val age: Int)

        val peopleFlow = flowOf(
            Person("Андрей", 17),
            Person("Алексей", 19),
            Person("Дмитрий", 23),
            Person("Геннадий", 59)
        )

        fun Flow<Person>.getPerson(first: String, age: Int) = filter { it.age == age && it.name.startsWith(first) }

        peopleFlow.getPerson("А", 17).collect(::println)
    }
    println()
    run {
        data class Person(val name: String, val cart: String, val password: Int)

        fun generateDigitSequence(length: Int) = buildString { repeat(length) { append(Random.nextInt(10)) } }

        fun <T1, T2, T3, R> magicFlowJoin(
            first: Flow<T1>, second: Flow<T2>, third: Flow<T3>, listToR: suspend (T1, T2, T3) -> R
        ): Flow<R> = combine(first, second, third, listToR)

        val names = listOf("Петр", "Григорий", "Арслан").asFlow()
        val carts = buildList(3) { repeat(3) { add(generateDigitSequence(16)) } }.asFlow()
        val passwords = buildList(3) { repeat(3) { add(generateDigitSequence(4).toInt()) } }.asFlow()

        println(magicFlowJoin(names, carts, passwords) { a, b, c -> Person(a, b, c) }.toList())
    }
}