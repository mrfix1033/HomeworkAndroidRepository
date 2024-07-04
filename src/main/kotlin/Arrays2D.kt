fun main() {
    var myArray = arrayOf(
        arrayOf(0, 1, 2),
        arrayOf(3, 4, 5),
        arrayOf(7, 8, 9)
    )
    var minElem = Int.MAX_VALUE
    for (innerArray in myArray)
        for (elem in innerArray)
            if (minElem > elem) minElem = elem
    println("1) Minimal element in ${myArray.contentDeepToString()} is $minElem")

    var myArray2 = arrayOf(
        arrayOf(0, 9, 10),
        arrayOf(1, 8, 11),
        arrayOf(2, 7, 12),
        arrayOf(3, 6, 13),
        arrayOf(4, 5, 14)
    )
    println("2) Median in ${myArray2.contentDeepToString()} is ${myArray2[myArray2.size / 2][myArray2[0].size / 2]}")

    var myArray3 = arrayOf(
        IntArray(5),
        IntArray(5),
        IntArray(5),
        IntArray(5),
        IntArray(5)
    )
    for (i in 0..2)
        for (j in myArray3.size / 2 - i..myArray3.size / 2 + i)
            myArray3[i+2][j] = 1
    println("3) Array is:")
    for (innerArray in myArray3) {
        for (e in innerArray)
            print("$e ")
        println()
    }

    var myArray4 = arrayOf(1, 2, 3, 4, 5, 6)
    var max = myArray4[0]
    var preMax = max
    for (e in myArray4)
        if (max < e) {
            preMax = max
            max = e
        }
    println("4) Pre-maximum is $preMax")
}