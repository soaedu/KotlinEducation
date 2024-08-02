package syntax.control_flow.loop.for_loop.example_3

fun main() {
    // #1
    // The 'for' loop is used to iterate over a string and print its chars.
    // On each iteration we get an index of the element in range '0..string.lastIndex', use it to
    // get char and then increase its value by 1.
    val s = "abc"
    println("#1 Iterate over 'abc' and increase each char by 1: ")
    for (i in 0..s.lastIndex) {
        print(s[i] + 1)
    }

    println("\n\n#2 Iterate over 'Jnskhm' and increase each char by 1: ")
    // #2
    // The 'for' loop is used to iterate over a string directly.
    // On each iteration we get a char that is increased then by 1.
    for (ch in "Jnskhm ") {
        print(ch + 1)
    }

    println("\n\n#3 Iterate over specified string and check if it contains specified character: ")
    // #3
    // The 'for' loop is used to iterate over a string and check if it contains a specified character
    val stringToCheck = "kotlin"
    val character_1 = 'a'
    val character_2 = 't'
    println(
        "String: $stringToCheck " +
        "\ncharacter: $character_1 " +
        "\n\tresult: ${hasChar(stringToCheck, character_1)}"
    )
    println(
        "\nString: $stringToCheck " +
        "\ncharacter: $character_2 " +
        "\n\tresult: ${hasChar(stringToCheck, character_2)}"
    )
}

fun hasChar(s: String, ch: Char): Boolean {
    for (c in s) {
        if (c == ch) return true
    }
    return false
}