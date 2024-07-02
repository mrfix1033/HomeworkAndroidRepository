
fun main() {
    var a = 1
    var b = 10
    println("1) The arithmetic mean is ${(b + a) / 2.0}")

    var S = 100
    var d = Math.sqrt(S * 4 / Math.PI)
    println("2) The diameter is $d")
    println("2) The circumference is equal to ${d * Math.PI}")

    var x1 = 10
    var y1 = 5
    var x2 = 15
    var y2 = 10  // square
    a = x2 - x1
    b = y2 - y1
    println("3) The perimeter is equal to ${(a+b)*2} and square is equal to ${a*b}")

    a = 1
    print("4) ")
    repeat(10) {
        print("$a ")
        a = a shl 1
    }
    println()

    print("5) ")
    for (i in 20 downTo 0 step 2) print("$i ")
}