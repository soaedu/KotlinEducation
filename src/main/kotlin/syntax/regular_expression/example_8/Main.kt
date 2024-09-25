package syntax.regular_expression.example_8

/**
 * Regex extension functions in Kotlin.
 */
fun main() {
    val regex = Regex("\\d+")

    // #1
    // Function 'containsMatchIn' returns 'true' if the 'Regex' object finds at least one match in the input string.
    val text_1 = "There are 123 apples"
    val result_1 = regex.containsMatchIn(text_1)

    // #2
    // Function 'matches' returns 'true' only if the entire input string "123" matches the 'regular expression'.
    val text_2 = "123"
    val result_2 = regex.matches(text_2)

    // #3
    // Function 'find' returns the first match of the 'regular expression' in the input string.
    val text_3 = "I have 123 apples and 456 oranges"
    val result_3 = regex.find(text_3)

    // #4
    // Function 'findAll' returns a sequence of all matches in the input string.
    val result_4 = regex.findAll(text_3).map { match -> match.value }.toList()

    // #5
    // Function 'replace' replaces every occurrence of the pattern '\\d+' with the word "many".
    val replaceResult_5 = regex.replace(text_3, "many")

    // #6
    // Function 'replaceFirst' replaces only the first occurrence of '\\d+' (which is "123") with "many".
    val replaceResult_6 = regex.replaceFirst(text_3, "many")

    // #7
    // Function 'split' splits the input string around matches of the pattern '\\s+', which represents
    // one or more whitespace characters.
    val regex_2 = Regex("\\s+")
    val splitResult_1 = regex_2.split(text_3)

    // #8
    // Function 'escape' escapes all special characters in the input string, so that they can be used
    // as literals in a 'regex'.
    val escapeRegex = Regex.escape(".+*?^${'$'}()[]{}|")

    // #9
    // Function 'escapeReplacement' escapes 'special characters' in a 'replacement string'.
    val replacement = Regex.escapeReplacement("$5")
    val text_9 = "Price: 10"
    val escapeReplacementResult = text_9.replace("10", replacement)

    // #10
    // Function 'matchEntire' attempts to match the entire input string "123" with the 'regular expression \\d+'.
    val matchEntireResult = regex.matchEntire(text_2)

    println(
        "Show result of using 'regex' extension function:" +
        "\n\tcontainsMatchIn: $result_1" +
        "\n\tmatches: $result_2" +
        "\n\tfind: ${result_3?.value}" +
        "\n\tfindAll: $result_4" +
        "\n\treplace: $replaceResult_5" +
        "\n\treplaceFirst: $replaceResult_6" +
        "\n\tsplit: $splitResult_1" +
        "\n\tescape: $escapeRegex" +
        "\n\tescapeReplacement: $escapeReplacementResult" +
        "\n\tmatchEntire: ${matchEntireResult?.value}"
    )
}
