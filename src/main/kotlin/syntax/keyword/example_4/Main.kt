package syntax.keyword.example_4

fun main() {
    val deposit = Deposit()

    // #1
    deposit.printMe()

    // #2
    deposit.printStringLength()

    // #3
    deposit.printBankId()

    // #4
    deposit.DepositLocation("Australia").printDepositInfo()
}

class Deposit(val bankId: String = "some_bank_id", val depositId: String = "some_deposit_id") {
    // #1
    // The 'this' keyword is used to refer to the enclosing instance.
    // An instance invoke a method passing itself as an argument.
    fun printMe() = println(this)

    // #2
    // The 'this' keyword is used to show the data of the 'current receiver'.
    fun printStringLength() {
        // 'deposit' string instance is the receiver
        println("\nstring length: ${depositId.length}")
    }

    override fun toString(): String {
        return "Deposit(" +
                "\n\tbankId='$bankId'" +
                "\n\tdepositId='$depositId'" +
                "\n)"
    }

    // #3
    // The 'this' keyword is used to refer to an 'outer instance'.
    // Keyword is used with label (name of the 'outer' class).
    inner class DepositLocation(val country: String) {
        fun printDepositInfo() = println(
            "\ndeposit id: ${this@Deposit.depositId}"
        )
    }
}

// #3
// The 'this' keyword is used to refer to the instance that the extension function was applied to.
fun Deposit.printBankId() {
    println("\nbank id: ${this.bankId}")
}
