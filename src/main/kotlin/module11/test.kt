package module11

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

suspend fun main() {
    measureTimeMillis {
        withContext(newSingleThreadContext("1")) {
            launch {
                repeat(5) {
                    delay(500L)
                    println("Вторая параллельная корутина")
                }
                println("Вторая параллельная корутина закончила выполнение")
            }

            launch {
                delay(1000L)
                getList().collect {
                    println("Handled $it")
                }
            }
        }
    }.let { println(it) }
}

fun getList() = (1..5).asFlow().onEach { delay(500) }
