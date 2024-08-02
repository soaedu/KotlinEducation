package syntax.keyword.example_3

class DepositInfo(val deposit: Deposit) {
    fun showData() {
        println("Deposit info:" +
                "\n\tdepositId: ${deposit.depositId}" +
                "\n\tbalance: ${deposit.balance}"
        )
    }
}
