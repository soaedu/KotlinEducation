package syntax.functions.function_type.operator_func.example_5

fun main() {
    val number_1 = BingoNumber(
        "Key to the Door",
        21
    )
    val number_2 = BingoNumber(
        "Jump to jive",
        21
    )

    println(
        "Compare values using different operators and single operator function for it:" +
        "\n\t${number_1.age} < ${number_2.age}: ${number_1 < number_2}" +
        "\n\t${number_1.age} <= ${number_2.age}: ${number_1 <= number_2}" +
        "\n\t${number_1.age} > ${number_2.age}: ${number_1 > number_2}" +
        "\n\t${number_1.age} >= ${number_2.age}: ${number_1 >= number_2}"
    )
}

class BingoNumber(
    val name: String,
    val age: Int
) {
    operator fun compareTo(other: BingoNumber): Int {
        return when {
            age < other.age -> -1
            age > other.age -> 1
            else -> 0
        }
    }
}