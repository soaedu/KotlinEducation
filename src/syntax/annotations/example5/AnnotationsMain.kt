package syntax.annotations.example5

fun main() { }

/**
 * @InlineOnly - specifies that this function should not be called directly without inlining
 */
//@kotlin.internal.InlineOnly
//public inline fun <R> run(block: () -> R): R = block()