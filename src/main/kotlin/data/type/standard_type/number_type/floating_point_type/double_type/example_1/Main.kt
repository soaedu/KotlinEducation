package data.type.standard_type.number_type.floating_point_type.double_type.example_1

/**
 * A 'double':
 * 	* is a 64-bit number in Kotlin.
 * 	    Any decimal number without mentioning the number type is a double number.
 * 	* is tagged with 'd' or 'D'.
 * 	* type can be either declared explicitly or the compiler itself has the ability to infer
 * 		the type of the assigned value.
 * 	* in JVM, the characteristics of this 'Double' variable is derived from the characteristics
 * 		of primitive type 'double' of Java which has a non-nullable default value.
 */
fun main() {
    // #1
    // Declaring type explicitly
    val double_1: Double = 101.50

    // #2
    // Number type is automatically inferred
    val double_2 = 102.50

    // #3
    // Declaring and initializing separately
    var double_3: Double
    double_3 = 103.50

    println(
        "Show value of:" +
        "\n\tdouble_1: $double_1" +
        "\n\tdouble_2: $double_2" +
        "\n\tdouble_3: $double_3"
    )
}
