package data.type.standard_type.collection_type.operation.transforming.data.associate_operation

import data.type.standard_type.collection_type.operation.Person

/**
 * Method creates a new 'Map' from scratch, taking a lambda that returns a 'Pair'.
 */
fun main() {
    // #1
    // Use 'associate' to create a 'map' with key-value pairs created from
    // split values from the 'list'.
    val listOfString_1 = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    val result_1 = listOfString_1.associate { name ->
        name.split(" ").let { it[0] to it[1] }
    }

    // #2
    // Use 'associate' to create a 'map' with key-value pairs created from
    // items and their length from the 'list'.
    val listOfString_2 = listOf("one", "two", "three", "four", "five")
    val result_2 = listOfString_2.associate { it to it.length }

    // #3
    // Use 'associate' to create a 'map' with key-value pairs created from
    // the function calculating key and value from items of the 'list'.
    val listOfNumber = intArrayOf(1, 2, 3, 4)
    val result_3 = listOfNumber.associate { 'a' + it to 10 * it }

    // #4
    // Use 'associate' to create a 'map' with key-value pairs created from
    // the function calculating key and value from persons data in the 'list'.
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Person("Bob", 26, true),
        Person("Carol", 31, true)
    )
    val result_4 = listOfPeople.associate { it.name to it.age }

    println(
        "Show result of transformation apply to the" +
        "\n\t'listOfString_1' (map with 'list name' first split part as key and second as value): $result_1" +
        "\n\t'listOfString_2' (map with 'list value' as key and its length as value): $result_2" +
        "\n\t'listOfNumber' (map with 'list value' as key and calculation result as value): $result_3" +
        "\n\t'listOfPeople' (map with 'person name' as key and 'person age' as value): $result_4"
    )
}
