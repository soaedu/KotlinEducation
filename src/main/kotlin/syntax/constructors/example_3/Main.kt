package syntax.constructors.example_3

fun main() {
    // #1
    val deposit = Deposit("some_bank_id", "some_deposit_id")
    println("Deposit info:" +
            "\n\tbank id: ${deposit.bankId}" +
            "\n\tdeposit id: ${deposit.depositId}" +
            "\n\tbalance: ${deposit.balance}"
    )

    // #2
    // val student = Student()
    // val student = Student("some_name")
    // val student = Student("some_name", false)
    val student = Student("some_name", true, 150)
    println("Student info:" +
            "\n\tname: ${student.name}" +
            "\n\tregistered: ${student.registered}" +
            "\n\tcredits: ${student.credits}"
    )

    // #3
    val chequePayment = ChequePayment(amount = 2, name = "Shirt", bankId = "some_bank_id")
    println("Payment info:" +
            "\n\tamount: ${chequePayment.amount}" +
            "\n\tname: ${chequePayment.name}" +
            "\n\tbank id: ${chequePayment.bankId}"
    )
}

// #1 Use 'secondary constructor' to call the 'primary constructor'
// with default value for 'balance' and create an instance of the class.
class Deposit(
    val bankId: String,
    val depositId: String,
    val balanceValue: Int?
) {
    val balance: String
        get() = balanceValue?.toString() ?: "Unknown"

    constructor(bankId: String, depositId: String): this(bankId, depositId, null)
}

// #2 We can use default parameters in constructor to avoid the need for
// multiple 'secondary constructors'.
class Student(val name: String, val registered: Boolean, credits: Int) {
    var credits: Int = 0

    init {
        this.credits = credits
    }

    constructor(): this("No name", false, 0)
    constructor(name: String): this(name, false, 0)
    constructor(name: String, registered: Boolean): this(name, registered, 0)
}

// #3 Use 'secondary constructor' to call the parent one.
// This call needs to be the first thing our constructor does.
// The body of our constructor is preceded by 'super(amount)'
open class Payment(val amount: Int)
class ChequePayment : Payment {
    // We can't use 'val'/'var' in 'secondary constructor'.
    // constructor(val amount: Int, var nameValue: String, var bankId: String): super(amount) {

    constructor(amount: Int, name: String, bankId: String): super(amount) {
        this.name = name
        this.bankId = bankId
    }

    var name: String
        get() = field
    var bankId: String
        get() = field
}



