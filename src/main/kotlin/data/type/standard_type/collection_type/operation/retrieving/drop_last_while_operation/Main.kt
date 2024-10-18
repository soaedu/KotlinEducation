package data.type.standard_type.collection_type.operation.retrieving.drop_last_while_operation

/**
 * Function 'dropLastWhile' is used to returns the elements from the last one not matching
 * the predicate to the end.
 * Is opposite to function 'takeLastWhile()'.
 *
 * Function 'dropLastWhile' works from index n to 0 and stops removing elements as soon
 * as an element does not meet the condition of the predicate.
 */
fun main() {
    // #1
    val targetValue_1 = "++"
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of dropping items from the end of the 'listOfString'" +
        "\n\twhile element not contains '$targetValue_1': ${listOfString.dropLastWhile { it.contains(targetValue_1) }}"
    )

    // #2
    val targetValue_2 = 1f
    val arrayOfFloat = arrayOf(1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 1f)
    println(
        "Show result of dropping items from the end of the 'arrayOfFloat'" +
        "\n\twhile element is not equal to '$targetValue_2': ${arrayOfFloat.dropLastWhile { it == targetValue_2 }}"
    )
}
