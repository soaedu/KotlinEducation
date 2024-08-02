package syntax.keyword.example_3

class DepositFullData(val deposit: Deposit) {
    fun showData() {
        println("Deposit full data:" +
                "\n\tbankId: ${deposit.bankId}" +
                "\n\tdepositId: ${deposit.depositId}" +
                "\n\tbalance: ${deposit.balance}"
        )
    }
}