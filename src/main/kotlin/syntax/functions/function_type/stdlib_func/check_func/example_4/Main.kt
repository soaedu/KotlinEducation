package syntax.functions.function_type.stdlib_func.check_func.example_4

fun main() {
    val deposit = Deposit()
    println(
        "Get cash from the deposit:" +
        "\n\toperation #1 result: ${deposit.getCash(2000)}" +
        "\n\toperation #3 result: ${deposit.getCash(1000)}" +
        "\n\toperation #4 result: ${deposit.getCash(800)}"
    )
}

class Deposit(val bankId: String = "some_bank_id") {
    private var balance = 1500
    private val dayLimit = 1000
    fun getCash(amount: Int): Int {
        // Error:
        //      Exception in thread "main" java.lang.AssertionError: Limit exceeded.
        assert(amount <= dayLimit) { "Limit exceeded." }

        // Error:
        //      Exception in thread "main" java.lang.AssertionError: Insufficient funds
        assert(balance !in 1..< amount) { "Insufficient funds" }
        balance -= amount

        return balance
    }
}