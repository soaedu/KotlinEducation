package syntax.functions.type.inline_func.example3

fun main() {
    val numberList = listOf(1, 2, 3, 4, 5)
    println("1. transform numberList to " +
            "\n\tstringList and print: ${numberList.flatMap(transform = { listOf(it.toString()) })}" +
            "\n\tdoubleList and print: ${numberList.flatMap(transform = { listOf(it.toDouble()) })}"
    )
}

inline fun <T, R> Iterable<T>.flatMap(transform: (T) -> Iterable<R>): List<R> {
    return flatMapTo(ArrayList<R>(), transform)
}