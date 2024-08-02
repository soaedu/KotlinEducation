package syntax.keyword.example_1

fun main() {
    // #1
    val deposit = Deposit().apply {
        balance = 150_000
    }
    println(
        "Deposit info:" +
        "\n\tbalance: ${deposit.balance} MDL"
    )

    // #2
    var sum = 1
    sum = sum + 2
    sum += 3
    val multiplier = 3
    // multiplier = 4              // Impossible, 'val' can't be reassigned
    println(
        "\nSum: $sum" +
        "\nMultiplier: $multiplier" +
        "\nResult: ${sum * multiplier}"
    )
}

// #1 Using 'val'/'var' keywords
class Deposit() {
    // 'val' is used to declare a read-only variable.
    val rate: Double = 17.58

    // 'var' is a mutable variable, which is, a variable that
    // can be changed to another value by reassigning it.
    var balance = 0
        set(valueInDollars: Int) {
            field = (valueInDollars * rate).toInt()
        }
}