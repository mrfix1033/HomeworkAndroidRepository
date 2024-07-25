package module6

fun main() {
    println(States<Int>().getAverage(arrayOf(1, 2, 3)))
    println(States<Double>().getAverage(arrayOf(2.0, 4.0)))

    println(GenericMethod().isItIncluded(arrayOf("1", "строка", 98),98))
}

class States<T : Number> {
    fun getAverage(array: Array<T>) = array.sumOf(Number::toDouble) / array.size
}

class GenericMethod {
    fun <T> isItIncluded(array: Array<T>, elem: T) = elem in array
}