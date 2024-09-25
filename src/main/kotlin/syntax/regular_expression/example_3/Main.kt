package syntax.regular_expression.example_3

/**
 * Basic 'Regex' syntax.
 *
 * Metacharacters:
 *  .	- Matches any character except newline.
 * 	^	- Matches the beginning of the string.
 * 	$	- Matches the end of the string.
 * 	*	- Matches 0 or more occurrences of the preceding element.
 * 	+	- Matches 1 or more occurrences of the preceding element.
 * 	?	- Matches 0 or 1 occurrence of the preceding element.
 * 	[]	- Defines a character class.
 */
fun main() {
    // #1
    // Use 'literal characters'
    val regex_1 = Regex("hello")
    val text_1 = "hello world"

    // #2
    // Use '^' to check match
    val regex_2 = Regex("^hello")
    val text_2 = "world hello"

    // #3
    // Use '$' to check match
    val regex_3 = Regex("hello$")

    // #4
    // Use '.' to check match
    val regex_4 = Regex(".*")
    val text_4_1 = "This product price is $15"
    val text_4_2 = "\nThis product price is $15"

    // #5
    // Use '*' to find 0 or more matches
    val regex_5 = Regex("a*")
    val text_5_1 = ""
    val text_5_2 = "a"
    val text_5_3 = "aaa"

    // #6
    // Use '+' to find 1 or more matches
    val regex_6_1 = Regex("a+")
    val regex_6_2 = Regex("[a-z]+")
    val text_6_1 = "abc123"

    // #7
    // Use '?' to find 0 or 1 matches
    val regex_7 = Regex("a?")

    // #8
    // Use '{n}' to find exactly 'n' matches
    val regex_8 = Regex("a{3}")

    // #9
    // Use '{n,}' to find at least 'n' matches
    val regex_9 = Regex("a{1,}")

    // #10
    // Use '{n,m}' to find between 'n' and 'm' matches
    val regex_10 = Regex("a{1,3}")

    println(
        "Show result of matching: " +
                "\n\t'$text_1' contains '$regex_1' (literal characters): ${regex_1.containsMatchIn(text_1)}" +
                "\n\t-----------------------------------------------------" +
                "\n\t'$regex_2' match found in '$text_1': ${regex_2.containsMatchIn(text_1)}" +
                "\n\t'$regex_2' match found in '$text_2': ${regex_2.containsMatchIn(text_2)}" +
                "\n\t-----------------------------------------------------" +
                "\n\t'$regex_3' match found in '$text_1': ${regex_3.containsMatchIn(text_1)}" +
                "\n\t'$regex_3' match found in '$text_2': ${regex_3.containsMatchIn(text_2)}" +
                "\n\t-----------------------------------------------------" +
                "\n\t'$regex_4' match to '$text_4_1': ${regex_4.matches(text_4_1)}" +
                "\n\t'$regex_4' match to '$text_4_2': ${regex_4.matches(text_4_2)}" +
                "\n\t-----------------------------------------------------" +
                "\n\t\"\" matches to '$regex_5': ${regex_5.matches(text_5_1)}" +
                "\n\t'$text_5_2' matches to '$regex_5': ${regex_5.matches(text_5_2)}" +
                "\n\t'$text_5_3' matches to '$regex_5': ${regex_5.matches(text_5_3)}" +
                "\n\t-----------------------------------------------------" +
                "\n\t\"\" matches to '$regex_6_1': ${regex_6_1.matches(text_5_1)}" +
                "\n\t'$text_5_2' matches to '$regex_6_1': ${regex_6_1.matches(text_5_2)}" +
                "\n\t'$text_5_3' matches to '$regex_6_1': ${regex_6_1.matches(text_5_3)}" +
                "\n\t'$regex_6_2' find in '$text_6_1': ${regex_6_2.find(text_6_1)?.value}" +
                "\n\t-----------------------------------------------------" +
                "\n\t\"\" matches to '$regex_7': ${regex_7.matches(text_5_1)}" +
                "\n\t'$text_5_2' matches to '$regex_7': ${regex_7.matches(text_5_2)}" +
                "\n\t'$text_5_3' matches to '$regex_7': ${regex_7.matches(text_5_3)}" +
                "\n\t-----------------------------------------------------" +
                "\n\t\"\" matches to '$regex_8': ${regex_8.matches(text_5_1)}" +
                "\n\t'$text_5_2' matches to '$regex_8': ${regex_8.matches(text_5_2)}" +
                "\n\t'$text_5_3' matches to '$regex_8': ${regex_8.matches(text_5_3)}"+
                "\n\t-----------------------------------------------------" +
                "\n\t\"\" matches to '$regex_9': ${regex_9.matches(text_5_1)}" +
                "\n\t'$text_5_2' matches to '$regex_9': ${regex_9.matches(text_5_2)}" +
                "\n\t'$text_5_3' matches to '$regex_9': ${regex_9.matches(text_5_3)}" +
                "\n\t-----------------------------------------------------" +
                "\n\t\"\" matches to '$regex_10': ${regex_10.matches(text_5_1)}" +
                "\n\t'$text_5_2' matches to '$regex_10': ${regex_10.matches(text_5_2)}" +
                "\n\t'$text_5_3' matches to '$regex_10': ${regex_10.matches(text_5_3)}"
    )
}
