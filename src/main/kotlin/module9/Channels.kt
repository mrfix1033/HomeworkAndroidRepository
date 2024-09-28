package module9

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import java.util.*
import kotlin.system.measureTimeMillis

val channel = Channel<String>()
suspend fun main() {
    coroutineScope {
        launch {
            getList(Storage().text)
        }
        launch {
            measureTimeMillis {
                val stringResult = buildString {
                    println("Клиент: Ожидаю приёма...")
                    for (e in channel) {
                        append(e)
                        append(' ')
                        println("Клиент: Принято. Ожидаю приёма...")
                    }
                    println("Клиент: Соединение закрыто")
                    dropLast(1)
                }
                println("\nРезультат:\n$stringResult")
            }.let { println("Затрачено: $it") }
        }
    }

    coroutineScope {
        val channelForSend = Channel<String>()
        val channelForReceive = modifiedList(channelForSend)
        val split = Storage().text.split(' ')
        launch {
            for (e in split) {
                channelForSend.send(e)
                delay(5L)
            }
            println("Клиент: закрываю исходящее соединение...")
            channelForSend.close()
            println("Клиент: закрыл исходящее соединение")
        }
        launch {
            measureTimeMillis {
                val stringResult = buildString {
                    println("Клиент: Ожидаю приёма...")
                    for (e in channelForReceive) {
                        append(e)
                        println("Клиент: Принято. Ожидаю приёма...")
                    }
                    println("Клиент: Входящее соединение закрыто")
                    dropLast(1)
                }
                println("\nРезультат:\n$stringResult")
                println(stringResult.toList())
            }.let { println("Затрачено: $it") }
        }
    }
}

suspend fun getList(text: String) {
    val split = text.split(' ')
    coroutineScope {
        launch {
            split.forEachIndexed { i, it ->
                println("Сервер: ${i + 1} / ${split.size} отправлено")
                channel.send(it)
                delay(10L)
            }
            println("Сервер: Закрываю соединение...")
            channel.close()
            println("Сервер: Соединение закрыто")
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.modifiedList(channel: Channel<String>): ReceiveChannel<Char> = produce {
    for (e in channel) {
        println("Сервер: Получено")
        send(e.first().run { if (isLowerCase()) titlecase(Locale.getDefault()).first() else this })
        delay(10L)
        println("Сервер: Ответил")
    }
    println("Сервер: Входящее соединение закрыто")
    println("Сервер: Закрываю исходящее соединение...")
    close()
    println("Сервер: Закрыл исходящее соединение")
}

private class Storage {
    val text = "Басня Крылова «Мартышка и очки»\n\n" +
            "Мартышка к старости слаба глазами стала;\n" +
            "А у людей она слыхала,\n" +
            "Что это зло еще не так большой руки:\n" +
            "Лишь стоит завести Очки.\n" +
            "Очков с полдюжины себе она достала;\n" +
            "Вертит Очками так и сяк:\n" +
            "То к темю их прижмет, то их на хвост нанижет,\n" +
            "То их понюхает, то их полижет;\n" +
            "Очки не действуют никак.\n" +
            "\"Тьфу пропасть! - говорит она,- и тот дурак,\n" +
            "Кто слушает людских всех врак:\n" +
            "Всё про Очки лишь мне налгали;\n" +
            "А проку на-волос нет в них\".\n" +
            "Мартышка тут с досады и с печали\n" +
            "О камень так хватила их,\n" +
            "Что только брызги засверкали.\n" +
            "К несчастью, то ж бывает у людей:\n" +
            "Как ни полезна вещь,- цены не зная ей,\n" +
            "Невежда про нее свой толк все к худу клонит;\n" +
            "А ежели невежда познатней,\n" +
            "Так он ее еще и гонит."
}