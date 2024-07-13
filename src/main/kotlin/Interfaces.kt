interface IEmergencyService {
    fun getDescription() : String
    fun startWork(message: String)
}

abstract class EmergencyService(val name: String, val phoneNumber: String) : IEmergencyService

class Police(name: String, phoneNumber: String) : EmergencyService(name, phoneNumber) {
    override fun getDescription() : String {
        return "Охрана поряка"
    }

    override fun startWork(message: String) {
        val split = message.split(";")
        val address = split[0]
        val description = if (message.length > 1) split[1] else "нет"
        println("Выезжаем на место $address, описание ситуации: $description")
    }
}

fun main() {
    val emergencyService: IEmergencyService = Police("Полиция", "02")
    emergencyService.startWork("улица Пушкина, 41;2 хулигана")
    println("-".repeat(30))

    val a = 20
    val b = 25
    println("2) НОД $a и $b = ${gcd(a, b)}")
    println("-".repeat(30))


    // такое задание уже было)
    val array = arrayOf(2,4,3,5,1,9)
    var max = array[0]
    var preMax = max
    for (element in array)
        if (element >= max) {
            preMax = max
            max = element
        }
    println("3) В массиве ${array.contentToString()} вторым максимальным является $preMax")
}

fun gcd(a: Int, b: Int) : Int = if (b != 0) gcd(b, a % b) else a