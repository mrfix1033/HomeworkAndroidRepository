package module8

import kotlin.math.min

fun main() {
    data class Employee(val name: String, val age: Int, val salary: Int)

    val employeesList = listOf(
        Employee("Сергей", 18, 7000),
        Employee("Андрей", 19, 8000),
        Employee("Денис", 25, 90000),
        Employee("Алёша", 13, 0),
        Employee("Шерлок", 16, 30000)
    )

    employeesList.sortedBy { it.name }
        .joinToString { "(${it.name}, ${it.age}, ${it.salary})" }
        .let { println("По имени: $it") }
    employeesList.sortedBy { it.age }
        .joinToString { "(${it.name}, ${it.age}, ${it.salary})" }
        .let { println("По возрасту: $it") }
    employeesList.sortedBy { it.salary }
        .joinToString { "(${it.name}, ${it.age}, ${it.salary})" }
        .let { println("По зарплате: $it") }
    println()

    val matrix = listOf(
        listOf(1, 2, 3),
        listOf(4, 3, 4),
        listOf(5, 4, 3),
        listOf(0, 3, 2)
    )
    matrix.sortedWith { a1, a2 ->
        for (i in 0..<min(a1.size, a2.size))
            if (a1[i] != a2[i]) return@sortedWith a1[i] - a2[i]
        a1.size - a2.size
    }.let { println("Отсортированная матрица по возрастанию: $it") }
    println()

    matrix.filter {
        for (i in 1..it.size - 2)
            if (it[i - 1] == it[i] || it[i] == it[i + 1] || (it[i - 1] > it[i]) xor (it[i] < it[i + 1])) return@filter false
        true
    }.let {
        println(
            "Количество пилообразных строк: ${it.size}\n" +
                    "Строки:\n${it.joinToString()}"
        )
    }
}