package syntax.functions.operation.overloading.example_1

/**
 * Operation 'overloading' represents definition of few functions with the identical name
 * but with different parameters.
 */
fun main() {
    println(
        "call method #1: \t${printString("test")}" +
                "\ncall method #2: \t${printString("test", 25)}" +
                "\ncall method #3: \t${printString("test", toUpperCase = true)}" +
                "\ncall method #4: \t${printString("test", number = 33, toUpperCase = true)}"
    )
}

// Five Java methods can be represented by one in Kotlin
fun printString(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
    return (if (toUpperCase) name.toUpperCase() else name) + number
}
