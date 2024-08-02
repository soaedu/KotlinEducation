package syntax.control_flow.if_else.example_2

fun main() {
    println(
        "Check value and get result:" +
        "\n\tvalue #1: ${checkAndGetMessage(2)}" +
        "\n\tvalue #2: ${checkAndGetMessage(0)}" +
        "\n\tvalue #3: ${checkAndGetMessage(-15)}"
    )
}

fun checkAndGetMessage(value: Int): String {
    return if (value > 0) {
        "It's positive"
    } else if (value == 0) {
        "It's zero"
    } else {
        "It's negative"
    }
}