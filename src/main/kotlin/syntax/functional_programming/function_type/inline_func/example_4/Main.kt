package syntax.functional_programming.function_type.anonymous_func.inline_func.example_4

fun main() {
    printData()
}

fun printData() {
    println("1")
    println("2")

    val strings = listOf("a", "bc", "def", "", "ghij")
    printUntilEmptyStringIsMet(strings) {
        it.forEach { str ->
            // #1
            // Non-local return
            if (str.isEmpty()) {
                println("return..")
                return
            }

            // #2
            // Local return
            /*if (str.isEmpty()) {
                println("return..")
                return@forEach
            }*/

            println(str)
        }
    }

    println("3")
    println("4")
}

// #1
inline fun printUntilEmptyStringIsMet(list: List<String>, listCheck: (List<String>) -> Unit) {
    listCheck(list)
}

// #1 Output (non-local return)
// 1
// 2
// a
// bc
// def
// return..

// #2 Output (local return)
// 1
// 2
// a
// bc
// def
// return..
// ghij
// 3
// 4
