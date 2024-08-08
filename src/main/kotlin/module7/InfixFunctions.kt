package module7

fun main() {

    infix fun Int.add(operand: Int) = this + operand
    infix fun Float.add(operand: Float) = this + operand
    infix fun Double.add(operand: Double) = this + operand
    infix fun String.add(operand: String) = this + operand

    infix fun Int.sub(operand: Int) = this - operand
    infix fun Float.sub(operand: Float) = this - operand
    infix fun Double.sub(operand: Double) = this - operand

    infix fun Int.mul(operand: Int) = this * operand
    infix fun Float.mul(operand: Float) = this * operand
    infix fun Double.mul(operand: Double) = this * operand

    infix fun Int.div(operand: Int) = this / operand
    infix fun Float.div(operand: Float) = this / operand
    infix fun Double.div(operand: Double) = this / operand

    println(1 add 2)
    println(1.2f add 3.5f)
    println(1.23 add 2.46)
    println("First" add "And" add "Second")
    println()

    println(1 sub 2)
    println(1.2f sub 3.5f)
    println(1.23 sub 2.46)
    println()

    println(1 mul 2)
    println(2f mul 3.5f)
    println(1.2 mul 5.5)
    println()

    println(4 div 2)
    println(5f div 2f)
    println(1.0 div (1 shl 10).toDouble())
    println()

    data class Person(val name: String) {
        infix fun say(what_to_say: String) = println(what_to_say)
    }

    val person = Person("Серёжа")
    person say "Добрый день!"  // так вот взглянешь, не поймёшь что это такое, какой-то пёрсон говорит Добрый день :D
    println()

    data class Point(val x: Double, val y: Double) {
        infix fun isAbove(point: Point) = this.y > point.y
        infix fun isRightOf(point: Point) = this.x > point.x
    }

    val pointOne = Point(10.0, 5.0)
    val pointTwo = Point(15.0, 1.0)
    println("Точка 1 выше другой?: ${pointOne isAbove pointTwo}")
    println("Точка 2 правее другой?: ${pointTwo isRightOf pointOne}")
}
