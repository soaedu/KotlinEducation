package data.type.standard_type.collection_type.operation.transforming.collection.subtract_operation

/**
 * Method returns a 'set' containing all elements that are contained by this collection and
 * not contained by the specified collection.
 */
fun main() {
    // #1
    val setOfNumber_1 = setOf(1, 2, 3, 4)
    val setOfNumber_2 = setOf(3, 4, 5, 6)
    val result_1 = setOfNumber_1.subtract(setOfNumber_2)

    // #2
    val map_1 = mapOf(
        "one" to 1,
        "two" to 2
    )
    val map_2 = mapOf(
        "one" to 1,
        "three" to 3,
        "five" to 5
    )
    val result_2 = map_1.keys.subtract(map_2.keys)

    println(
        "Show result of transformation apply to the" +
        "\n\t'setOfNumber_1' (set of items existing only in source collection): $result_1" +
        "\n\t'map_1' (set of keys existing only in source map): $result_2"
    )
}
