fun main() {
    var number = 10
    print("1) Исходное число: $number ")
    if (number > 0) ++number
    println("новое число: $number")

    var number1 = 4
    var number2 = 45
    var number3 = -2
    var number4 = 8
    var count = 0
    if (number1 > 0) ++count
    if (number2 > 0) ++count
    if (number3 > 0) ++count
    if (number4 > 0) ++count
    println("2) Количество положительных чисел: $count")

    number = 10
    number1 = 5
    println("3) Наибольшее число: ${if (number > number1) number else number1}")

    number = 3
    print("4) ")
    if (number == 1)
        println("Monday")
    else if (number == 2)
        println("Tuesday")
    else if (number == 3)
        println("Wednesday")
    else if (number == 4)
        println("Thursday")
    else if (number == 5)
        println("Friday")
    else if (number == 6)
        println("Saturday")
    else if (number == 7)
        println("Sunday")
    else println("Некорректное число")

    number = 5
    println("5) ${if (number == 1) "Плохо" else if (number == 2) "Неудовлетворительно" else if (number == 3) "Удоавлетворительно" else if (number == 4) "Хорошо" else if (number == 5) "Отлично" else "Ошибка"}")

    var operator = 2
    var operand1 = 1.0
    var operand2 = 3.0
    var answer = if (operator == 1) operand1 + operand2 else if (operator == 2) operand1 - operand2 else if (operator == 3) operand1 * operand2 else if (operator == 4) if (operand2 == 0.0) "Ошибка: второй операнд при делении не может быть равным 0" else operand1 / operand2 else "Некорректная операция"
    println("6) ${answer}")
}