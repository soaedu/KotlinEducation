package syntax.functions.function_type.pure_func.example_1

fun main() {
    // #1
    println(
        "Calculate sum of two integers: ${getSum(2, 3)}" +
        "\nCheck if specified amount is valid (pure func): ${isAmountValid(12.56, 13.0)}" +
        "\nCheck if specified amount is valid (impure func): ${isAmountValid(12.56)}"
    )
}

// #1
// Use 'pure function' to calculate the sum of two integers.
fun getSum(a: Int, b: Int): Int = a + b

// #2
// Use 'pure function' to check if specified amount is valid.
fun isAmountValid(amount: Double, max: Double): Boolean = amount < max

// #3
// Use 'impure function' to check if specified amount is valid.
fun getMax() = 13
fun isAmountValid(amount: Double): Boolean {
    val max = getMax()
    return amount < max
}

// #4
// Android example of 'impure function'.
// Here 'isValid' is external and is modifying the Observable that is outside the function.
/*
val isValid = ObservableBoolean(false)
private fun checkValidity() {
    val isAllValid = fields.map {
        it.isValid.get()
    }.reduce { acc, b -> acc && b }
    isValid.set(isAllValid)
}*/
