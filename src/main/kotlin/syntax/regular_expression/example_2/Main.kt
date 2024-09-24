package syntax.regular_expression.example_2

/**
 * Matching options are enumerated in the 'RegexOption' class:
 * 	IGNORE_CASE 	– enables case-insensitive matching.
 * 	MULTILINE 		– changes the meaning of '^' and '$'.
 * 	LITERAL 		– causes metacharacters or escape sequences in the pattern to be given
 * 	                    no special meaning.
 * 	UNIX_LINES 		– in this mode, only the '\n' is recognized as a line terminator.
 * 	COMMENTS 		– permits whitespace and comments in the pattern.
 * 	DOT_MATCHES_ALL – causes the dot to match any character, including a line terminator.
 * 	CANON_EQ 		– enables equivalence by canonical decomposition.
 */
fun main() {
    // #1
    val regex_1 = Regex("a(b|c)+d?", RegexOption.CANON_EQ)
    val regex_2 = Regex(
        "a(b|c)+d?",
        setOf(RegexOption.DOT_MATCHES_ALL, RegexOption.COMMENTS)
    )

    // #2
    val regex_3 = "a(b|c)+d?".toRegex(RegexOption.MULTILINE)
    val regex_4 = "a(b|c)+d?".toRegex(
        setOf(RegexOption.IGNORE_CASE, RegexOption.COMMENTS, RegexOption.UNIX_LINES)
    )

    println(
        "Show result of creating: " +
        "\n\tregex #1 (Regex constructor + single 'Regex' option): $regex_1" +
        "\n\tregex #2 (Regex constructor + set of 'Regex' options): $regex_2" +
        "\n\tregex #3 (toRegex() function + single 'Regex' option): $regex_3" +
        "\n\tregex #4 (toRegex() function + set of 'Regex' options): $regex_4"
    )
}
