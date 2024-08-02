package syntax.keyword.example_5

fun main() {
    // val bank = Bank()       // Impossible, instance of the abstract class can't be created
    val deposit = Deposit(
        bankId = "some_bank_id",
        depositId = "some_deposit_id"
    )
    println(deposit)
}

// The 'abstract' keyword is used to mark a class as abstract.
// That keyword needs to avoid creating instance of the class 'Bank'.
// it can only be inherited.
abstract class Bank

class Deposit(val bankId: String, val depositId: String) : Bank() {
    override fun toString(): String {
        return "Deposit(" +
                "\n\tbankId='$bankId'" +
                "\n\tdepositId='$depositId'" +
                "\n)"
    }
}