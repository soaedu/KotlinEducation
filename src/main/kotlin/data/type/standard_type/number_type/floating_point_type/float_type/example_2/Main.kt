package data.type.standard_type.number_type.floating_point_type.float_type.example_2

fun main() {
    // #1
    // Converting from 'String' and 'Float' type is inferred
    val string_1 = "50"
    val float_1 = string_1.toFloat()

    // #2
    // Converting from 'Int' to 'Float'
    val int_1: Int = 10
    val float_2 = int_1.toFloat()

    // #3
    // Converting from 'Double' to 'Float'
    val double_1: Double = 20.31
    val float_3: Float = double_1.toFloat()

    println(
        "Show value of:" +
        "\n\tfloat_1 (converted from \"$string_1\"): $float_1" +
        "\n\tfloat_2 (converted from $int_1): $float_2" +
        "\n\tfloat_3 (converted from $double_1): $float_3"
    )
}
