package data.type.standard_type.collection_type.operation.sorting.sorted_by_operation

import data.type.standard_type.collection_type.operation.Person

/**
 * Method organizes elements of the collection by one of the object properties
 * in a concrete order.
 */
fun main() {
    // #1
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Person("Bob", 26, true),
        Person("Carol", 31, true),
        Person("Tom", 23, true),
        Person("Caroline", 18, false),
    )
    val result_1 = listOfPeople.sortedBy { it.name }
    val result_2 = listOfPeople.sortedBy { it.age }

    // #2
    val listOfString = listOf("Alex", "Bob", "Celine")
    val result_3 = listOfString.sortedBy { it.length }
    val result_4 = listOfString.sortedBy { it.last() }

    println(
        "Show result of sorting apply to the" +
        "\n\t'listOfPeople' ('sortedBy' by name): $result_1" +
        "\n\t'listOfPeople' ('sortedBy' by age): $result_2" +
        "\n\t'listOfString' ('sortedBy' by length): $result_3" +
        "\n\t'listOfString' ('sortedBy' by last letter): $result_4"
    )
}
