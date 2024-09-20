package syntax.functional_programming.function_type.anonymous_func.higher_order_func.example_2

fun main() {
    // #1
    println(
        "Calculate result of:" +
        "\n\t2 + 3: ${calculate(2, 3) { x, y -> x + y }}" +
        "\n\t2 * 3: ${calculate(2, 3) { x, y -> x * y }}"
    )

    // #2
    val string = "1a2b3c4d"
    println(
        "\nFilter '$string' and show only:" +
        "\n\tletters: ${string.filter { it in 'a'..'z' }}" +
        "\n\tnumbers: ${string.filter { it in '0'..'9' }}"
    )
}

// #1
// Use higher-order function to calculate result with specified arguments and operation
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

// #2
// Use 'functional type' inside the extension function to filter a string.
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()

    for (index in 0 until length) {
        val char = get(index)

        if (predicate(char)) {
            sb.append(char)
        }
    }

    return sb.toString()
}