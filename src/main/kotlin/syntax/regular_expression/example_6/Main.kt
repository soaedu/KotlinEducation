package syntax.regular_expression.example_6

/**
 * Replacing matching substrings with other strings
 */
fun main() {
    val regex = """(red|green|blue)""".toRegex()
    val beautiful = "Roses are red, Violets are blue"

    // #1
    // Replacing all occurrences of a matching String
    val grim = regex.replace(beautiful, "dark")

    // #2
    // Replacing only the first occurrence
    val shiny = regex.replaceFirst(beautiful, "rainbow")

    println(
        "Show result after replacing:" +
        "\n\tall occurences: $grim" +
        "\n\tonly the first occurence: $shiny"
    )
}
