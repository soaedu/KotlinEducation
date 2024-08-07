package syntax.properties.regular.example_2

fun main() {
    val deposit = Deposit("some_bank_id").apply {
        addToBalance(150_000)
    }
    println(
        "Deposit info: $deposit"
    )
}

class Deposit(bank_id: String) {
    // #1 Define property without backing field and no setter
    val depositId
        get() = "some_deposit_id"

    // #2 Define property with custom getter/setter
    var bankId: String = ""
        get() = field
        set (value) {
            field = value
        }

    init {
        // get value from the 'primary constructor'
        bankId = bank_id
    }

    // #3 Define property with private setter, that can be accessed only from class members (property, function)
    var _balance: Int = 0
        private set(value) {
            field = (value * 17.85).toInt()
        }

    fun addToBalance(value: Int) {
        _balance = value
    }

    override fun toString(): String {
        return "Deposit(" +
                "\n\tdepositId: \t'$depositId'" +
                "\n\tbankId: \t'$bankId' " +
                "\n\tbalance: \t$_balance" +
                "\n)"
    }
}