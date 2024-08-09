package module7

fun main() {
    val hashSet = hashSetOf(1, 2, 3, 4, 5)
    val evenNumbersSet = hashSet.filter { number -> number and 1 == 0 }.toSet()
    val oddNumbersSet = hashSet subtract evenNumbersSet
    println("Весь набор чисел: $hashSet")
    println("Четные числа: $evenNumbersSet")
    println("Нечетные числа: $oddNumbersSet")
    println()

    val magicSet = hashSet.map { number -> number * 2 }.filter { number -> number % 5 == 0 }.toSet()
    println("Новый набор: $magicSet")
    println()

    val numbersList = listOf(1, 2, 3, 2, 2, 3, 4, 5, 6, 6)
    println(removeDuplicates(numbersList))
    println()

    val list = listOf(0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0)
    val newList = list.filter { number -> number != 0 }.toMutableList()
    newList.addAll(Array(list.size - newList.size) {0})
    println("Новый массив: $newList")
}

/**
 * возвращает упорядоченный (LinkedHashSet) неизменяемый набор содержащий уникальные элементы коллекции или null, если передано null
 */
fun <T> removeDuplicates(collection: Collection<T>?): Set<T>? = collection?.toSet()