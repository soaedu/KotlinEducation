package syntax.functions.function_type.inline_func.example_1

fun main() {
    someHighOrderFunction {
        println(it)
    }
}

// #1
// Call of this function in bytecode will be like follow:
//      NEW syntax/functions/function_type/inline_func/example_1/MainKt$main$1
// each call will create a new instance of the 'higher-order' function and memory allocation.
/*fun someHighOrderFunction(someLambda: (String) -> Unit) {
    someLambda("Result_Text")
}*/

// #2
// Call of this function in bytecode will be like follow:
//      syntax/functions/function_type/inline_func/example_1/MainKt
// without creating new instance of the 'higher-order' function and memory allocation.
inline fun someHighOrderFunction(someLambda: (String) -> Unit) {
    someLambda("Result_Text")
}
