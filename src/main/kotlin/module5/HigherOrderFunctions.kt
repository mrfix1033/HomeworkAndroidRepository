package module5

fun main() {
    val mixerRGB: (String, String) -> String = { hex1, hex2 ->
        var c1 = hex1
        var c2 = hex2
        if (c1[0] == '#') c1 = c1.substring(1)
        if (c2[0] == '#') c2 = c2.substring(1)
        var sums = arrayOf<Int>()
        for (i in c1.indices step 2)
            sums += (c1.substring(i, i + 2).toInt(16) + c2.substring(i, i + 2).toInt(16)) / 2
        var answer = "#"
        for (i in 0..2)
            answer += Integer.toHexString(sums[i])
        answer
    }

    println("Новый цвет: ${action("#FFffFF", "0000FF", mixerRGB)}")
    val array = arrayOf(1, 2, 3, 4, 5)
    println("Инкремент значений массива: ${map(array, ::increment).contentToString()}")
    println("Удвоение значений массива: ${map(array, ::doubling).contentToString()}")
}

fun action(color1: String, color2: String, mixer: (String, String) -> String) = mixer(color1, color2)

fun increment(n: Int) = n + 1

fun doubling(n: Int) = n * 2

fun map(array: Array<Int>, func: (Int) -> Int) = array.map(func).toTypedArray()