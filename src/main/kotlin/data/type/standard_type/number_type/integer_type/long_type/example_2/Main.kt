package data.type.standard_type.number_type.integer_type.long_type.example_2

fun main() {
    // #1
    // Converting from 'String' and 'Long' type is inferred
    val string_1 = "1006787676766"
    val long_1 = string_1.toLong()

    // #2
    // Converting from 'Int' to 'Long'
    val int_1: Int = 10
    // 'Int' can't be assigned to long without conversion
    // val long_2: Long = int_1        // error: Type mismatch
    val long_2 = int_1.toLong()

    // #3
    // Converting from 'Float' to 'Long'
    val float_1: Float = 20.31f
    val long_3: Long = float_1.toLong()

    println(
        "Show value of:" +
        "\n\tlong_1 (converted from \"$string_1\"): $long_1" +
        "\n\tlong_2 (converted from $int_1): $long_2" +
        "\n\tlong_3 (converted from $float_1): $long_3"
    )
}
