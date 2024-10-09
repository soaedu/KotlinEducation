package data.type.standard_type.number_type.integer_type.int_type.example_2

fun main() {
    // #1
    // Converting from 'String' to 'Int' type is inferred
    val string_1 = "50"
    val int_1 = string_1.toInt()

    // #2
    // Converting from 'Float' to 'Int'
    val float_1: Float = 20.31f
    val int_2: Int = float_1.toInt()

    // #3
    // Converting from 'Double' to 'Int'
    val double_1: Double = 2000.1000
    val int_3: Int = double_1.toInt()

    println(
        "Show value of:" +
        "\n\tint_1 (converted from \"$string_1\"): $int_1" +
        "\n\tint_2 (converted from $float_1): $int_2" +
        "\n\tint_3 (converted from $double_1): $int_3"
    )
}
