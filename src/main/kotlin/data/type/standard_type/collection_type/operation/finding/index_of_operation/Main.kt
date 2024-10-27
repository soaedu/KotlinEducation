package data.type.standard_type.collection_type.operation.finding.index_of_operation

/**
 * Method helps to find the index of the first occurrence of the specified element in a collection.
 *
 * If element is not found it returns '-1'.
 */
fun main() {
    // #1
    // Use 'indexOf' to find the first occurrence in the list.
    val targetValue_1 = "b"
    val targetValue_2 = "z"
    val listOfString = listOf("a", "b", "v", "b", "m")
    val result_1 = listOfString.indexOf(targetValue_1)
    val result_2 = listOfString.indexOf(targetValue_2)

    // #2
    // Use 'indexOf'/'indexOfFirst' to find the first occurrence in the array.
    val targetValue_3 = 3
    val arrayOfNumber = arrayOf(1, 2, 3, 4, 3, 5)
    val result_3 = arrayOfNumber.indexOf(targetValue_3)
    val result_4 = arrayOfNumber.indexOfFirst { it == targetValue_3 }

    println(
        "Show result of finding apply to the" +
        "\n\t'listOfString' ('indexOf' first occurrence of '$targetValue_1'): $result_1" +
        "\n\t'listOfString' ('indexOf' first occurrence of '$targetValue_2'): $result_2" +
        "\n\t'arrayOfNumber' ('indexOf' first occurrence of '$targetValue_3'): $result_3" +
        "\n\t'arrayOfNumber' ('indexOfFirst' first occurrence of '$targetValue_3'): $result_4"
    )
}
