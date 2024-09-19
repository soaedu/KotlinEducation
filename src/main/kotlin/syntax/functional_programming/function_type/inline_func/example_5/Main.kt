package syntax.functional_programming.function_type.anonymous_func.inline_func.example_5

fun main() {
    // #1
    load {
        print("Done")
    }

    // #2
    // Same after compiler code generation (without 'inline')
    /*load(
        object: SingleAction {
            override fun invoke() {
                println("Done")
            }
        }
    )*/

    // #3
    // Same after compiler code generation (with 'inline')
    // Load something here
    // print("Done")
}

// #1
/*fun load(onEnd: () -> Unit) {
    // Load something here
    onEnd()
}*/

// #2
/*interface SingleAction {
    operator fun invoke()
}
fun load(onEnd: SingleAction) {
    // Load something here
    onEnd()
}*/

// #3
inline fun load(onEnd: () -> Unit) {
    // Load something here
    onEnd()
}
