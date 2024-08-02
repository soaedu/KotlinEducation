package syntax.keyword.example_3

// The 'as' keyword is used for import renaming
import syntax.keyword.example_3.DepositInfo as Deposit_1
import syntax.keyword.example_3.DepositFullData as Deposit_2

fun main() {
    val deposit = Deposit(
        bankId = "some_deposit_id",
        depositId = "some_deposit_id",
        balance = 150_000
    )

    Deposit_1(deposit).showData()
    println()
    Deposit_2(deposit).showData()
}

