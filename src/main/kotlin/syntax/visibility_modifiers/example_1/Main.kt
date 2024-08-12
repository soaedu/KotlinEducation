package syntax.visibility_modifiers.example_1

fun main() {
    val clientDeposit = ClientDeposit()
    println(
        "Client deposit info:" +
        "\n\tbank id: ${clientDeposit.bankId}" +
        "\n\tdeposit id: ${clientDeposit.depositId}" +
        "\n\tbalance: ${clientDeposit.getCurrentBalance()}"
    )
}

open class Deposit(val bankId: String) {
    // Modifier 'public' is used for the property
    public val depositId: String = "some_deposit_id"

    // Modifier 'protected' is used for the properties
    protected var income: Int = 150_000
    protected var rate = 17.85

    // Modifier 'private' is used for the property
    private val _balance: Double
        get() = calculateBalance()

    // Modifier 'public' is used for the method
    private fun calculateBalance() = (rate * income)

    // Modifier 'public' is used for the property event if it is nor specified
    fun getCurrentBalance() = _balance
}

class ClientDeposit : Deposit("some_bank_id") {
    init {
        income = 300_000
        rate = 20.05
    }
}