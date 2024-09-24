package syntax.regular_expression.example_1

fun main() {
    // #1
    // Create 'regular expression' using 'Regex' constructor.
    val regex_1 = Regex("pattern")

    // #2
    // Create 'regular expression' using 'toRegex()' extension function,
    val regex_2 = "pattern".toRegex()

    // #3
    // Create 'regular expression' using static factory method
    val regex_3 = Regex.fromLiteral("pattern")

    println(
        "Show result of creating: " +
        "\n\tregex #1 (Regex constructor): $regex_1" +
        "\n\tregex #2 (toRegex() function): $regex_2" +
        "\n\tregex #3 (static factory method): $regex_3"
    )
}
