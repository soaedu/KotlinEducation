package syntax.functions.function_type.tail_recursive_func.example_1

fun main() {
    val const = 500

    print(
        "Get fibonacci sequence of the value $const for" +
        "\n\tfibonacci (recursive call): ${fibRecursive(const)}" +
        "\n\tfibonacci (tail recursive call): ${fibTailRecursive(const)}"
    )
}

// #1
// Use 'recursive' call
// If function is called with a large number, then the number of recursive calls required
// before we get to the base cases would imply that we'd run out of stack space, leading to
// the famous 'stack overflow' error.
fun fibRecursive(k: Int): Int = when (k) {
    0 -> 1
    1 -> 1
    else -> fibRecursive(k - 1) + fibRecursive(k - 2)
}

// #2
// Use 'tail recursive' call
// It uses technique when it does not need other variables for further operations,
// it could simply return the value from the recursive call.
// It allows us to write efficient recursive algorithms that would otherwise result in 4
// 'stack overflow' errors.
fun fibTailRecursive(k: Int): Int {
    tailrec fun fibTail(m: Int): Int = when {
        (m == 0 || m == 1) -> 1
        (m < 0) -> 0
        else -> fibTail(m-1) + fibTail(m-2)
    }

    return fibTail(k)
}
