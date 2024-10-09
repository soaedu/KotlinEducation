package data.type.standard_type.number_type.integer_type.short_type.example_2

fun main() {
    // #1
    // Converting from 'String' and 'Short' type is inferred
    val string_1 = "50"
    val short_1 = string_1.toShort()

    // #2
    // Converting from 'Int' to 'Short'
    val int_1: Int = 10
    val short_2 = int_1.toShort()

    // #3
    // Converting from 'Float' to 'Short'
    val float_1: Float = 20.31f
    val short_3: Short = float_1.toInt().toShort()

    println(
        "Show value of:" +
        "\n\tshort_1 (converted from \"$string_1\"): $short_1" +
        "\n\tshort_2 (converted from $int_1): $short_2" +
        "\n\tshort_3 (converted from $float_1): $short_3"
    )
}
