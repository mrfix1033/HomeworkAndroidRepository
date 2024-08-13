package module7

fun main() {
    val array = arrayOf("строка", "str", "string", "string", "строка", "строка")
    println("Массив: ${array.contentToString()}")
    println("Частотная карта элементов массива: ${getFrequencyMap(array)}")

    println()
    val people = mutableMapOf(1 to "Иван", 2 to "Петр", 3 to "Лида", 4 to "Петр", 5 to "Анна")
    openDeleteMenu(people)

    data class Person(val name: String, val age: Int, val jobName: String)

    var personHashMap = mutableMapOf<Int, Person>()
    personHashMap[1] = Person("Сергей", 24, "Менеджер")
    personHashMap[2] = Person("Котлин", 18, "Программист")
    personHashMap[3] = Person("Александр", 35, "Тим-лид")
    println("Карта: $personHashMap")
}

fun openDeleteMenu(map: MutableMap<Int, String>) {
    val reversedMap = map.entries.associateBy({ it.value }) { it.key }.toMutableMap()
    while (true) {
        println("Карта: $map")
        println("Введите ЗНАЧЕНИЕ, которое вы хотите удалить или пустую строку для выхода: ")
        val input = readln()
        if (input.isEmpty()) break
        val key = reversedMap.remove(input)
        if (key == null) println("Такого значения нет.")
        else {
            map.remove(key)
            println("Ключ $key и значение $input удалены")
        }
    }
}

fun <T> getFrequencyMap(array: Array<T>): Map<T, Int> {
    val map = mutableMapOf<T, Int>()
    for (element in array) map[element] = map.getOrElse(element) { 0 } + 1
    return map
}