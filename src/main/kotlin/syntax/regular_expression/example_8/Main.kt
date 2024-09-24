package syntax.regular_expression.example_8

/**
 * Regex extension functions in Kotlin.
 */
fun main() {
    val regex = Regex("\\d+")

    // #1
    // This function returns 'true' if the 'Regex' object finds at least one match in
    // the input string.
    val text_1 = "There are 123 apples"

    // #2
    // This function returns 'true' only if the entire input string "123" matches the
    // 'regular expression'.
    val text_2 = "123"

    // #3
    // This function returns the first match of the 'regular expression' in the input
    //	string.
    val text_3 = "I have 123 apples and 456 oranges"
    val matchResult_3 = regex.find(text_3)

    // #4
    // This function returns a sequence of all matches in the input string.
    val matches = regex.findAll(text_3)

    // #5
    // This function replaces every occurrence of the pattern '\\d+' with the word
    // "many".
    val replaceResult_5 = regex.replace(text_3, "many")

    // #6
    // This function replaces only the first occurrence of '\\d+' (which is "123")
    // with "many".
    val replaceResult_6 = regex.replaceFirst(text_3, "many")

    // #7
    // This function splits the input string around matches of the pattern '\\s+',
    // which represents one or more whitespace characters.
    val regex_2 = Regex("\\s+")
    val splitResult_1 = regex_2.split(text_3)

    // #8
    // This function escapes all special characters in the input string, so that they
    // can be used as literals in a 'regex'.
    val escapeRegex = Regex.escape(".+*?^${'$'}()[]{}|")

    // #9
    // This function escapes 'special characters' in a 'replacement string'.
    val replacement = Regex.escapeReplacement("$5")
    val text_9 = "Price: 10"
    val escapeReplacementResult = text_9.replace("10", replacement)

    // #10
    // This function attempts to match the entire input string "123" with the 'regular
    // expression \\d+'.
    val matchEntireResult = regex.matchEntire(text_2)

    println(
        "Show result of using 'regex' extension function:" +
        "\n\tcontainsMatchIn: ${regex.containsMatchIn(text_1)}" +
        "\n\tmatches: ${regex.matches(text_2)}" +
        "\n\tfind: ${matchResult_3?.value}" +
        "\n\tfindAll: ${matches.forEach { match -> println(match.value) }}" +
        "\n\treplace: $replaceResult_5" +
        "\n\treplaceFirst: $replaceResult_6" +
        "\n\tsplit: $splitResult_1" +
        "\n\tescape: $escapeRegex" +
        "\n\tescapeReplacement: $escapeReplacementResult" +
        "\n\tmatchEntire: ${matchEntireResult?.value}"
    )
}
