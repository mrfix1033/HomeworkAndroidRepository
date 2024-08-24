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

//    println(groupedByFirstSymbol[null]!!.size)
//    val sortedGrouped = groupedByFirstSymbol.toSortedMap {char1, char2 ->
//        if (char1 == null) -1
//        if (char2 == null) 1
//        char1!!.lowercaseChar().compareTo(char2!!.lowercaseChar())
//    }
//    println(sortedGrouped)
}