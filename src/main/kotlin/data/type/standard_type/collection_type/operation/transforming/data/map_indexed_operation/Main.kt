package data.type.standard_type.collection_type.operation.transforming.data.map_indexed_operation

/**
 * Method transforms items of the collection knowing the index of the elements.
 */
fun main() {
    // #1
    // Use 'mapIndexed' to transform items of the array
    val arrayOfNumber = intArrayOf(1, 2, 3)
    val result_1 = arrayOfNumber.mapIndexed { index, value ->
        "Item[$index] = $value"
    }

    // #2
    // Use 'mapIndexed' to transform items of the map
    val listOfNumber = listOf(3, 2, 1)
    val result_2 = listOfNumber.mapIndexed { index, value ->
        index * value
    }

    println(
        "Show result of transformation applied to the:" +
        "\n\t'arrayOfNumber': $result_1" +
        "\n\t'listOfNumber': $result_2"
    )
}
