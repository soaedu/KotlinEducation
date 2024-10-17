package data.type.standard_type.collection_type.operation.checking_operation.none_operation

import data.type.standard_type.collection_type.operation.Person

/**
 * Method to check if none of the elements of the collection match to the case.
 */
fun main() {
    // #1
    val targetValue_1 = 10
    val ints = listOf(11, 2, 35, 44, 58)
    println(
        "Show check result for operation 'none' applied to: " +
        "\n\t'list' answering on the question: " +
        "Does none item is equal to '$targetValue_1'? -> ${ints.none { it == targetValue_1 }}"
    )

    // #2
    // Use 'none' without predicate (check collection emptiness, returns 'false' if there are elements)
    val targetValue_2 = 3
    val listOfNumbers = listOf(1, 2, 3)
    println(
        "Show check result for operations 'none' applied to: " +
        "\n\t'listOfNumbers' answering on the question: " +
        "\n\t\t1. Do none item is equal to '$targetValue_2'? -> ${listOfNumbers.none { it == targetValue_2 }}" +
        "\n\t\t2. Is it empty? -> ${listOfNumbers.none()}"
    )

    // #3
    // Use 'none' without predicate (check collection emptiness, returns 'true' if there is no elements)
    val targetValue_3 = 5
    val emptyList = emptyList<Int>()
    println(
        "Show check result for operation 'none' applied to: " +
        "\n\t'emptyList' answering on the question: " +
        "\n\t\t1. Do none item is greater than '$targetValue_3'? -> ${emptyList.none { it > targetValue_3 }}" +
        "\n\t\t2. Is it empty? -> ${emptyList.none()}"
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
        "Show check result for operation 'none' applied to: " +
        "\n\t'listOfPeople' answering on the question: " +
        "\n\t\t1. Do none person has age less or equal to '$targetValue_4'? -> ${listOfPeople.none(canBeInClub27)}" +
        "\n\t\t2. Do none person is adult? -> ${listOfPeople.none { it.isAdult(it)}}" +
        "\n\t\t3. Do none person is a child? -> ${listOfPeople.none { it.isChild(it)}}" +
        "\n\t\t4. Do none person is male? -> ${listOfPeople.none { it.isMale(it)}}" +
        "\n\t\t5. Do none person is female? -> ${listOfPeople.none { it.isFemale(it)}}"
    )
}
