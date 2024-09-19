package syntax.functional_programming.function_type.anonymous_func.closure_func.example_2

fun main() {
    // #1
    val ints_1 = listOf(-1, 0, 1, 2, 3, 4, 5)
    val ints_2 = listOf(5, 10, 15, 20, 30, 40, 50)
    println(
        "Result of checking if the list contains negative value:" +
        "\n\t$ints_1:\t\t\t${containsNegative(ints_1)}" +
        "\n\t$ints_2:\t${containsNegative(ints_2)}"
    )

    // #2
    println(
        "\nResult of calling function with closure inside:"
    )
    val fn = outer()
    fn()
    fn()
    fn()
    fn()
    fn()
}

// #1
// Use 'closure' to check if specified list contains
// negative value.
// 'Closure' has access to local variable and can mutate it.
fun containsNegative(list: List<Int>): Boolean {
    var containsNegative = false

    list.forEach {
        if (it < 0) containsNegative = true
    }

    return containsNegative
}

// #2
/*
fun outer(): () -> Unit {
    var counter = 0
    var n = 5

    fun inner() {
        n++
        println("\t#${++counter} n: $n")
    }

    return ::inner
}*/
fun outer(): () -> Unit {
    var n = 5

    // Use 'anonymous' function
    return {
        n++
        println(n)
    }
}