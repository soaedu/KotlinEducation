package data.type.standard_type.collection_type.operation.filtering.filter_keys_operation

/**
 * Function filters out certain key-value pairs from the 'map'
 * based on the keys.
 */
fun main() {
    // #1
    val targetValue_1 = "three"
    val map_1 = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5
    )
    val result_1 = map_1.filterKeys { it != targetValue_1 }

    // #2
    val targetValue_2 = "key"
    val targetValue_3 = "key3"
    val map_2 = mapOf(
        "key1" to 1,
        "key2" to 2,
        "something_else" to 3
    )
    val result_2 = map_2.filterKeys { it.contains(targetValue_2) }

    val nonMatchingPredicate: (String) -> Boolean = { it == targetValue_3 }
    val result_3 = map_2.filterKeys(nonMatchingPredicate)

    println(
        "Show result of filtering apply to the:" +
        "\n\t'map_1': $result_1" +
        "\n\t'map_2': $result_2" +
        "\n\t'map_3': $result_3"
    )
}
