fun main() {
    var a = 1.0
    var perimeter: Double = a * 4
    println("Периметр квадрата со стороной " + a + " равен " + perimeter)
    var square: Double = a * a
    println("Площадь квадрата со стороной " + a + " равен " + square)
    var b = 3.0
    perimeter = 2 * (a + b)
    println("Периметр прямоугольника со сторонами " + a + " и " + b + " равна " + perimeter)
    var d = 3.0
    var circumference = d * Math.PI
    println("Длина окружности с диаметром " + d + " равна " + (circumference * 100).toInt() / 100.0)
    var metersInCircumference = circumference.toInt() / 100
    println("Целых метров в длине окружности с диаметром " + d + " - " + metersInCircumference)
    var aLength = 36
    var bLength = 10
    var countSubSections = aLength / bLength
    println("Количество подотрезков B с длиной " + b + " в отрезке A с длиной " + a + " равно " + countSubSections)
}