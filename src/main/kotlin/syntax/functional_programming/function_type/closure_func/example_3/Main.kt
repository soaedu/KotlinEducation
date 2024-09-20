package syntax.functional_programming.function_type.anonymous_func.closure_func.example_3

fun main() {
    // #1
    /*val func = multiply(5)
    val result_1 = func(5)
    val result_2 = func(6)
    println(
        "Print multiply result for:" +
        "\n\t5 * 5: $result_1" +
        "\n\t5 * 6: $result_2"
    )*/

    // #2
    val result_1 = multiply(5)(5)
    val result_2 = multiply(5)(6)
    println(
        "Print multiply result for:" +
        "\n\t5 * 5: $result_1" +
        "\n\t5 * 6: $result_2"
    )
}

// Use 'closure' to calculate multiplication of two numbers
// Parameter 'n' is the variable from the outer function and
// inner lambda uses it when is called outside the 'multiply'
// function, so it is 'closed over' parameter 'n'.
fun multiply(n: Int): (Int) -> Int {
    return { m: Int -> n * m}
}