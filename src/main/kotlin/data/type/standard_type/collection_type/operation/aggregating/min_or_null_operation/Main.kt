package data.type.standard_type.collection_type.operation.aggregating.min_or_null_operation

/**
 * Method returns the lowest extreme using the natural order of the elements in collection.
 *
 * If collection is empty we will get 'null'.
 */
fun main() {
    // #1
    // Use 'minOrNull' to get the minimal value in array.
    val arrayOfNumber = arrayOf(4, 6, 3, 5, 1, 2)
    val result_1 = arrayOfNumber.minOrNull()

    // #2
    // Use 'minOrNull' to get the minimal word (calculated lexicographically) in the list.
    val listOfString = listOf("Alice", "Tom", "Sam", "Kate", "Bob")
    val result_2 = listOfString.minOrNull()

    // #3
    // Use 'minOrNull' to get a 'null' from the empty list.
    val emptyList = emptyList<String>()
    val result_3 = emptyList.minOrNull()

    println(
        "Show result of aggregating applied to the:" +
        "\n\t'arrayOfNumber' ('minOrNull' minimal value): $result_1" +
        "\n\t'listOfString' ('minOrNull' minimal word): $result_2" +
        "\n\t'emptyList': $result_3"
    )
}
