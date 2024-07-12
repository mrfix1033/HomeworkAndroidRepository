import java.util.concurrent.TimeUnit

abstract class AbstractShop(workingWith: Int, workingUntil: Int) {
    private var isOpen: Boolean = false

    abstract fun sellProduct(productId: Int, count: Int)

    fun toOpen() {
        isOpen = true
        println("Магазин открылся")
    }

    fun toClose() {
        isOpen = false
        println("Магазин закрылся")
    }

    fun isOpen() = isOpen
}

class Magnit(workingWith: Int, workingUntil: Int) : AbstractShop(workingWith, workingUntil) {
    override fun sellProduct(productId: Int, count: Int) {
        // бакенд-логик
        // tableManager.getMagnitProducts().decrementProduct(productId, count)
        println("Магнит продал товар $productId в количестве $count шт.")
        // бузизнес-логик
    }
}

class Pyterochka(workingWith: Int, workingUntil: Int) : AbstractShop(workingWith, workingUntil) {
    override fun sellProduct(productId: Int, count: Int) {
        // бакенд-логик
        println("Пятерочка продала товар $productId в количестве $count шт.")
        // бузизнес-логик
    }
}

// TODO 0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000

abstract class PersonAbstract(val firstName: String, val lastLastName: String, val age: Int, val weight: Int, val height: Int) {

    abstract fun wakeUp()

    abstract fun startActivity()

    fun sleep() {
        println("Я устал, лягу-ка я спать... фью-фью-фью...")
        TimeUnit.HOURS.sleep(8)
        wakeUp()
    }

    fun washUp() {
        println("Умываем лицо, чистим зубы...")
    }
}

class Student(firstName: String, lastLastName: String, age: Int, weight: Int, height: Int) : PersonAbstract(
    firstName, lastLastName, age, weight, height,
) {
    override fun wakeUp() {
        println("опять в универ идти... аааааааа, пойду умоюсь")
        washUp()
        // ...
    }

    override fun startActivity() {
        println("слушаю препода... фью-фью-фью")
        // Крылов!
        wakeUp()
        println("ой...")
    }
}

class Employee(firstName: String, lastLastName: String, age: Int, weight: Int, height: Int) : PersonAbstract(
    firstName, lastLastName, age, weight, height,
) {
    override fun wakeUp() {
        println("Опять на работу... еще 5 минут полежу")
        sleep()
    }

    override fun startActivity() {
        println("солнце светит, мы работаем")
    }
}

// TODO 0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000

fun main() {
    val unitOfLength = 1
    val mappings = arrayOf(1, -3, 0, 3, 2)
    val value = 193
    val newValue = value * pow(10.0, mappings[unitOfLength - 1].toDouble())
    println("3) $newValue")

    println("Task №1")
    val magnit: AbstractShop = Magnit(8, 22)
    magnit.toOpen()
    magnit.sellProduct(24, 23)
    magnit.toClose()

    println("Task №2")
    val person: PersonAbstract = Student("Arseniy", "undefined", 17, 160, 140)  // большой Арсений
    person.wakeUp()
    println("-----------")
    person.startActivity()
    println("-----------")
    person.sleep()
}