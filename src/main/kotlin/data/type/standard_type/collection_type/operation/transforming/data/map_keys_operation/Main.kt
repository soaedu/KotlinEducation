package data.type.standard_type.collection_type.operation.transforming.data.map_keys_operation

/**
 * Method creates a new map by applying a transformation function to the keys of the original map.
 *
 * It is particularly useful when we want to transform only the keys of the map without altering
 * the values.
 *
 * In case if any two entries are mapped to the equal keys, the value of the latter one will
 * overwrite the value associated with the former one.
 */
fun main() {
    // #1
    // Use 'mapKeys' to create a new map with uppercase keys.
    val map_1 = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5
    )
    val result_1 = map_1.mapKeys { it.key.uppercase() }

    // #2
    // Use 'mapKeys' to create a new map with keys that are first letters of keys
    // from the source map.
    val map_2 = mapOf(
        "beer" to 2.7,
        "bisquit" to 5.8
    )
    val result_2 = map_2.mapKeys { it.key.take(1) }

    println(
        "Show result of transformation apply to the" +
        "\n\t'map_1' (map with keys uppercase): $result_1" +
        "\n\t'map_2' (map with keys containing one symbol): $result_2"
    )
}
