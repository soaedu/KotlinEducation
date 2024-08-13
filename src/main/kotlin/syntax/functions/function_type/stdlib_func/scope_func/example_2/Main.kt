package syntax.functions.function_type.stdlib_func.example_1.scope_func.example_2

/**
 * Scope function 'also' has definition in the 'standard library' like this
 *
 * public inline fun <T> T.also(block: (T) -> Unit): T {
 *      block(this)
 *      return this
 * }
 *
 * accepts a lambda that is invoked with the receiver being the instance (where 'also' was called on)
 * represents the 'context object' as the lambda parameter
 * returns the 'context object' (receiver)
 *
 * Should be used if:
 *      * need to insert lambda into a call chain to do something “on the side”
 *      * our 'block' does not access its 'receiver' parameter at all
 *      * it does not mutate its 'receiver' parameter
 */
fun main() {
    val title = "The Robots from Planet X3"
    val newTitle = title
        .removePrefix("The ")
        .also { println("also result -> $it") }
        // .also(::println)
        .singleQuoted()
        .uppercase()

    println(
        "\nShow title: " +
        "\n\tsource: $title" +
        "\n\ttransformed: $newTitle"
    )
}

fun String.singleQuoted() = "'$this'"
