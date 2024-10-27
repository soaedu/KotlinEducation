package data.type.standard_type.collection_type.operation.transforming.collection.unzip_operation

/**
 * Method separates one collection with paired values into two 'List's.
 */
fun main() {
    // #1
    val listOfPair = listOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4
    )
    val result_1 = listOfPair.unzip()

    // #2
    val map = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4
    )
    val result_2 = map.entries.map { Pair(it.key, it.value) }.unzip()

    println(
        "Show result of transformation apply to the" +
        "\n\t'listOfPair' (Pair with two lists: keys and values separately): $result_1" +
        "\n\t'map' (Pair with two lists: keys and values separately): $result_2"
    )
}
