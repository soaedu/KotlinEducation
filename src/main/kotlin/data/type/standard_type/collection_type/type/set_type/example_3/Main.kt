package data.type.standard_type.collection_type.type.set_type.example_3

/**
 * Methods of the 'Set' interface available.
 */
fun main() {
    val setOfNumber_1 = setOf(1, 1, 2, 3, 3, 4, 5)

    // #1
    // Use:
    //      * iterator      - to move throw the set
    print("Show all items of the 'setOfNumber' (iterator): ")
    for (number in setOfNumber_1) {
        print("\n\titem: $number")
    }

    // #2
    // Use:
    //      * size          - to check the size of the list
    //      * isEmpty       - to check if map contains at least one item
    //      * contains      - to check if set contains specified value
    //      * containsAll   - to check if set contains all the items of the another set
    val targetValue = 3
    val setOfNumber_2 = setOf(1, 1, 3, 3, 5)
    val result_1 = setOfNumber_1.size
    val result_2 = setOfNumber_1.isEmpty()
    val result_3 = setOfNumber_1.contains(targetValue)
    val result_4 = setOfNumber_1.containsAll(setOfNumber_2)
    println(
        "\nShow info about 'setOfNumber_1':" +
        "\n\tSize: $result_1" +
        "\n\tIs it empty: $result_2" +
        "\n\tContains value '$targetValue': $result_3" +
        "\n\tContains all values of 'setOfNumber_2': $result_4"
    )
}
