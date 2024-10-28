package data.type.standard_type.collection_type.operation.retrieving.take_last_while_operation

/**
 * Function 'takeLastWhile' is used to return a list containing last element of an array
 * satisfying the specified predicate.
 *
 * Is opposite to function 'dropLastWhile()'.
 */
fun main() {
    // #1
    val targetValue_1 = "++"
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of taking items from the end of the 'listOfString'" +
        "\n\twhile element not contains '$targetValue_1': ${listOfString.takeLastWhile { it.contains(targetValue_1) }}"
    )

    // #2
    val targetValue_2 = 1f
    val arrayOfFloat = arrayOf(1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 1f)
    println(
        "Show result of taking items from the end of the 'arrayOfFloat'" +
        "\n\twhile element is not equal to '$targetValue_2': ${arrayOfFloat.takeLastWhile { it == targetValue_2 }}"
    )
}
