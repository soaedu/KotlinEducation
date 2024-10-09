package data.type.standard_type.number_type.integer_type.byte_type.example_2

fun main() {
    // #1
    // Converting from 'String' to 'Byte' type is inferred
    val string_1 = "50"
    val byte_1 = string_1.toByte()

    // #2
    // Converting from 'Int' to 'Byte'
    val int_1: Int = 10
    val byte_2: Byte = int_1.toByte()

    // #3
    // Converting from 'Float' to 'Byte'
    val float_1: Float = 20.31f
    val byte_3: Byte = float_1.toInt().toByte()

    println(
        "Show value of:" +
        "\n\tbyte_1 (converted from \"$string_1\"): $byte_1" +
        "\n\tbyte_2 (converted from $int_1): $byte_2" +
        "\n\tbyte_3 (converted from $float_1): $byte_3"
    )
}
