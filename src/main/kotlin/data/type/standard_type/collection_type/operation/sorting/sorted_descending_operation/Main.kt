package data.type.standard_type.collection_type.operation.sorting.sorted_descending_operation

import data.type.standard_type.collection_type.operation.Person

/**
 * Method organizes elements of the collection in a concrete order.
 *
 * It gives the same result as 'sorted' function but in reverse order.
 */
fun main() {
    // #1
    val listOfPeople_1 = listOf("Tom", "Mike", "Bob", "Sam", "Alice")
    val result_1 = listOfPeople_1.sortedDescending()

    // #2
    val listOfPeople_2 = listOf(
        Person("Alice", 13, false),
        Person("Bob", 26, true),
        Person("Carol", 31, true)
    )
    val result_2 = listOfPeople_2.sortedDescending()

    // #3
    val listOfNumber = listOf(3, 5, 2, -4, -6, 9, 1)
    val result_3 = listOfNumber.sortedDescending()

    // #4
    val listOfChar = listOf('b', 'A', 'a', ' ', 'B')
    val result_4 = listOfChar.sortedDescending()

    // #5
    val listOfBoolean = listOf(true, false, true)
    val result_5 = listOfBoolean.sortedDescending()

    println(
        "Show result of sorting apply to the" +
        "\n\t'listOfPeople_1': $result_1" +
        "\n\t'listOfPeople_2': $result_2" +
        "\n\t'listOfNumber': $result_3" +
        "\n\t'listOfChar': $result_4" +
        "\n\t'listOfBoolean': $result_5"
    )
}
