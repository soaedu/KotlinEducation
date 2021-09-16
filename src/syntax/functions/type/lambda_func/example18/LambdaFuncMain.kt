package syntax.functions.type.lambda_func.example18

fun main() {
    // Regular function
    val isEven: (Int) -> Boolean = { it%2 == 0 }

    // Extension function
    val isOdd: Int.() -> Boolean = { this%2 == 1 }

    println("1. result: ${isEven(0)}")
    println("2. result: ${1.isOdd()}")
}
