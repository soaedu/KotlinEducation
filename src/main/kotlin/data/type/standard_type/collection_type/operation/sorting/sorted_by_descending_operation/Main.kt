package data.type.standard_type.collection_type.operation.sorting.sorted_by_descending_operation

import data.type.standard_type.collection_type.operation.Person

/**
 * Method organizes elements of the collection in a concrete order using specified criteria.
 */
fun main() {
    // #1
    val listOfPeople_1 = listOf("Tom", "Mike", "Bob", "Sam", "Alice")
    val result_1 = listOfPeople_1.sortedByDescending { it.length }

    // #2
    val listOfPeople_2 = listOf(
        Person("Alice", 23, false),
        Person("Bob", 26, true),
        Person("Carol", 31, false),
        Person("Anthony", 19, true),
        Person("Violet", 18, false)
    )
    val result_2 = listOfPeople_2.sortedByDescending { it.name }
    val result_3 = listOfPeople_2.sortedByDescending { it.age }

    // #3
    val listOfNumber = listOf(3, 5, 2, -4, -6, 9, 1)
    val result_4 = listOfNumber.sortedByDescending { it }

    // #4
    val listOfChar = listOf('b', 'A', 'a', ' ', 'B')
    val result_5 = listOfChar.sortedByDescending { it }

    // #5
    val listOfBoolean = listOf(true, false, true)
    val result_6 = listOfBoolean.sortedByDescending { it }

    println(
        "Show result of sorting apply to the" +
        "\n\t'listOfPeople_1' ('sortedByDescending' by length): $result_1" +
        "\n\t'listOfPeople_2' ('sortedByDescending' by name): $result_2" +
        "\n\t'listOfPeople_2' ('sortedByDescending' by age): $result_3" +
        "\n\t'listOfNumber': $result_4" +
        "\n\t'listOfChar': $result_5" +
        "\n\t'listOfBoolean': $result_6"
    )
}
