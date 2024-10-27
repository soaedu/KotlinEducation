package data.type.standard_type.collection_type.operation.transforming.data.map_not_null_operation

/**
 * Method returns a list containing only the non-null results of applying the given
 * transform function to each element in the original collection.
 */
fun main() {
    // #1
    // Use 'mapNotNull' to transform items of the list if they match to a predicate.
    val targetValue_1 = 3
    val listOfNumber = listOf(1, 2, 3, 4, 5)
    val result_1 = listOfNumber.mapNotNull { value ->
        if (value <= targetValue_1) {
            value * value
        } else {
            null
        }
    }

    // #2
    // Use 'mapNotNull' to transform items of the list if they can be cast to 'Int' type.
    val listOfString = listOf("12a", "45", "", "3")
    val result_2 = listOfString.mapNotNull { value ->
       value.toIntOrNull()
    }

    println(
        "Show result of transformation applied to the:" +
        "\n\t'listOfNumber' (list with items that match to a predicate): $result_1" +
        "\n\t'listOfString' (list with items that can be converted to Int value): $result_2"
    )
}
