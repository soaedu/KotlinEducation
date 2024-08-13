package syntax.functions.function_type.top_level_func.example_1

data class Deposit(
    val bank_id: String,
    val deposit_id: String,
    var balance: Double = 0.0
) {
    fun putMoney(amount: Double) {
        val rate = 17.85
        balance += multValues(amount, rate)
    }
}
