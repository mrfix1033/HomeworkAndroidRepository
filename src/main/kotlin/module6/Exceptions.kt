package module6

fun main() {
    val list: Array<PersonExceptions?> = Array(10) { null }
    while (true) {
        print("Выберите действие: 1 - добавить/заменить человека; 2 - удалить человека: ")
        try {
            when (readln()) {
                "1" -> createList(list)
                "2" -> removePerson(list)
                else -> continue
            }
        } catch (e: MyException) {
            e.printDescription()
        } catch (e: Exception) {
            println("Необработанная ошибка: ${e.message}")
        } finally {
            println("Повтор цикла")
        }
        println(list.contentToString())
    }
}

data class PersonExceptions(val name: String, val surname: String)

fun createList(list: Array<PersonExceptions?>) {
    val name = Utils.input("Введите имя: ")
    val surname = Utils.input("Введите фамилию: ")
    val person = PersonExceptions(name, surname)
    val intIndex = Utils.toIntOrThrow(Utils.input("Введите индекс, куда поместить человека: "))
    Utils.setElementByIndexOrThrow(list, person, intIndex)
}

fun removePerson(list: Array<PersonExceptions?>) {
    val index = Utils.toIntOrThrow(Utils.input("Введите индекс: "))
    Utils.setElementByIndexOrThrow(list, null, index)
}

class Utils {
    companion object {
        fun toIntOrThrow(string: String): Int {
            if (!string.all(Char::isDigit)) throw NumberFormatExceptionWrapper("\"$string\" не является числом")
            return string.toInt()
        }

        fun <T> setElementByIndexOrThrow(list: Array<T>, element: T, index: Int) {
            if (index < 0 || index >= list.size) throw IndexOutOfBound("Индекс $index за границей массива размером ${list.size}")
            list[index] = element
        }

        fun input(askString: String): String {
            println(askString)
            return readln()
        }
    }
}

open class MyException(val description: String) : Exception() {
    fun printDescription() = println(description)
}

class NumberFormatExceptionWrapper(description: String) : MyException(description)

class IndexOutOfBound(description: String) : MyException(description)