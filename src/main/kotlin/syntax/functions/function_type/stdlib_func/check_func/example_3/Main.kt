package syntax.functions.function_type.stdlib_func.check_func.example_3

fun main() {
    val deposit = Deposit()
    println(
        "Deposit info:" +
        "\n\tstate: ${deposit.getState()}"
    )
}

class Deposit(val bankId: String = "some_bank_id") {
    // private val _state: String? = null
    // private val _state: String = ""
    private val _state: String = "non-empty-state"

    fun getState(): String {
        // Error if 'null':
        //   Exception in thread "main" java.lang.IllegalStateException: State must not be 'null'
        val state = checkNotNull(_state) { "State must not be 'null'" }

        // Error if empty string:
        //   Exception in thread "main" java.lang.IllegalStateException: State must not be empty
        check(state.isNotEmpty()) { "State must not be empty" }

        return state
    }
}