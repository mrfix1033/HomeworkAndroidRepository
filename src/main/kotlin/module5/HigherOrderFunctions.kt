package module5

fun action(color1: String, color2: String, mixer: (String, String) -> String) = mixer(color1, color2)

fun increment(n: Int) = n + 1

fun doubling(n: Int) = n * 2

fun map(array: Array<Int>, func: (Int) -> Int) = array.map(func).toTypedArray()