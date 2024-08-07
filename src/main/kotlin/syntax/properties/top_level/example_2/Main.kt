package syntax.properties.top_level.example_2

import java.lang.StringBuilder

fun main() {
    // #1
    val str = "Kotlin"
    println("\"$str\" last char is: ${str.lastChar}")

    // #2
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println("\nChanged string builder value is: $sb")
}

// #1
// The immutable top-level property is defined as an extension to the String type.
val String.lastChar: Char
    get() = get(length - 1)

// #2
// The mutable top-level property is defined as an extension to the StringBuilder type.
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        setCharAt(length - 1, value)
    }