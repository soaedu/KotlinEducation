package data.type.standard_type.collection_type.operation.retrieving.element_at_or_else_operation

/**
 * Method returns an item from collection by specified index.
 *      * elementAtOrElse(index: Int, defaultValue: (Int) -> T): T
 *
 * If index is out of the range of collection indexes specified 'default' value is returned.
 */
fun main() {
    val targetValue_1 = 2
    val targetValue_2 = 12
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7)
    val result_1 = listOfNumber.elementAtOrElse(targetValue_1) { "Undefined" }
    val result_2 = listOfNumber.elementAtOrElse(targetValue_2) { "Undefined" }
    println(
        "Show result of retrieving applied to the:" +
        "\n\t'listOfNumber' ('elementAtOrElse' use valid index '$targetValue_1'): $result_1" +
        "\n\t'listOfNumber' ('elementAtOrElse' use invalid index '$targetValue_2'): $result_2"
    )
}
