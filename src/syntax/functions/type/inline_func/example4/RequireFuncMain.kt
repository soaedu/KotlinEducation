package syntax.functions.type.inline_func.example4

fun main() {
    print("1. ")
    neverEmpty("Test String")

    print("2. ")
    neverEmpty("")
}

fun neverEmpty(str: String) {
    require(str.isNotEmpty()) { "String should not be empty" }
    println(str)
}