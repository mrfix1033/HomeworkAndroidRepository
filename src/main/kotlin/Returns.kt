import java.util.*

fun main() {
    var array = Array(10) { 0 }
    var random = Random()
    for (i in 0..<array.size) array[i] = random.nextInt(30) - 15
    println("Array: ${array.contentToString()}\n")
    println("1) The number of minimums: ${getCountMinumums(array)}")
    println("2) The new array: ${incrementNegativeElements(array).contentToString()}")

    var n = 5
    var m = 10
    var k = 2
    var matrix = Array(n) { Array(m) { 0 } }
    for (i in 0..<matrix.size) for (j in 0..<matrix[0].size) matrix[i][j] = random.nextInt(30) - 15
    print("3) Full matrix: ${matrix.contentDeepToString()}\n3) ")
    printStringFromMatrix(matrix, k)
}

fun getCountMinumums(array: Array<Int>): Int {
    var count = 0
    if (array[0] < array[1]) count++
    if (array[array.size - 1] < array[array.size - 2]) count++
    for (i in 1..<array.size - 1) if (array[i - 1] > array[i] && array[i] < array[i + 1]) count++
    return count
}

fun incrementNegativeElements(array: Array<Int>): Array<Int> {
    for (i in 0..<array.size) if (array[i] < 0) array[i]++
    return array
}

fun printStringFromMatrix(matrix: Array<Array<Int>>, k: Int) {
    for (i in matrix[k - 1])  // мы же хотим K-ю строку в нашем измерении
        print("$i ")
}