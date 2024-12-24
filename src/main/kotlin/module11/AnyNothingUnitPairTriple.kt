package module11

import java.util.*

fun main() {
    fun check(staples: String): Boolean {
        val st = Stack<Char>()
        var ok = true
        for (c in staples) {
            if (c in "{([")
                st.push(c)
            else if (c == ')' && st.last() == '(' || c == ']' && st.last() == '[' || c == '}' && st.last() == '{')
                st.pop()
            else {
                ok = false
                break
            }
        }
        return ok
    }
    println(check("{([])}"))
    println(check("{{[])}"))
    println(check("{([))}"))
    val array = intArrayOf(1, 2, 3)

    fun <T> gen(array: List<T>, len: Int, handleFun: (List<T>) -> Any) {
        val list = mutableListOf<T>()
        val used = MutableList(array.size) {false}
        fun rec() {
            if (list.size == len) {
                handleFun(list)
                return
            }
            for ((i, e) in array.withIndex()) {
                if (used[i]) continue
                list.add(e)
                used[i] = true
                rec()
                used[i] = false
                list.removeLast()
            }
        }
        rec()
    }
    gen(array.toList(), array.size) { println(it)}
}