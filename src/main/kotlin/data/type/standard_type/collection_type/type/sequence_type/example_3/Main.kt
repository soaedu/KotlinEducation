package data.type.standard_type.collection_type.type.sequence_type.example_3

import data.type.standard_type.collection_type.operation.Person

fun main() {
    // It is important the order of applying intermediate functions.
    // Incorrect order can affect performance.
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Person("Bob", 26, true),
        Person("Carol", 31, true)
    )

    // #1
    // Use incorrect order to map and then filter sequence.
    val result_1 = listOfPeople.asSequence()
        .map { print("name(#1): ${it.name}"); it.name }
        .filter { it.length > 3 }.toList()

    println()

    // #2
    // Use correct order to filter and then map sequence.
    val result_2 = listOfPeople.asSequence()
        .filter { it.name.length > 3 }
        .map { print("name(#2): ${it.name}"); it.name }.toList()

    println(
        "\n\nShow result of:" +
        "\n\tincorrect order use: $result_1" +
        "\n\tcorrect order use: $result_2"
    )
}
