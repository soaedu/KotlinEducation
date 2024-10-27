package data.type.standard_type.collection_type.operation.finding.last_index_of_operation

/**
 * Method helps to find the index of the last occurrence of the specified element in a collection.
 *
 * If element is not found it returns '-1'.
 */
fun main() {
    // #1
    // Use 'lastIndexOf' to find the last occurrence in the list.
    val targetValue_1 = "b"
    val targetValue_2 = "z"
    val listOfString = listOf("a", "b", "v", "b", "m")
    val result_1 = listOfString.lastIndexOf(targetValue_1)
    val result_2 = listOfString.lastIndexOf(targetValue_2)

    // #2
    // Use 'indexOfLast'/'lastIndexOf' to find the last occurrence in the array.
    val targetValue_3 = 3
    val arrayOfNumber = arrayOf(1, 2, 3, 4, 3, 5)
    val result_3 = arrayOfNumber.lastIndexOf(targetValue_3)
    val result_4 = arrayOfNumber.indexOfLast { it == targetValue_3 }

    println(
        "Show result of finding apply to the" +
        "\n\t'listOfString' ('lastIndexOf' last occurrence of '$targetValue_1'): $result_1" +
        "\n\t'listOfString' ('lastIndexOf' last occurrence of '$targetValue_2'): $result_2" +
        "\n\t'arrayOfNumber' ('lastIndexOf' last occurrence of '$targetValue_3'): $result_3" +
        "\n\t'arrayOfNumber' ('indexOfLast' last occurrence of '$targetValue_3'): $result_4"
    )
}
