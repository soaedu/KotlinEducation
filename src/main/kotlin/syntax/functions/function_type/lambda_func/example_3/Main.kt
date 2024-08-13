package syntax.functions.function_type.lambda_func.example_3

fun main() {
    // #1
    // Lambda can be called directly
    { println("Calculate expression (direct call): \t${(1 + 2) *4}") } ()

    // #2
    // Lambda can be passed as parameter to 'run' function
    run { println("Calculate expression ('run' call): \t\t${(1 + 2) *4}") }

    // #3
    // Lambda can be saved in variable and called later as function
    val changeCalculateLambda: (Int, Double) -> Double = { number_1: Int, number_2: Double -> number_1 * number_2 }
    val result = "$%.2f".format(changeCalculateLambda(100, 17.88))
    println("Calculate change money course: \t\t\t$result")
}