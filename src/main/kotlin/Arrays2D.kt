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
    var myArray21 = arrayOf(
        arrayOf(0, 9, 10, 15),
        arrayOf(1, 8, 11, 16),
        arrayOf(2, 7, 12, 17),
        arrayOf(3, 6, 13, 18),
        arrayOf(4, 5, 14, 19),
        arrayOf(6, 7, 12, 20)
    )
    println("2) Median in ${myArray2.contentDeepToString()} is ${calculateMedian(myArray2)}")
    println("2) Median in ${myArray21.contentDeepToString()} is ${calculateMedian(myArray21)}")

    var myArray3 = arrayOf(
        IntArray(5),
        IntArray(5),
        IntArray(5),
        IntArray(5),
        IntArray(5)
    )
    var myArray31 = arrayOf(
        IntArray(6),
        IntArray(6),
        IntArray(6),
        IntArray(6),
        IntArray(6),
        IntArray(6),
        IntArray(6),
        IntArray(6),
    )
    makeMatrixOfBeautifulOnes(myArray3)
    makeMatrixOfBeautifulOnes(myArray31)
    for (array in arrayOf(myArray3, myArray31)) {
        println("3) Array is:")
        printMatrix(array)
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

fun calculateMedian(matrix: Array<Array<Int>>): Double {
    var countNumbers = 0
    var sum = 0.0
    for (i in (matrix.size - 1) / 2..matrix.size.or(1) / 2)
        for (j in (matrix[0].size - 1) / 2..matrix[0].size.or(1) / 2) {
            sum += matrix[i][j]
            countNumbers++
        }
    return sum / countNumbers
}

fun makeMatrixOfBeautifulOnes(matrix: Array<IntArray>) {
    for (delta in 0..(matrix[0].size - 1) / 2)
        for (j in delta..<matrix[0].size - delta)
            matrix[matrix.size - 1 - delta][j] = 1
}

fun printMatrix(matrix: Array<IntArray>) {
    for (innerArray in matrix) {
        for (e in innerArray)
            print("$e ")
        println()
    }
}