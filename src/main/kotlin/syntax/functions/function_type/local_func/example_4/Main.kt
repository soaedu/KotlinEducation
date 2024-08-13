package syntax.functions.function_type.local_func.example_4

fun main() {
    val identifiers = listOf("name", "_name", "_12", "", "012", "no$")
    println(
        "Check and print result for identifier:"
    )

    for (item in identifiers) {
        println(
            "$item: ${isValidIdentifier(item)}"
        )
    }
}

fun isValidIdentifier(s: String): Boolean {
    fun isValidCharacter(ch: Char) =
        // ch == '_' || ch in '0'..'9' || ch in 'a'..'z' || ch in 'A'..'Z'
        ch == '_' || ch.isLetterOrDigit()

    // if (s.isEmpty() || s[0] in '0'..'9') return false
    if (s.isEmpty() || s[0].isDigit()) return false
    for (ch in s) {
        if (!isValidCharacter(ch)) return false
    }
    return true
}