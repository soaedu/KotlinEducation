package data.type.standard_type.collection_type.type.list_type.example_4

/**
 * Methods of the 'MutableList' interface available.
 */
fun main() {
    // #1
    val ints_1 = MutableList(10) { it + 101 }
    // Use:
    //      * 'listIterator'    - to move throw the mutable list forward and backward
    //      * 'get'/[]          - to read the value from the mutable list
    //      * 'set'/[]          - to write the value to the mutable list
    var index = 3
    print("Show only few items of the 'ints_1' list starting from index '$index' (listIterator): ")
    while(ints_1.listIterator(index).hasPrevious() && (index >= 1)) {
        val value = ints_1.get(index)

        if (index %2 == 0) ints_1.set(index, (value * 2))

        print("\n\titem[$index]: ${ints_1[index--]}")
    }

    // #2
    // Use:
    //      * +=element/add(element)/add(index, element)    - to add a single element to a mutable list
    //      * remove(element)/removeAt(index)               - to remove a single element from the mutable list
    val newInt_1 = 115
    val newInt_2 = 125
    val newInt_3 = 135
    with(ints_1) {
        this += newInt_1
        add(newInt_2)
        add(7, newInt_3)
    }
    println(
        "\n\nShow items of the 'ints_1' mutable list after: " +
        "\n\tadding values '$newInt_1', '$newInt_2' and '$newInt_3': $ints_1"
    )
    val removeItemIndex = 7
    with(ints_1) {
        remove(newInt_1)
        removeAt(removeItemIndex)
    }
    println(
        "\nShow items of the 'ints_1' mutable list after: " +
        "\n\tremoving values '$newInt_1' and item in position '$removeItemIndex': $ints_1"
    )

    // #3
    // Use:
    //      * +=elements/addAll(elements)/addAll(index, elements)   - to add multiple elements to a mutable list
    //      * removeAll(elements)/clear()                           - to remove all elements from the mutable list
    //      * retainAll(elements)                                   - to remove all elements from the mutable list
    //                                                                  that absent in the collection represented
    //                                                                  by 'elements' parameter.
    val ints_2_1 = mutableListOf<Int>()
    val ints_2_2 = listOf(35, 36, 37, 38)
    val ints_2_3 = listOf(65, 66, 67)
    with(ints_2_1) {
        this += ints_2_2
        addAll(ints_2_3)
    }
    println(
        "\nShow items of the 'ints_2_1' mutable list after adding all values from: " +
        "\n\t'ints_2_2': $ints_2_2" +
        "\n\t'ints_2_3': $ints_2_3" +
        "\n\tresult: $ints_2_1"
    )
    val ints_3_1 = mutableListOf(88, 89, 90, 92, 97)
    val ints_3_2 = listOf(45, 46, 47)
    val addFromIndex = 2
    ints_3_1.addAll(addFromIndex, ints_3_2)
    println(
        "\nShow items of the 'ints_3_1' mutable list after adding values from: " +
        "\n\t'ints_3_2' with values from position '$addFromIndex': $ints_3_2" +
        "\n\tresult: $ints_3_1"
    )
    val ints_4_1 = mutableListOf(11, 12, 13, 14, 15)
    val ints_4_2 = listOf(13, 15)
    ints_4_1.retainAll(ints_4_2)
    println(
        "\nShow items of the 'ints_4_1' mutable list after retaining values that exists in: " +
        "\n\t'ints_4_2': $ints_4_2" +
        "\n\tresult: $ints_4_1"
    )
    val ints_5_1 = mutableListOf(15, 25, 35, 45)
    val ints_5_2 = listOf(25, 45)
    ints_5_1.removeAll(ints_5_2)
    println(
        "\nShow items of the 'ints_5_1' mutable list after removing all values that exists in: " +
        "\n\t'ints_5_2': $ints_5_2" +
        "\n\tresult: $ints_5_1"
    )
    val ints_6 = mutableListOf(17, 18, 19, 20)
    ints_6.clear()
    println(
        "\nShow items of the 'ints_6' mutable list after: " +
        "\n\tclear operation done: $ints_6"
    )
}
