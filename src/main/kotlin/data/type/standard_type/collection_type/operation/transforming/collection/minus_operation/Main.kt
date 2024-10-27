package data.type.standard_type.collection_type.operation.transforming.collection.minus_operation

/**
 * Method creates a new collection with:
 *      * element(s) of the first collection without elements from the second collection
 *          or
 *      * element(s) of the collection without all occurrences of the specified single element
 */
fun main() {
    // #1
    // Use 'minus'/'-' operator to remove single or a few elements.
    val targetValue_1 = "three"
    val listOfString_1 = listOf("three", "one", "twenty")
    val listOfString_2 = listOf("three", "twenty")
    val result_1 = listOfString_1.minus(listOfString_2)
    val result_2 = listOfString_1 - listOfString_2
    val result_3 = listOfString_1 - targetValue_1

    // #2
    // Use 'minus'/'-' operator to remove single or a few elements.
    val targetValue_2 = "Bob"
    val listOfPeople_1 = listOf("Tom", "Bob", "Sam", "Kate")
    val listOfPeople_2 = listOf("Mike", "Kate")
    val result_4 = listOfPeople_1.minus(listOfPeople_2)
    val result_5 = listOfPeople_1 - listOfPeople_2
    val result_6 = listOfPeople_1 - targetValue_2

    println(
        "Show result of transformation apply to the" +
        "\n\t'listOfString_1' ('minus' two items): $result_1" +
        "\n\t'listOfString_1' ('-' two items): $result_2" +
        "\n\t'listOfString_1' ('-' single item): $result_3" +
        "\n\t'listOfPeople_1' ('minus' two items): $result_4" +
        "\n\t'listOfPeople_1' ('-' two items): $result_5" +
        "\n\t'listOfPeople_1' ('-' single item): $result_6"
    )
}
