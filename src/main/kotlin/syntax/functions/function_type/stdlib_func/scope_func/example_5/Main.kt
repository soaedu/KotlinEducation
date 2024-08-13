package syntax.functions.function_type.stdlib_func.example_1.scope_func.example_5

import syntax.functions.function_type.stdlib_func.example_1.scope_func.example_3.License
import syntax.functions.function_type.stdlib_func.example_1.scope_func.example_3.Person
import syntax.functions.function_type.stdlib_func.example_1.scope_func.example_3.getLicense

/**
 * Scope function 'with' has definition in the 'standard library' like this
 *
 * inline fun <T, R> with(receiver: T, block: T.() -> R): R {
 *      return receiver.block()
 *  }
 *
 * top-level function that can be called on 'non-nullable receivers'
 * represents the 'context object' as the 'implicit receiver'
 * returns the result of lambda
 *
 * Should be used if we:
 *      * want to call multiple functions on an object avoid repeating the receiver each time
 *      * want to introduce a new scope where the specified object becomes an implicit receiver
 */
fun main() {
    // #1
    // Use 'scope function' to define new values for the existing instance of the 'person'.
    val person_1 = Person("234567891", "John Smith", 25, License(125, "John Smith"))
    val license_1 = with(person_1) {
        id = "1234567891"
        name = "Joe Smith"
        age = 33
        license = null

        getLicense()
    }
    println(
        "Show person info:" +
        "\n\tperson_1: $person_1" +
        "\n\tlicense_1: $license_1"
    )

    // #2
    println(
        "\nStart learning alphabet..." +
        "\n\tresult: ${getAlphabet()}"
    )
}

// #2
// Use 'scope function' to call few functions on an 'implicit receiver' and get result.
fun getAlphabet(): String = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nOk. Learning alphabet is completed!")
    toString()
}
