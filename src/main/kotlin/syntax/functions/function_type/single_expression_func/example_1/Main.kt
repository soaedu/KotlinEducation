package syntax.functions.function_type.single_expression_func.example_1

fun main() {
    println(
        "Show result of:" +
        "\n\tsquare calculation: ${square(25)}" +
        "\n\tconcatenation: ${concat("Hello", ", wor")}"
    )
}

// #1
// Use 'single expression function' to calculate square.
fun square(k: Int) = k * k

// #2
// Use 'single expression function' to get concatenated string.
fun concat(str_1: String, str_2: String) = str_1 + str_2