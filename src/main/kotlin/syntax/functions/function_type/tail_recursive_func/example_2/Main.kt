package syntax.functions.function_type.tail_recursive_func.example_2

val eps = Math.E - 10

fun main() {
    val const = 1.0
    println(
        "Calculate factorial of the $const:" +
        "\n\ttraditional  call: ${findFixPoint_1()}" +
        "\n\ttail recursive call: ${findFixPoint_2(const)}"
    )
}

// #1
// Use traditional approach to calculate the fix point of cosine.
private fun findFixPoint_1(): Double {
    var x = 1.0
    while(true) {
        val y = Math.cos(x)
        if (Math.abs(x - y) < eps) return x
        x = Math.cos(x)
    }
}

// #2
// Use 'tail recursive' call to calculate the fix point of cosine.
tailrec fun findFixPoint_2(x: Double = 1.0): Double =
    if (Math.abs(x - Math.cos(x)) < eps) x
    else findFixPoint_2(Math.cos(x))

