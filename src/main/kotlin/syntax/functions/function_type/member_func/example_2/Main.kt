package syntax.functions.function_type.member_func.example_2

fun main() {
    val deposit = Deposit(
        bankAccount = "some_bank_account",
        balance = 0.0
    )
    deposit.addMoney(150.89)

    println(
        "Show deposit info:" +
        "\n\t$deposit"
    )
}

class Deposit(
    private var bankAccount: String,
    private var balance: Double
) {
    // Use 'member function' to change value of the 'private' class parameter.
    fun addMoney(value: Double) {
        balance += value
    }

    override fun toString(): String {
        return "Deposit(bankAccount='$bankAccount', balance=$balance)"
    }
}