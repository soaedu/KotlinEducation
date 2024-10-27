package data.type.standard_type.collection_type.operation.transforming.data.map_values_operation

/**
 * Method creates a new map with the same keys as the original 'map' but with the transformed
 * values.
 *
 * It accepts a lambda function as an argument, which is applied to each value of the 'map'.
 */
fun main() {
    // #1
    // Use 'mapValues' to create a new map with values multiplied on 2.
    val targetValue_1 = 2
    val map_1 = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5
    )
    val result_1 = map_1.mapValues { it.value * targetValue_1 }

    // #2
    // Use 'mapValues' to create a new map with values that has a '$' symbol in the end.
    val targetValue_2 = "$"
    val map_2 = mapOf(
        "beer" to 2.7,
        "bisquit" to 5.8
    )
    val result_2 = map_2.mapValues { it.value.toString() + targetValue_2 }

    println(
        "Show result of transformation apply to the" +
        "\n\t'map_1' (map with values multiplied on '$targetValue_1'): $result_1" +
        "\n\t'map_2' (map with values ending on '$targetValue_2'): $result_2"
    )
}
