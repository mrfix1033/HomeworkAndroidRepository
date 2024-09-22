package module9

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

const val timeMultiplier = 1

suspend fun main() {
    measureTimeMillis {
        val firstList = getRandomList(listOf('a', 'b', 'c'), 10).also(::println)
        val secondList = getRandomList((0..9).toList(), 10).also(::println)

        val firstListLength: Int
        val secondListLength: Int

        runBlocking {
            val firstDeferred = async { unpack(firstList) }
            val secondDeferred = async { unpack(secondList) }
            firstListLength = firstDeferred.await()
            secondListLength = secondDeferred.await()
        }

        println("Список $firstList имеет $firstListLength элемент(-ов)")
        println("Список $secondList имеет $secondListLength элемент(-ов)")

        println(firstList.concatenate(secondList))
    }.let { println("Затрачено ${it}мс")}
}

fun <T> getRandomList(available: List<T>, count: Int) = run {
    assert(available.isNotEmpty()) { "Передан пустой список возможных элементов" }
    List(count) { available[Random.nextInt(available.size)] }
}

suspend fun <T> unpack(list: List<T>) = run {
    var counter = 0
    list.forEachIndexed { i, e ->
        counter++
        println("$i-ый элемент) $e")
        delay((1000L * timeMultiplier).toLong())
    }
    counter
}

infix fun <T> List<T>.concatenate(operand: List<T>) =
    this.toMutableList()
        .apply { addAll(operand) }
        .let {
            Pair(it.size, it)
        }