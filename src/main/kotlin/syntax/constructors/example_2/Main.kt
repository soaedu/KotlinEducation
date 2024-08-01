package syntax.constructors.example_2

//import com.oracle.svm.core.annotate.Inject

fun main() {
    // #1
    /*val depositRepository = DepositRepository()   // will be in DI
    val deposit = Deposit(depositRepository)*/

    // #2
    /*val deposit = Deposit().apply {
        bankId = "1234_5678_4758_6900"
        balance = 159_000
    }
    println(
        "Deposit info: " +
                "\n\tbank id: ${deposit.bankId}" +
                "\n\tdeposit id: ${deposit.depositId}" +
                "\n\tbalance: ${deposit.balance}"
    )*/

    // #4
    // val deposit = Deposit()          // Has no access to constructor, it is private in the class
    val deposit = Deposit.INSTANCE      // Has access to its companion object.
}

// #1 Get 'primary constructor' with annotation '@Inject'
// injection will be performed by DI tool
/*class DepositRepository()
class Deposit @Inject constructor(val repository: DepositRepository)*/


// #2 Use 'primary constructor' with init block and init value calculation
/*
class Deposit {
    var bankId: String = "some_bank_id"
    var depositId = "some_deposit_id"
    var balance: Int? = null

    // initialization block
    init {
        balance = calculateBalance()
    }

    private fun calculateBalance(): Int {
        val balanceInDollar = 150_000
        val rate = 17.88
        return (balanceInDollar * rate).toInt()
    }
}*/

// #3 Use 'primary constructor' with default values for all parameters
// When default values are specified for all parameters, compiler will generate additional
// constructor without parameters, that uses all default values.
// That simplifies using libraries in Kotlin, that create instances of the classes using
// constructor without parameters.
/*class Deposit(
    val bankId: String = "some_bank_id",
    val depositId: String = "some_deposit_id",
    val balance: Int = 159_000,
)*/

// #4 Use 'private' on constructor define
// To have guarantee that nobody can create an instance of that class put 'private' before
// constructor. Code outside the class can't create an instance of that class. To do it we can use
// a companion object.
class Deposit private constructor() {
    companion object {
        val INSTANCE = Deposit()
    }
}
