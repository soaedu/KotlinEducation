package data.type.standard_type.collection_type.operation.transforming.data.flatten_operation

/**
 * Method returns a single 'List' of all the elements of the nested collections.
 */
fun main() {
    // #1
    val listOfSet = listOf(
        setOf(1, 2, 3),
        setOf(4, 5, 6),
        setOf(1, 2)
    )
    val result_1 = listOfSet.flatten()

    // #2
    val listOfDepartment = listOf(
        listOf("Tom", "Bob"),
        listOf("Sam", "Mike", "Kate"),
        listOf("Tom", "Bill")
    )
    val result_2 = listOfDepartment.flatten()

    println(
        "Show result of transformation apply to the" +
        "\n\t'listOfSet' (one list with all items from all lists): $result_1" +
        "\n\t'listOfDepartment' (one list with all names from all lists): $result_2"
    )
}
