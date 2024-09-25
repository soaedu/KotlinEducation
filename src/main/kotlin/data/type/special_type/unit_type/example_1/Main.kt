package data.type.special_type.unit_type.example_1

fun main() {
    with(Deposit()) {
        addMoney(155.25)
        println(this)
    }
}

class Deposit(
    val bankId: String = "some_bank_id",
    var balance: Double = 0.0
) {
    // Use 'Unit' type to specify that method is used for
    // modifying external state and doesn't return a value
    fun addMoney(value: Double): Unit {
        balance += value
    }

    override fun toString(): String {
        return "Deposit(bankId='$bankId', balance=$balance)"
    }
}
