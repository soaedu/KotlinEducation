package syntax.functions.function_type.static_func.example_2

fun main() {
    val word = "Hello"
    println(
        "Show the first letter of the '$word': ${showFirstCharacter(word)}"
    )
}

// Use 'static method' declared as a top-level or 'package-level' function.
fun showFirstCharacter(input:String): Char {
    if (input.isEmpty()) throw IllegalArgumentException()
    return input.first()
}