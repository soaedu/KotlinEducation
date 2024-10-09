package data.type.standard_type.number_type.integer_type.short_type.example_1

/**
 * A 'short':
 * 	* is a 16-bit number in Kotlin.
 * 	    The type is to be declared explicitly.
 * 	* value ranges from -32768 to 32767.
 * 	* in JVM, the characteristics of this 'Short' variable is derived from the characteristics
 * 		of primitive type 'short' of Java which has a non-nullable default value.
 */
fun main() {
    // #1
    // Declaring type explicitly
    val short_1: Short = -32768

    // #2
    // Declaring and initializing separately
    var short_2: Short
    short_2 = 32767

    println(
        "Show value of:" +
        "\n\tshort_1: $short_1" +
        "\n\tshort_2: $short_2"
    )
}
