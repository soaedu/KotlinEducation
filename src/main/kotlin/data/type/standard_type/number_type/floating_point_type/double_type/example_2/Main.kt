package data.type.standard_type.number_type.floating_point_type.double_type.example_2

fun main() {
    // #1
    // Converting from 'String' and 'Double' type is inferred
    val string_1 = "50"
    val double_1 = string_1.toDouble()

    // #2
    // Converting from 'Int' to 'Double'
    val int_1: Int = 10
    val double_2 = int_1.toDouble()

    // #3
    // Converting from 'Float' to 'Double'
    val float_1: Float = 20.31f
    val double_3: Double = float_1.toDouble()

    println(
        "Show value of:" +
        "\n\tdouble_1 (converted from \"$string_1\"): $double_1" +
        "\n\tdouble_2 (converted from $int_1): $double_2" +
        "\n\tdouble_3 (converted from $float_1): $double_3"
    )
}
