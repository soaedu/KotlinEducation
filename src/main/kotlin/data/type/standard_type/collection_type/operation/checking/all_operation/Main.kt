package data.type.standard_type.collection_type.operation.checking.all_operation

import data.type.standard_type.collection_type.operation.Person

/**
 * Method to check if all elements of the collection match to the case.
 */
fun main() {
    // #1
    val targetValue_1 = 10
    val ints = listOf(1, 2, 3, 4, 5)
    println(
        "Show check result for operation 'all' applied to: " +
        "\n\t'list' answering on the question: " +
        "Are all items less than '$targetValue_1'? -> ${ints.all { it < targetValue_1 }}"
    )

    // #2
    // Negation symbol is hard to notice, that's why it's better to use 'any()' in such case
    val targetValue_2 = 3
    val listOfNumbers = listOf(1, 2, 3)
    println(
        "Show check result for operation '!all' applied to: " +
        "\n\t'listOfNumbers' answering on the question: " +
        "Do not all items are equal to '$targetValue_2'? -> ${!listOfNumbers.all { it == targetValue_2 }}"
    )

    // #3
    // Vacuous truth (for empty list returns wrong result - always 'true').
    val targetValue_3 = 5
    val emptyList = emptyList<Int>()
    println(
        "Show check result for operation 'all' applied to: " +
        "\n\t'emptyList' answering on the question: " +
        "Do all items are greater than '$targetValue_3'? -> ${emptyList.all { it > targetValue_3 }}"
    )

    // #4
    val targetValue_4 = 27
    val canBeInClub27 = { p: Person -> p.age <= targetValue_4 }
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Person("Bob", 26, true),
        Person("Carol", 31, true)
    )

    println(
        "Show check result for operation 'all' applied to: " +
        "\n\t'listOfPeople answering on the question: " +
        "\n\t\t1. Do all persons has age less or equal to '$targetValue_4'? -> ${listOfPeople.all(canBeInClub27)}" +
        "\n\t\t2. Do all persons are adult? -> ${listOfPeople.all { it.isAdult(it)}}" +
        "\n\t\t3. Do all persons are children? -> ${listOfPeople.all { it.isChild(it)}}" +
        "\n\t\t4. Do all persons are male? -> ${listOfPeople.all { it.isMale(it)}}" +
        "\n\t\t5. Do all persons are female? -> ${listOfPeople.all { it.isFemale(it)}}"
    )
}
