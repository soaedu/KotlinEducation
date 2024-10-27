package data.type.standard_type.collection_type.operation.transforming.data.associate_by_operation

import data.type.standard_type.collection_type.operation.Person

/**
 * Method creates a new 'Map' in which the elements of the original collection are values,
 * and keys are produced from them by the given transformation function.
 */
fun main() {
    // #1
    val listOfString = listOf("Alex", "Ben", "Cal")
    val result_1 = listOfString.associateBy { it.first() }

    // #2
    val listOfPeople = listOf(
        Person("Alice", 31, false),
        Person("Bob", 26, true),
        Person("Carol", 31, true)
    )
    val result_2 = listOfPeople.associateBy { it.name }
    val result_3 = listOfPeople.associateBy { it.age }

    println(
        "Show result of transformation apply to the" +
        "\n\t'listOfString' (map with 'list values' as keys): $result_1" +
        "\n\t'listOfPeople' (map with 'persons names' as keys): $result_2" +
        "\n\t'listOfPeople' (map with 'persons ages' as keys): $result_3"
    )
}
