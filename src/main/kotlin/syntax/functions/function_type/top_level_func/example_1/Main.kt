package syntax.functions.function_type.top_level_func.example_1

fun main() {
    val deposit = Deposit("12345", "3265").also{
        it.putMoney(150.0)
    }
    println(
        "Show the result of: " +
        "\n\t5 + 6: ${sumValues(5.0, 6.0)}" +
        "\n\t5 * 6: ${multValues(5.0, 6.0)}" +
        "\n\tput 150$: ${deposit.balance}"
    )
}

// Use 'top-level function' to calculate sum of two integers.
fun sumValues(num_1: Double, num_2: Double) = num_1 + num_2

fun multValues(num_1: Double, num_2: Double): Double = num_1 * num_2
