package module7

fun main() {
    val list = listOf(2, 3, 5, 7, 11)
    println("Первое число: ${list[0]}, ${list.get(0)}, ${list.first()}")

    println(
        "Среднее значение: ${list.average()}, ${
            list.let {
                var sum = 0.0
                for (element in it) sum += element
                sum / it.size // it.sum().toDouble() / it.size
            }
        }"
    )

    println(
        "Сумма значений: ${list.sum()}, ${
            list.let {
                var sum = 0
                for (element in it) sum += element
                sum
            }
        }"
    )

    println("Кол-во элементов: ${list.size}, ${
        list.let {
            var count = 0
            for (i in it) count++
            count
        }
    }")

    println("Сумма двух последних элементов: ${list.takeLast(2).sum()}, ${
        list.let {
            var sum = 0
            for (i in 1..2) sum += list[list.size - i]
            sum
        }
    }")

    println(
        "Сумма индексов: ${list.indices.sum()}, ${
            list.indices.let {
                var sum = 0
                for (index in it) sum += index
                sum
            }
        }")
}