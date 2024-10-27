package data.type.standard_type.collection_type.operation.transforming.collection.intersect_operation

/**
 * Method returns a 'set' containing all elements that are contained by both collections.
 */
fun main() {
    // #1
    val setOfNumber_1 = setOf(1, 2, 3, 4)
    val setOfNumber_2 = setOf(3, 4, 5, 6)
    val result_1 = setOfNumber_1.intersect(setOfNumber_2)

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
    val result_2 = map_1.keys.intersect(map_2.keys)

    println(
        "Show result of transformation apply to the" +
        "\n\t'setOfNumber_1' (set of items same in both collections): $result_1" +
        "\n\t'map_1' (set of keys same in both maps): $result_2"
    )
}
