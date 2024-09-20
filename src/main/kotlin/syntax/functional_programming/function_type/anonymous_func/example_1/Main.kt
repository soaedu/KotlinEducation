package syntax.functional_programming.function_type.anonymous_func.example_1

fun main() {
    // #1
    // 'Higher order' function is used with 'function literal'.
    // Here we can't specify return type for '.
    val valueGreaterThanOne = listOf(1, 2, 3).filter { it > 1 }
    println(
        "\nHigher order function filter result: $valueGreaterThanOne"
    )

    // #2
    // 'Anonymous' function is used instead of 'function literal'.
    // Here we can specify return type as 'List<Int>' for 'eventIntValues' variable.
    val intValues = listOf(1, 2, 3)
    val evenIntValues_1 = intValues.filter(fun(k: Int) = k % 2 == 0)
    println("\nAnonymous function instead of 'function literal' filter result: $evenIntValues_1")

    // #3
    // 'Anonymous' function is used and parameter type is omitted.
    val evenIntValues_2 = intValues.filter(fun(k) = k % 2 == 0)
    println("\nAnonymous function and parameter type is omitted filter result: $evenIntValues_2")
}