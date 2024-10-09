package data.type.standard_type.number_type.floating_point_type.float_type.example_1

/**
 * A 'float':
 * 	* is a 32-bit number in Kotlin.
 * 	* is tagged with 'f' or 'F'.
 * 	* type can be either declared explicitly or the compiler itself has the ability to infer
 * 		the type of the assigned value.
 * 	* in JVM, the characteristics of this 'Float' variable is derived from the characteristics
 * 		of primitive type 'float' of Java which has a non-nullable default value.
 */
fun main() {
    // #1
    // Declaring type explicitly
    val float_1: Float = 101.50f

    // #2
    // Number type is automatically inferred
    val float_2 = 102.50f

    // #3
    // Declaring and initializing separately
    var float_3: Float
    float_3 = 103.50f

    println(
        "Show value of:" +
        "\n\tfloat_1: $float_1" +
        "\n\tfloat_2: $float_2" +
        "\n\tfloat_3: $float_3"
    )
}
