package syntax.functions.type.inline_func.example3

fun main() {
    println("\nResult: ${getResult()}")
}

fun getResult(): Double {
    return bar(Math.PI) { angle ->
        if (angle == 0.0) return Double.NaN

        return Math.sin(angle) + Math.cos(angle)
    }
}

inline fun bar(angle: Double, f: (Double) -> Double): Double {
    return f(angle)
}

// if this function is "inline" it works good
fun youShallNotPrintlnAfterEmptyStr(list: List<String>) {
    list.forEach { str ->
        if (str.isEmpty()) return // Non-local return
        println(str)
    }
}

// #1
// will not compile - Possible non-local return
/*inline fun <T> Iterable<T>.forEachAsync(action: (T) -> Unit): Unit {
    for (element in this)
        GlobalThreadPool.submit(Callable {action(element)})
        // Possible non-local return
} */

// #2
// will compile, because we used "crossinline"
/*inline fun <T> Iterable<T>.forEachAsync(crossinline action: (T) -> Unit): Unit {
     for (element in this)
        GlobalThreadPool.submit(Callable {action(element)})
}*/
