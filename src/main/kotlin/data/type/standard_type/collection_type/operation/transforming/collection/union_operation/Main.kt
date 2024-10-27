package data.type.standard_type.collection_type.operation.transforming.collection.union_operation

/**
 * Method refers to combining the elements of two sets to create a new set that contains
 * all unique elements from both sets.
 */
fun main() {
    // #1
    val setOfNumber_1 = setOf(1, 2, 3)
    val setOfNumber_2 = setOf(4, 5)
    val result_1 = setOfNumber_1.union(setOfNumber_2)
    val result_2 = setOfNumber_2.union(setOfNumber_1)

    // #2
    val setOfNumber_3 = setOf(1, 2, 3, 4)
    val setOfNumber_4 = setOf(3, 4, 5, 6)
    val result_3 = setOfNumber_3.union(setOfNumber_4)

    println(
        "Show result of transformation apply to the" +
        "\n\t'setOfNumber_1' (set with all items from both collections with no repeat): $result_1" +
        "\n\t'setOfNumber_2' (set with all items from both collections with no repeat): $result_2" +
        "\n\t'setOfNumber_3' (set with all items from both collections with no repeat): $result_3"
    )
}
