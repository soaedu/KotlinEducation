package data.type.standard_type.number_type.integer_type.byte_type.example_1

/**
 * A byte:
 * 	* is an 8-bit number in Kotlin. This type is mentioned explicitly.
 * 	* value ranges from -128 to 127
 * 	* in JVM, the characteristics of this 'Byte' variable is derived from the characteristics
 * 		of primitive type 'byte' of Java which has a non-nullable default value.
 */
fun main() {
    // #1
    // Declaring type explicitly
    val byte_1: Byte = 20

    // #2
    // Declaring and initializing separately
    var byte_2: Byte
    byte_2 = -50

    println(
        "Show value of:" +
        "\n\tbyte_1: $byte_1" +
        "\n\tbyte_2: $byte_2"
    )
}
