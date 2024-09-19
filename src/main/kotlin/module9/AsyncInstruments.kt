package module9

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    println("Программа покупки продуктов")
    delay(1000L)
    println(
        "Купить товар:\n" +
                "1.Да\n" +
                "2.Нет"
    )
    while (true) {
        when (readln()) {
            "1" -> {
                println("Оплата продукта началась")
                delay(2000L)
                println("Сканирование и обработка...")
                delay(2000L)
                println("Покупка оплачена.")
            }

            "2" -> {
                println("Отмена покупки...")
                delay(2000L)
                println("Покупка отменена.")
            }

            else -> {
                println("Некорректный выбор!")
                continue
            }
        }
        goodbye()
        break
    }

    println("Старт второй задачи...")
    delay(1000L)
    println("Начало программы")
    coroutineScope {
        var secondPart = launch(start = CoroutineStart.LAZY) {
            for (i in 3..4) {
                println(i)
                delay(500L)
            }
        }
        launch {
            for (i in 1..2) {
                println(i)
                delay(500L)
            }
        }.join()
        secondPart.start()
        println("Произошел ленивый запуск")
        secondPart.join()
        programEnd()
    }
}

fun programEnd() {
    println("Программа завершена")
}

suspend fun goodbye() {  // можно без suspend, но нужна "корутина"
    println("До свидания")
}
