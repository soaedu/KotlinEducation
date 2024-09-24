package syntax.regular_expression.example_5

/**
 * Common pitfalls:
 *   1. Forgetting to escape special characters like '.', '*', '+', '?', '(', ')', '\', and others.
 *   2. Misusing quantifiers
 */
fun main() {
    // #1
    // Forgetting to escape special characters
    val regex_1 = Regex("\\.")
    val text_1 = "file.txt"

    // #2
    // Misusing quantifiers
    val regex_2 = Regex("a+")
    val text_2 = "aaa"


    println(
        "Show match result: " +
        "'$text_1' contains '$regex_1': ${regex_1.containsMatchIn(text_1)}" +
        "'$regex_2' matches to '$text_2': ${regex_2.matches(text_2)}"
    )
}
