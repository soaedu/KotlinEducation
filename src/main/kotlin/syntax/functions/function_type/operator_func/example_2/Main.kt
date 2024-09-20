package syntax.functions.function_type.operator_func.example_2

fun main() {
    val ints = arrayOf(1,2,3,4)

    println(
        "Use operators to get result of the check:" +
        "\n\tarray has value '3' (use 'in'): ${3 in ints}" +
        "\n\tarray has value '3' (use 'contains'): ${ints.contains(3)}" +
        "\n\tarray has no value '5' (use '!in'): ${5 !in ints}" +
        "\n\tarray has no value '5' (use '!contains'): ${!ints.contains(5)}"
    )
}