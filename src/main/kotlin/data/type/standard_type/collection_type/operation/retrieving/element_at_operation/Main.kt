package data.type.standard_type.collection_type.operation.retrieving.element_at_operation

/**
 * Method returns an item from collection by specified index.
 *      * elementAt(index: Int): T
 *
 * If index is out of the range of collection indexes error is thrown:
 * ArrayIndexOutOfBoundsException
 */
fun main() {
    val targetValue_1 = 2
    val targetValue_2 = 12
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7)
    val result_1 = listOfNumber.elementAt(targetValue_1)
    // val result_2 = listOfNumber.elementAt(targetValue_2)

    println(
        "Show result of retrieving apply to the:" +
        "\n\t'listOfNumber' ('elementAt' show item placed on valid position '$targetValue_1'): $result_1"
        // "\n\t'listOfNumber' ('elementAt' show item placed on invalid position '$targetValue_2'): $result_2"
    )
}
