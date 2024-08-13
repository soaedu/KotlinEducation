package syntax.functions.function_type.inline_func.example_6

fun main() {
    load(
        {
            println("onHalf...")
        },
        {
            println("onEnd...")
        }
    )
}

fun fetch(onHalfLoaded: () -> Unit) {
    // Load
    onHalfLoaded()
    // Load
}

// #1
/*inline fun load(
    onHalfLoad: () -> Unit,
    onEnd: () -> Unit
) {
    // Compilation error:
    //      Illegal usage of 'inline-parameter'...
    fetch(onHalfLoad)
    onEnd()
}*/

// #2
// Using 'noinline' keyword to fix the problem.
inline fun load(
    noinline onHalfLoad: () -> Unit,
    onEnd: () -> Unit
) {
    fetch(onHalfLoad)
    onEnd()
}