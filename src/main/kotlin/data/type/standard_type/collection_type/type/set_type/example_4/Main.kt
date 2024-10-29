package data.type.standard_type.collection_type.type.set_type.example_4

/**
 * Methods of the 'MutableSet' interface available.
 */
fun main() {
    val setOfNumber_1 = mutableSetOf(1, 1, 2, 3, 3, 4, 5)

    // #1
    // Use:
    //      * iterator              - to move throw the mutableSet
    print("Show all items of the 'setOfNumber_1' (iterator): ")
    for (number in setOfNumber_1) {
        print("\n\titem: $number")
    }

    // #2
    // Use:
    //      * add(element)          - to add a single element to a mutable set
    //      * remove(element)       - to remove a single element from the mutable set
    val targetValue_1 = 8
    val targetValue_2 = 2
    setOfNumber_1.add(targetValue_1)
    setOfNumber_1.remove(targetValue_2)
    println(
        "\nShow items of the 'setOfNumber_1' after performing operation" +
        "\n\t'add' value '$targetValue_1': $setOfNumber_1" +
        "\n\t'remove' value '$targetValue_2': $setOfNumber_1"
    )

    // #3
    // Use:
    //      * addAll(elements)              - to add multiple elements to a mutable set
    //      * removeAll(elements)/clear()   - to remove all elements from the mutable set
    //      * retainAll(elements)           - to remove all elements from the mutable set
    //                                          that absent in the collection represented
    //                                          by 'elements' parameter.
    val setOfNumber_2_1 = mutableSetOf<Int>()
    val setOfNumber_2_2 = setOf(8, 3, 4, 8, 7, 1)
    val setOfNumber_3 = setOf(8, 12, 1)
    val setOfNumber_4 = setOf(1, 3, 5)
    setOfNumber_2_1.addAll(setOfNumber_2_2)
    println(
        "\nShow items of the 'setOfNumber_2_1' after performing operation" +
        "\n\t'addAll' values from '$setOfNumber_2_2': $setOfNumber_2_1"
    )

    setOfNumber_2_1.removeAll(setOfNumber_3)
    println(
        "\nShow items of the 'setOfNumber_2_1' after performing operation" +
        "\n\t'removeAll' values from '$setOfNumber_3': $setOfNumber_2_1"
    )

    setOfNumber_2_1.retainAll(setOfNumber_4)
    println(
        "\nShow items of the 'setOfNumber_2_1' after performing operation" +
        "\n\t'retainAll' values from '$setOfNumber_4': $setOfNumber_2_1"
    )

    setOfNumber_2_1.clear()
    println(
        "\nShow items of the 'setOfNumber_2_1' after performing operation" +
        "\n\t'clear': $setOfNumber_2_1"
    )
}
