fun main() {
    var numberOfMonth = 12
    print("1) ")
    when (numberOfMonth) {
        1 -> println("Зима: Январь.")
        2 -> println("Зима: Февраль.")
        3 -> println("Весна: Март.")
        4 -> println("Весна: Апрель.")
        5 -> println("Весна: Май.")
        6 -> println("Лето: Июнь.")
        7 -> println("Лето: Июль.")
        8 -> println("Лето: Август.")
        9 -> println("Осень: Сентябрь.")
        10 -> println("Осень: Октябрь.")
        11 -> println("Осень: Ноябрь.")
        12 -> println("Зима: Декабрь.")
    }

    print("2) ")
    var float = 24.23
    when (float % 1) {  // а можно и без when, тернарным выражением
        in 0.5..1.0 -> float += 1 - float % 1  // а можно кастануть к инту
        else -> float -= float % 1
    }
    println("Новое число: $float")

    var hour = 0
    print("3) Время суток: ")
    print(
        when (hour) {
            in 0..2, 23 -> "Ночь"
            in 3..5 -> "Раннее утро"
            in 6..11 -> "Утро"
            in 12..17 -> "День"
            in 18..20 -> "Вечер"
            in 21..22 -> "Поздний вечер"
            else -> "Некорректный час"
        } + "\n//"
    )
    var a = 8
    var b = 5
//    a = 5
//    b = 8
    var temp = a
    a = b
    b = temp
    println("4) a = $a | b = $b")
}