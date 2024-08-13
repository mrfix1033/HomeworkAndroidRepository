package module7

fun main() {
    val map1 = mapOf(1 to "first", 2 to "second", 11 to "eleventh", 12 to "twelfth")
    println("Карта: $map1")
    println("Карта, с ключом меньше 5: ${map1.filterKeys { it < 5 }}")
    println()

    val map2 = mapOf(1 to "Сергей", 2 to "Андрей", 3 to "Дима", 4 to "Гоша")
    println("Карта: $map2")
    println("Карта, со значением, заканчивающемуся на а: ${map2.filterValues { it.endsWith('а') }}")
    println()

    println("Карта: $map2")
    println("Карта, со значением, начинающемуся на Г: ${map2.filterValues { it.startsWith('Г') }}")
    println()

    val prizeMap = mapOf(1 to 20, 2 to 15, 3 to 30, 4 to 40, 5 to 10, 55 to 21)
    println("Карта: $prizeMap")
    println("Карта, с ключом, заканчивающемуся на 5 и значением больше 20: ${prizeMap.filter { entry -> entry.key % 10 == 5 && entry.value > 20}}")
}