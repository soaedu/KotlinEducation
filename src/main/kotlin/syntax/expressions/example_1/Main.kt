package syntax.expressions.example_1

import java.io.IOException
import java.util.*

fun main() {
    // #1
    println(
        "Check if zero for value: " +
        "\n\t'3': ${isZero(3)}" +
        "\n\t'0': ${isZero(0)}"
    )

    // #2
    // The 'expression' here is: "hello".startsWith('h')
    // It evaluates to a value.
    val result = "hello".startsWith('h')
    println("\nCheck if 'hello' starts with 'h': $result")

    // #3
    // The 'expression' is used to perform file read and return the boolean
    // result if that can be done or not.
    val readResult = try {
        readFile()
        true
    } catch (e: IOException) {
        false
    }
    println("\nRead file and inform if it's done: $readResult")
}

// #1
// The 'expression' is used to check if specified value is zero and return a boolean value.
fun isZero(x: Int) = if (x == 0) true else false

// #3
fun readFile() {
    // Do reading
}
