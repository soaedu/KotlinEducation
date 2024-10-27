package data.type.standard_type.collection_type.operation.retrieving.element_at_or_null_operation

/**
 * Method returns an item from collection by specified index.
 *      * elementAtOrNull(index: Int): T?
 *
 * If index is out of the range of collection indexes specified 'null' value is returned.
 */
fun main() {
    val targetValue_1 = 2
    val targetValue_2 = 12
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7)
    val result_1 = listOfNumber.elementAtOrNull(targetValue_1)
    val result_2 = listOfNumber.elementAtOrNull(targetValue_2)
    println(
        "Show result of retrieving apply to the" +
        "\n\t'listOfNumber' ('elementAtOrNull' use valid index '$targetValue_1'): $result_1" +
        "\n\t'listOfNumber' ('elementAtOrNull' use invalid index '$targetValue_2'): $result_2"
    )
}
