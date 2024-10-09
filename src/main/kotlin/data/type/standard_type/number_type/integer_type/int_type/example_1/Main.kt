package data.type.standard_type.number_type.integer_type.int_type.example_1

/**
 * An int:
 * 	* is a 32-bit number in Kotlin.
 * 	    The type can be either declared explicitly or the compiler itself has the ability
 * 	    to infer the type of the assigned value.
 * 	* value ranges from -2147483648 to 2147483647 ie., -(2^31) through 0 to (2^31)-1
 * 	* in JVM, the characteristics of this 'Int' variable is derived from the characteristics
 * 		of primitive type 'int' of Java which has a non-nullable default value.
 */
fun main() {
    // #1
    // Declaring type explicitly
    val int_1: Int = 20

    // #2
    // Declaring number, type is automatically inferred
    val int_2 = 100

    // #3
    // Declaring and initializing separately
    var int_3: Int
    int_3 = -50

    println(
        "Show value of:" +
        "\n\tint_1: $int_1" +
        "\n\tint_2: $int_2" +
        "\n\tint_3: $int_3"
    )
}
