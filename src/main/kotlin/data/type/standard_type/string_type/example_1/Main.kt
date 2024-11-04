package data.type.standard_type.string_type.example_1

fun main() {
    // #1
    // Use "" (double quotes) to create a string.
    val string_1 = "Sam"

    // #2
    // Use "" (double quotes) and + (concatenation) to create a string
    val string_2 = "hello " + string_1

    // #3
    // Use "" (double quotes) and $ (dollar sign) to create a string
    val string_3 = "hello $string_1"

    // #4
    // Use "" (double quotes) and '${}' (expression) to create a string
    val string_4 = "hello $string_1. Your name has ${string_1.length} characters."

    // #5
    // Use \ (backslash) to create an 'escaped string'
    val string_5 = "\n\t\thello $string_1.\n\t\tYour name has ${string_1.length} characters."

    // #6
    // Use """ (triple quotes) to create a 'raw string'
    val string_6 = """
        |        hello $string_1.
        |        Your name has ${string_1.length} characters.
    """.trimMargin()

    println(
        "Show result of creating a string with:" +
        "\n\t\"\" (double quotes): $string_1" +
        "\n\t\"\" (double quotes) and + (concatenation): $string_2" +
        "\n\t\"\" (double quotes) and $ (dollar sign): $string_3" +
        "\n\t\"\" (double quotes) and \${} (expression): $string_4" +
        "\n\t\\ (backslash): $string_5" +
        "\n\t\"\"\" (triple quotes): \n$string_6"
    )
}
