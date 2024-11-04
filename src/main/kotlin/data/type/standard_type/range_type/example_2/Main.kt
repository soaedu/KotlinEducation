package data.type.standard_type.range_type.example_2

fun main() {
    // #1
    val targetValue_1 = 10
    val targetValue_2 = 2
    val rangeOfNumber = IntRange(0, targetValue_1)
    val result_1 = targetValue_1 in rangeOfNumber
    val result_2 = targetValue_1 !in rangeOfNumber
    val result_3 = rangeOfNumber.reversed().toList()
    val result_4 = (rangeOfNumber step targetValue_2).toList()
    val result_5 = rangeOfNumber.sum()
    val result_6 = (0 until targetValue_1 step targetValue_2).toList()

    println(
        "Show result of function:" +
        "\n\t'in': $result_1" +
        "\n\t'!in': $result_2" +
        "\n\t'reversed': $result_3" +
        "\n\t'step' with value '$targetValue_2': $result_4" +
        "\n\t'sum': $result_5" +
        "\n\t'until' with step '$targetValue_2': $result_6"
    )
}
