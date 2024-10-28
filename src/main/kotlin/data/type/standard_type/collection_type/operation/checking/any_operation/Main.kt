package data.type.standard_type.collection_type.operation.checking.any_operation

import data.type.standard_type.collection_type.operation.Person

/**
 * Method to check if at least one element of the collection match to the case.
 */
fun main() {
    // #1
    val targetValue_1 = 10
    val ints = listOf(10, 2, 35, 44, 58)
    println(
        "Show check result for operation 'any' applied to: " +
        "\n\t'list' answering on the question: " +
        "Does any item is less than '$targetValue_1'? -> ${ints.any { it < targetValue_1 }}"
    )

    // #2
    // Negation symbol is hard to notice, that's why it's better to use 'any()' in such case.
    // Use 'any' without predicate (check collection emptiness, returns 'true' if there are elements)
    val targetValue_2 = 3
    val listOfNumbers = listOf(1, 2, 3)
    println(
        "Show check result for operations '!all/any' applied to: " +
        "\n\t'listOfNumbers' answering on the question: " +
        "\n\t\t1. Do not all items are equal to '$targetValue_2'? -> ${!listOfNumbers.all { it == targetValue_2 }}" +
        "\n\t\t2. Do any item is not equal to '$targetValue_2'? -> ${listOfNumbers.any { it != targetValue_2 }}" +
        "\n\t\t3. Is it empty? -> ${listOfNumbers.any()}"
    )

    // #3
    // Vacuous truth (for empty list returns wrong result - always 'true').
    // Use 'any' without predicate (check collection emptiness, returns 'false' if there is no elements)
    val targetValue_3 = 5
    val emptyList = emptyList<Int>()
    println(
        "Show check result for operation 'any' applied to: " +
        "\n\t'emptyList' answering on the question: " +
        "\n\t\t1. Do any item is greater than '$targetValue_3'? -> ${emptyList.any { it > targetValue_3 }}" +
        "\n\t\t2. Is it empty? -> ${emptyList.any()}"
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
        "Show check result for operation 'any' applied to: " +
        "\n\t'listOfPeople' answering on the question: " +
        "\n\t\t1. Do any person has age less or equal to '$targetValue_4'? -> ${listOfPeople.any(canBeInClub27)}" +
        "\n\t\t2. Do any person is adult? -> ${listOfPeople.any { it.isAdult(it)}}" +
        "\n\t\t3. Do any person is a child? -> ${listOfPeople.any { it.isChild(it)}}" +
        "\n\t\t4. Do any person is male? -> ${listOfPeople.any { it.isMale(it)}}" +
        "\n\t\t5. Do any person is female? -> ${listOfPeople.any { it.isFemale(it)}}"
    )
}
