package data.type.standard_type.number_type.integer_type.long_type.example_1

/**
 * A 'long':
 * 	* is a 64-bit number in Kotlin.
 * 	    The type can be either declared explicitly or the compiler itself has the ability
 * 	    to infer the type of the assigned value.
 * 	* value ranges from -(2^63) to (2^63)-1.
 * 	    Any value less than -(2^31) or greater than (2^31)-1 is inferred automatically by the
 * 		compiler as a 'Long' value.
 * 	* in JVM, the characteristics of this 'Long' variable is derived from the characteristics
 * 		of primitive type 'long' of Java which has a non-nullable default value.
 */
fun main() {
    // #1
    // Declaring type explicitly
    val long_1: Long = 1000001234561

    // #2
    // Declaring number, type is automatically inferred
    val long_2 = 1000001234562

    // #3
    // Declaring and initializing separately
    var long_3: Long
    long_3 = -1000001234563

    println(
        "Show value of:" +
        "\n\tlong_1: $long_1" +
        "\n\tlong_2: $long_2" +
        "\n\tlong_3: $long_3"
    )
}
