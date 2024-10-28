package data.type.standard_type.collection_type.operation.retrieving.slice_operation

/**
 * Function 'slice' returns a part of the collection with elements on the definite indexes.
 *
 * Indexes are transmitted in function as:
 *      * IntRange
 *      * Collection<Iterable<Int>>
 */
fun main() {
    // #1
    val intRange_1 = 1..3
    val intRange_2 = 0..4 step 2
    val setOfIterable = setOf(3, 4, 0)
    val listOfString_1 = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of 'slice' operation applied to 'listOfString'" +
        "\n\twith range '$intRange_1': ${listOfString_1.slice(intRange_1)}" +
        "\n\twith range '$intRange_2': ${listOfString_1.slice(intRange_2)}" +
        "\n\twith set of iterable items '$setOfIterable': ${listOfString_1.slice(setOfIterable)}"
    )

    // #2
    val intRange_3 = 3..5
    val intRange_4 = 1..5 step 3
    val listOfIterable = listOf(1, 3, 5, 1)
    val listOfString_2 = listOf("Tom", "Bob", "Sam", "Kate", "Alice", "Mike")
    println(
        "Show result of 'slice' operation applied to 'listOfPeople'" +
        "\n\twith range '$intRange_3': ${listOfString_2.slice(intRange_3)}" +
        "\n\twith range '$intRange_4': ${listOfString_2.slice(intRange_4)}" +
        "\n\twith list of iterable items '$listOfIterable': ${listOfString_2.slice(listOfIterable)}"
    )
}
