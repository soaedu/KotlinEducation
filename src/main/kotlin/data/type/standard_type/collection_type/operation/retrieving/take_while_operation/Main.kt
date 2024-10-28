package data.type.standard_type.collection_type.operation.retrieving.take_while_operation

/**
 * Function 'takeWhile' is used to return a list containing first elements satisfying
 * the given predicate.
 *
 * We must be careful when using this function on unsorted collections, as 'takeWhile'
 * will go iteratively from start to end until the condition is no longer satisfied.
 * We can get an empty list if the first item does not satisfy to condition.
 *
 * Return type is not an 'IntArray', but rather a 'List<Int>'.
 */
fun main() {
    // #1
    val targetValue_1 = 4
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of taking items from the 'listOfString'" +
        "\n\twhile element length is greater than '$targetValue_1': " +
                "${listOfString.takeWhile { it.length >= targetValue_1 }}"
    )

    // #2
    val targetValue_2 = 5
    val listOfNumber = listOf(5, 3, 2, 4, 1)
    val predicate_1 = { number: Int -> number == targetValue_2 }
    val predicate_2 = { number: Int -> number < targetValue_2 }
    println(
        "Show result of taking items from the 'listOfNumber' while " +
        "\n\telement is equal to '$targetValue_2': ${listOfNumber.takeWhile(predicate_1)}" +
        "\n\telement is less than '$targetValue_2': ${listOfNumber.takeWhile(predicate_2)}"
    )
}
