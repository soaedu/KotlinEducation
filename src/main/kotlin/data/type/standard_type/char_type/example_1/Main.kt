package data.type.standard_type.char_type.example_1

fun main() {
    // #1
    // Declare a 'char' variable and set initialize it
    // val firstLetterOfAlphabet: Char = 'A'
    val firstLetterOfAlphabet: Char
    firstLetterOfAlphabet = 'A'

    println("Show the value of:" +
        "\n\tfirstLetterOfAlphabet: $firstLetterOfAlphabet"
    )

    // #2
    // Use 'ASCII value' to display a 'character'
    /*val asciiValueToChar: Char = 66     // error: The integer literal does not conform to the expected type Char
    println("\nShow the value of:" +
            "'66' as character (ASCII value): $asciiValueToChar"
    )*/

    // #3
    // Use 'Unicode number' to represent 'unicode character'
    val unicodeNumberToCharacter: Char = '\u1234'
    println("\nShow the value of:" +
        "\n\t'\\u1234' as character (unicode number): $unicodeNumberToCharacter")
}
