package data.type.standard_type.collection_type.operation.aggregating.max_by_or_null_operation

/**
 * Method returns the max value by a specific field on a data class.
 *
 * If collection is empty we will get 'null'.
 */
fun main() {
    // #1
    // Use 'maxByOrNull' to get the biggest value in array.
    val arrayOfNumber = arrayOf(4, 6, 3, 5, 1, 2)
    val result_1 = arrayOfNumber.maxByOrNull { it }

    // #2
    // Use 'maxByOrNull' to get the biggest word (calculated lexicographically) in the list.
    val listOfString = listOf("Alice", "Tom", "Sam", "Kate", "Bob")
    val result_2 = listOfString.maxByOrNull { it }

    // #3
    // Use 'maxByOf' to get a 'null' from the empty list.
    val emptyList = emptyList<String>()
    val result_3 = emptyList.maxByOrNull { it }

    println(
        "Show result of aggregation applied to the:" +
        "\n\t'arrayOfNumber': $result_1" +
        "\n\t'listOfString': $result_2" +
        "\n\t'emptyList': $result_3"
    )
}
