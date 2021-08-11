package syntax.operators.type.elvis_operator.example1

import syntax.functions.type.regular_func.example1.getFirstName
import syntax.functions.type.regular_func.example1.getLastName

fun main(args: Array<String>) {
    val firstName = getFirstName(args) ?: "John"
    val lastName = getLastName(args) ?: "Malkovich"
    println("Hello, $firstName $lastName")
}