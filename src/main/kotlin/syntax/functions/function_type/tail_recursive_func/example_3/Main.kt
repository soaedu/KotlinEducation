package syntax.functions.function_type.tail_recursive_func.example_3

fun main() {
    val const = 10
    println(
        "Calculate factorial using:" +
        "\n\trecursive call: ${factRecursive(const)}" +
        "\n\ttail recursive call: ${factTailRecursive(const)}"
    )
}

fun factRecursive(k: Int): Int {
    return if (k == 0) 1
    else k * factRecursive(k - 1)
}

fun factTailRecursive(k: Int): Int {
    tailrec fun factTail(m: Int, n: Int): Int {
        return if (m == 0) n
        else factTail(m - 1, m * n)
    }

    return factTail(k, 1)
}