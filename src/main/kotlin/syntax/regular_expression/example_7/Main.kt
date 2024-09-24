package syntax.regular_expression.example_7

/**
 * Split a string according to a 'regular expression'.
 */
fun main() {
    val regex = """\W+""".toRegex()
    val beautiful = "Roses are red, Violets are blue"

    println(
        "Show result after splitting string" +
        "\n\twithout limit: ${regex.split(beautiful)}" +
        "\n\twith limit: ${regex.split(beautiful, 4)}"
    )
}
