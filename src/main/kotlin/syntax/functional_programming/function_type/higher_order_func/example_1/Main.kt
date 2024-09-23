package syntax.functional_programming.function_type.anonymous_func.higher_order_func.example_1

fun main() {
    // Save the 'lambda-expression' in the local variable
    // #1
    // val sum = { x: Int, y: Int -> x + y}
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y}
    println(
        "Sum of two numbers:" +
        "\n\t5 and 10: ${sum(5, 10)}"
    )
    // #2
    // val action = { println("\t42")}
    val action: () -> Unit = { println("\t42")}
    println("\nPrint magic value:")
    action()

    // Add '?' in definition of a variable that can contain function with 'null' result
    // #3
    var canReturnNull: (Int, Int) -> Int? = { x, y -> null }

    // Add '?' in definition of a variable that can contain function or 'null'
    // #4
    var funOrNull: ((Int, Int) -> Int)? = null

    // Add names to parameters of function types
    // #5
    val url = "Http://kotl.in"
    fun performRequest(
        url: String,
        callback: (code: Int, content: String) -> Unit
    ) {
        // ...
    }

    // Parameters names used in definition can be used as names of arguments in 'lambda-expression'
    performRequest(url) {code, content -> /* do something */ }

    // Parameters names even can differ from the definition
    performRequest(url) {code, page -> /* do something */ }
}