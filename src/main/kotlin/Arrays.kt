import java.util.*

fun main() {
    var array = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 5.0, 6.0, 7.0, 8.0, 9.0)
    var productOfNumbers = 1.0
    for (e in array) {
        productOfNumbers *= e
    }
    println("1) The product of numbers is $productOfNumbers")

    var array2 = arrayOf(1,2,3,4,5,6,7,8)
    println("2) The average value of the numbers is ${array2.average()}")

    var size = 8
    var array3 = Array(size) {0}
    var random = Random()
    for (i in 0..<size) array3[i] = random.nextInt(size * 2)
    println("3) An array: ${array3.contentToString()}")
    var count = 0
    for (e in array3) {
        if ((e and 1) == 0) {
            count++
            println("3) Number $e")
        }
    }
    println("3) The number of even numbers is $count")

    var N = 10
    var array4 = IntArray(N)
    for (i in 0..<N) array4[i] = 2 shl i
    println("4) An array of powers of two: ${array4.contentToString()}")
}

// Создать массив из 8 целых чисел. Найти среднее арифметическое его элементов.
//3. Дан массив размерностью size. Вывести в том же порядке все четные числа из данного набора и количество K таких чисел.
//4. Дано целое число N(>0). Сформировать и вывести целочисленный массив размера N, содержащий степени двойки от первой до N-й: 2,4,8,16,….