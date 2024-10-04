package data.type.standard_type.boolean_type.example_2

/**
 * 'Booleans' are rather standard, and support the usual:
 * 	    * negation (!)
 * 	    * conjunction (&&)
 * 	    * disjunction (||)
 * operations.
 */
fun main() {
    val isSunnyWeather = true

    val x = 1
    val y = 2
    val z = 2
    val is_X_LowerThan_Y_And_Z = x < y && x < z
    val is_X_EqualTo_Y_And_Y_EqualTo_Z = x == y || y == z

    println(
        "Show result of:" +
        "\n\tisSunnyWeather (negation): ${!isSunnyWeather}" +
        "\n\tis_X_LowerThan_Y_And_Z (conjunction): $is_X_LowerThan_Y_And_Z" +
        "\n\tis_X_EqualTo_Y_And_Y_EqualTo_Z (disjunction): $is_X_EqualTo_Y_And_Y_EqualTo_Z"
    )
}
