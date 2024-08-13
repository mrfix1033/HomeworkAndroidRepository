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
    val reversedMap = mutableMapOf<String, MutableSet<Int>>()
    map.forEach { (k, v) -> reversedMap[v] = reversedMap.getOrElse(v) { mutableSetOf() }.apply { add(k) } }

    while (true) {
        println("Карта: $map")
        println("Введите ЗНАЧЕНИЕ, которое вы хотите удалить или пустую строку для выхода: ")
        val input = readln()
        if (input.isEmpty()) break
        val keys = reversedMap.remove(input)
        if (keys == null) println("Такого значения нет.")
        else {
            keys.forEach(map::remove)
            println("Ключ${if (keys.size > 1) "и" else ""} ${keys.joinToString()} и значение $input удалены")
        }
    }
}

fun <T> getFrequencyMap(array: Array<T>): Map<T, Int> {
    val map = mutableMapOf<T, Int>()
    for (element in array) map[element] = map.getOrElse(element) { 0 } + 1
    return map
}