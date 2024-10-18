package data.type.standard_type.collection_type.operation.counting

import data.type.standard_type.collection_type.operation.Person

/**
 * Function 'count()' can be called:
 * 	* with no predicate and returns the number of elements in this collection.
 * 		fun <T> Iterable<T>.count(): Int
 * 	* with predicate and returns the number of elements matching the given predicate.
 * 		fun <T> Iterable<T>.count(predicate: (T) -> Boolean): Int
 */
fun main() {
    // #1
    val range = (1..100 step 3)
    println(
        "Show count result for operation 'count' applied to: " +
        "\n\t'range' answering on the question: " +
        "\n\t\tHow many items does it have? -> ${range.count()}"
    )

    // #2
    val targetValue_1 = 2
    val listOfNumbers = listOf(1, 2, 3, 2, 4, 3, 5, 2, 6)
    println(
        "Show count result for operation 'count' applied to: " +
        "\n\t'listOfNumbers' answering on the question: " +
        "\n\t\t1. How many times value '$targetValue_1' is repeated (for loop)? -> ${findRepeatedValuesUsingForLoop(targetValue_1, listOfNumbers)}" +
        "\n\t\t2. How many times value '$targetValue_1' is repeated (count)? -> ${listOfNumbers.count { it == targetValue_1 }}"

    )

    // #2
    val targetValue_2 = 27
    val canBeInClub27 = { p: Person -> p.age <= targetValue_2 }
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Person("Bob", 26, true),
        Person("Carol", 31, true)
    )
    println(
        "Show count result for operation 'count' applied to: " +
        "\n\t'listOfPeople' answering on the question: " +
        "\n\t\tHow many persons has age less or equal to '$targetValue_2'? -> ${listOfPeople.count(canBeInClub27)}"
    )
}

// #1
fun findRepeatedValuesUsingForLoop(value: Int, list: List<Int>): Int {
    var count = 0
    for (i in 0 until list.size - 1) {
        if (list[i] == value) {
            count++
        }
    }

    return count
}
