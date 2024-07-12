class BankCard(val number: Long, private val CVCCode: Int, private val passwordHash: Int) {
    private val tryingsDefault = 3
    private var tryingsNow = 3

    private val defaultCvcCodeValue = null

    private var isBlocked = false

    fun getCVCCode(): Int? {
        if (isBlocked) {
            println("Карта заблокирована.")
            return defaultCvcCodeValue
        }
        while (true) {
            println("Для получения доступа к CVC коду введите пароль (попыток: ${tryingsNow--}):\n> ")
            val password = readln()
            if (password.hashCode() == passwordHash) {  // hashCode не годится хэширования паролей
                println("Верный пароль. CVC код выдан.")
                tryingsNow = tryingsDefault
                return CVCCode
            }
            println("Пароль неверный.")
            if (tryingsNow == 0) break
        }
        isBlocked = true
        println("Попытки кончились. Карта заблокирована.")
        return defaultCvcCodeValue
    }
}

fun main() {
    println("1) Task №1")
    val bankCard = BankCard(2222333344445555, 998, 2031744)
    println("Card number: ${bankCard.number}")
    println("CVC code: ${bankCard.getCVCCode()}")  // пароли: "AaAa", "BBBB" (без кавычек)
    println("CVC code: ${bankCard.getCVCCode()}")  // попробуйте заблокировать карту
    println("CVC code: ${bankCard.getCVCCode()}")  // если вы заблокировали карту, то не получите CVC код (допустим, что у нас нет рефлексии)

    var a = 3
    println("2) The number: $a")
    a += 7
    a -= 4
    a *= 2
    a %= 3
    println("2) The new number: $a")

    var b = 145
    println("3) The number: $b")
    var bNew = 0
    while (b != 0) {
        bNew = bNew * 10 + b % 10
        b /= 10
    }
    println("3) The reversed number: $bNew")
}