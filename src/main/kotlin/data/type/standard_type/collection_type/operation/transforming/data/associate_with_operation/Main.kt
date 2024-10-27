package data.type.standard_type.collection_type.operation.transforming.data.associate_with_operation

/**
 * Method creates a new 'Map' in which the elements of the original collection are keys,
 * and values are produced from them by the given transformation function.
 *
 * If two elements are equal, only the last one remains in the 'map'.
 */
fun main() {
    // #1
    val listOfString_1 = listOf("one", "two", "three", "four", "five")
    val result_1 = listOfString_1.associateWith { it to it.length }

    // #2
    val listOfString_2 = listOf("Alex", "Ben", "Cal")
    val result_2 = listOfString_2.associateWith { it.length }

    println(
        "Show result of transformation apply to the" +
        "\n\t'listOfString_1': $result_1" +
        "\n\t'listOfString_2': $result_2"
    )
}
