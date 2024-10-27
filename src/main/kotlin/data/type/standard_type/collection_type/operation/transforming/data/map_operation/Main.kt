package data.type.standard_type.collection_type.operation.transforming.data.map_operation

/**
 * Method transforms items of the collection, but in case of a 'map' for both the
 * keys and values.
 */
fun main() {
    // #1
    // Use 'map' to transform items of the 'array'
    val arrayOfNumber = intArrayOf(1, 2, 3)
    val result_1 = arrayOfNumber.map { element ->
        "Item $element"
    }

    // #2
    // Use 'map' to transform items of the 'map'
    val map = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5
    )
    val result_2 = map.map { it.key.uppercase() to it.value * 10 }.toMap()

    println(
        "Show result of transformation applied to the:" +
        "\n\t'arrayOfNumber': $result_1" +
        "\n\t'map': $result_2"
    )
}
