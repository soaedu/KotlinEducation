package syntax.annotations.example_7

// #1 inline function without annotation
// public inline fun <R> run(block: () -> R): R = block()

// #2 inline function with annotation '@InlineOnly'
// @InlineOnly - specifies that this function should not be called directly without inlining
/*
@kotlin.internal.InlineOnly
public inline fun <R> run(block: () -> R): R = block()
*/
