package data.type.standard_type.collection_type.type.sequence_type.example_2

import data.helpers.printItems
import data.type.standard_type.collection_type.operation.Person

/**
 * If we want to increase effectiveness of our code, we should use sequence instead collections
 * like: list, array, set, etc.
 * When we use sequence no intermediate collections will be created to hold elements, so
 * for a big amount of items performance will be noticeable better.
 */
fun main() {
    // #1
    // Use 'asSequence' to transform list to a sequence and perform mapping with filtering data.
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Person("Bob", 26, true),
        Person("Carol", 31, true)
    )
    val result_1 = listOfPeople.asSequence().map(Person::name).filter { it.startsWith("A") }.toList()

    // #2
    // Use operations (intermediate/terminal) with sequence.
    // When we use intermediate operation its execution will not be performed if terminal
    // operation not specified in the end of the chain.
    // Result of the terminal operation can be a collection, an element, a number or some object
    // as a result of other collection transformation.
    val result_2 = listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it)"); it * it }
        .filter { print("filter($it)"); it %2 == 0 }
    // Use 'for' loop to start execution of intermediate operations in chain without a
    // terminal operation.
    for (item in result_2) {
        print("\titem: $item")
    }
    val result_3 = result_2.toList()

    printItems(
        "\n\nShow result of sequence create from the list and filter perform",
        result_1
    )

    println(
        "Show result of 'intermediate' operations apply:" +
        "\n\twithout a terminal operation: $result_2" +
        "\n\twith a terminal operation: $result_3"
    )
}
