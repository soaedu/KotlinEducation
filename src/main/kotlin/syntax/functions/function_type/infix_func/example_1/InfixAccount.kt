package syntax.functions.function_type.infix_func.example_1

class InfixAccount {
    var balance = 0.0

    infix fun add(amount: Double): Unit {
        this.balance = balance + amount
    }
}