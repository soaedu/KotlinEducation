package syntax.regular_expression.example_4

/**
 * Advanced 'Regex' syntax.
 *
 * Set of characters to use for match (character classes):
 *  [a-z]	- Matches any lowercase letter.
 * 	[A-Z]	- Matches any uppercase letter.
 * 	[0-9]	- Matches any digit.
 * 	\\d		- Matches any digit (same as [0-9]).
 * 	\\D		- Matches any non-digit.
 * 	\\w		- Matches any word character (alphanumeric plus underscore).
 * 	\\W		- Matches any non-word character.
 */
fun main() {
    // #1
    // Use 'character classes'
    val regex_1 = Regex("\\d{3}-\\d{2}-\\d{4}")
    val text_1 = "123-45-6789"
    println(
        "Show result of matching: " +
        "\n\t'$regex_1' matches with '$text_1' (character classes): ${regex_1.matches(text_1)}"
    )

    // #2
    // Use 'groups and capturing' to create capturing groups.
    val regex_2 = """a([bc]+)d?""".toRegex()
    val matchResult_2 = regex_2.find("abcb abbd")
    println(
        "Show matching info: " +
        "\n\tmatched substrings: ${matchResult_2?.groupValues}" +
        "\n\tfirst match string: ${matchResult_2?.value}" +
        "\n\trange of indices (what portion of the input was matched): ${matchResult_2?.range}" +
        "\n\tentire matched string (before first '('): ${matchResult_2?.groups?.get(0)?.value}" +
        "\n\tgroups in the 'regular expression' (delimited by parentheses): ${matchResult_2?.groups?.get(1)?.value}"
    )

    // #3
    // Destructuring 'MatchResult' instances in an assignment statement
    val regex_3 = """([\w\s]+) is (\d+) years old""".toRegex()
    val matchResult_3 = regex_3.find("Mickey Mouse is 95 years old")!!
    val (name_3, age_3) = matchResult_3.destructured

    println(
        "Show match result destructuring:" +
        "\n\tname: $name_3" +
        "\n\tage: $age_3"
    )

    // #4
    // Capture groups by name
    val regex_4 = """(?<name>[\w\s]+) is (?<age>\d+) years old""".toRegex()
    val matchResult_4 = regex_4.find("Mickey Mouse is 95 years old")!!

    val age_4 = matchResult_4.groups["age"]?.value
    val name_4 = matchResult_4.groups["name"]?.value

    println(
        "Show groups captured by name:" +
        "\n\tname: $name_4" +
        "\n\tage: $age_4"
    )
}
