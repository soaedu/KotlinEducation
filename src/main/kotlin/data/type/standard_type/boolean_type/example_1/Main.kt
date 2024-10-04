package data.type.standard_type.boolean_type.example_1

fun main() {
    // #1
    // Declare a 'boolean' variable and set initialize it
    // val isSunnyWeather: Boolean = true
    val isSunnyWeather: Boolean
    isSunnyWeather = true

    println("Show the value of:" +
        "\n\tisSunnyWeather: $isSunnyWeather"
    )

    // #2
    // Use 'boolean' as a result of an expression
    val a = 10
    val b = 20
    val is_A_GraterThan_B = a > b
    val is_A_EqualToTen = a == 10
    println("\nShow the result of:" +
        "\n\tis_A_GraterThan_B: $is_A_GraterThan_B" +
        "\n\tis_A_EqualToTen: $is_A_EqualToTen"
    )
}
