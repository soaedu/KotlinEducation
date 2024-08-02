package syntax.control_flow.if_else.example_1

fun main() {
    println(
        "Check values result: " +
        "\n\tvalue #1 is a zero: ${isZero(1)}" +
        "\n\tvalue #2 is a zero: ${isZero(10 - (2*5))}" +
        "\n\tvalue #2 is a zero: ${isZero(0)}"
    )

    println(
        "\nGet max value result:" +
        "\n\tmax value between 5 and 8 is: ${maxValue(5, 8)}" +
        "\n\tmax value between 15 and 8 is: ${maxValue(15, 8)}" +
        "\n\tmax value between 5 and 18 is: ${maxValue(5, 18)}"
    )
}

private fun isZero(value: Int) = if (value == 0) true else false

private fun maxValue(value1: Int, value2: Int) = if (value1 > value2) value1 else value2