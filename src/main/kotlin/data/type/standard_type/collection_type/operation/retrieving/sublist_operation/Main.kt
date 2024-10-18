package data.type.standard_type.collection_type.operation.retrieving.sublist_operation

/**
 * Function 'subList' returns a part of the collection.
 * The parameters for the method are used to define a specified range of the 'list' between the:
 *     * fromIndex (inclusive)
 *     * toIndex (exclusive).
 *
 * The 'subList' method returns a view of the original 'list' and will change with it.
 * So, any structural changes in the original 'list' make the behavior of the view undefined.
 */
fun main() {
    // #1
    val targetIndexFrom_1 = 1
    val targetIndexTo_1 = 4
    val listOfString_1 = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of 'subList' operation applied to 'listOfString_1'" +
        "\n\twith indexes '$targetIndexFrom_1' and $targetIndexTo_1: " +
                "${listOfString_1.subList(targetIndexFrom_1, targetIndexTo_1)}"
    )

    // #2
    val targetIndexFrom_2 = 2
    val targetIndexTo_2 = 5
    val listOfString_2 = listOf("Tom", "Bob", "Sam", "Kate", "Alice", "Mike")
    println(
        "Show result of 'subList' operation applied to 'listOfString_2'" +
        "\n\twith indexes '$targetIndexFrom_2' and $targetIndexTo_2: " +
            "${listOfString_2.subList(targetIndexFrom_2, targetIndexTo_2)}"
    )
}
