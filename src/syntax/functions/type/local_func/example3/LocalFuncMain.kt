package syntax.functions.type.local_func.example3

fun main() {
    println(isValidIdentifier("name"))       // true
    println(isValidIdentifier("_name"))      // true
    println(isValidIdentifier("_12"))        // true
    println(isValidIdentifier(""))           // false
    println(isValidIdentifier("012"))        // false
    println(isValidIdentifier("no$"))        // false
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