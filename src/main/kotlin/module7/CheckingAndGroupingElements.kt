package module7

fun main() {
    val array = listOf(
        "Дан",
        "список",
        "слов",
        "в",
        "произвольном",
        "порядке",
        "по",
        "алфавиту.",
        "Необходимо",
        "сгруппировать",
        "элементы",
        "по",
        "первому",
        "символу.",
        ""
    )
    val groupedByFirstSymbol = array.groupBy { it.getOrNull(0) }
    groupedByFirstSymbol.toSortedMap { char1, char2 ->
        if (char1 == null) -1
        else if (char2 == null) 1
        else char1.lowercaseChar().compareTo(char2.lowercaseChar())
    }.also(::println)
    println()

    array.groupBy(String::length).also(::println)
    println()

    listOf(
        "Nexus One" to 2010,
        "Pixel 2" to 2017,
        "Pixel 4a" to 2020,
        "iPhone 4" to 2010,
        "iPhone X" to 2017,
        "Galaxy Note 8" to 2017,
        "Galaxy S11" to 2020
    ).groupBy({pair -> pair.second}) {pair -> pair.first}
        .also(::println)
}