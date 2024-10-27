package data.type.standard_type.collection_type.operation.transforming.data.join_to_string_operation

/**
 * Method to create a string from all the elements in the collection separated using 'separator'
 * and the given 'prefix'/'postfix' if supplied.
 *
 * For huge collections we can specify a non-negative value of limit and the tail will be hidden
 * by 'truncated' parameter value.
 */
fun main() {
    // #1
    // Use 'joinToString' to transform collection with numbers to a string.
    val targetValue_1 = "["
    val targetValue_2 = "]"
    val targetValue_3 = "<"
    val targetValue_4 = ">"
    val targetValue_5 = "•"
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6)
    val result_1 = listOfNumber.joinToString()
    val result_2 = listOfNumber.joinToString(
        prefix = targetValue_1,
        postfix = targetValue_2,
    )
    val result_3 = listOfNumber.joinToString(
        prefix = targetValue_3,
        postfix = targetValue_4,
        separator = targetValue_5
    )

    // #2
    // Use 'joinToString' to transform collection with chars to a string.
    val targetValue_6 = 5
    val targetValue_7 = "...!"
    val arrayOfChar = charArrayOf(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q'
    )
    val result_4 = arrayOfChar.joinToString(
        limit = targetValue_6,
        truncated = targetValue_7
    )

    println(
        "Show result of transformation apply to the" +
        "\n\t'listOfNumber' (no parameters): $result_1" +
        "\n\t'listOfNumber' (prefix '$targetValue_1', postfix '$targetValue_2'): $result_2" +
        "\n\t'listOfNumber' (prefix '$targetValue_3', postfix '$targetValue_4', separator '$targetValue_5'): $result_3" +
        "\n\t'arrayOfChar' (limit '$targetValue_6', truncated '$targetValue_7'): $result_4"
    )
}
