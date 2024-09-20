package syntax.functions.function_type.infix_func.example_1

fun main() {
    // #1
    // Call regular function
    val account = Account()
    account.add(100.00)
    println(
        "\nAccount #1 info:" +
        "\n\taccount balance: ${account.balance}"
    )

    // #2
    // Call 'infix function'
    val account2 = InfixAccount()
    account2 add 100.00
    println(
        "\nAccount #2 info:" +
        "\n\taccount balance: ${account2.balance}"
    )
}