package syntax.functions.function_type.single_expression_func.example_2

fun main() {
    println(
        "Show result of multiplication:" +
        "\n\t2 on 5: ${multiplyOn(2, 5)}" +
        "\n\t5 on 5: ${multiplyOn(5, 5)}"
    )
}

// Use 'single expression function' to get multiplication result.
fun multiplyOn(value: Int, multiplier: Int) = value * multiplier