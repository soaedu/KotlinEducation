package data.type.standard_type.collection_type.operation.retrieving.drop_while_operation

/**
 * Function 'dropWhile' returns the elements from the first one not matching the predicate to the end.
 * Is opposite to 'takeWhile' function.
 */
fun main() {
    // #1
    val targetValue_1 = 6
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of dropping the 'listOfString'" +
        "\n\twhile is met value with length not equal to '$targetValue_1': ${listOfString.dropWhile { it.length == 6}}"
    )

    // #2
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(
        "Show result of dropping the 'listOfNumber'" +
        "\n\twhile is met even value: ${listOfNumber.dropWhile { it % 2 == 1}}"
    )
}
