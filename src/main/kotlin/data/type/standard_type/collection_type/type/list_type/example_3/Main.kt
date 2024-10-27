package data.type.standard_type.collection_type.type.list_type.example_3

/**
 * Methods of the 'List' interface available.
 */
fun main() {
    // #1
    val ints_1 = List(10) { it + 101 }
    // Use:
    //      * 'iterator'    - to move throw the list
    //      * 'size'        - to check the size of the list
    //      * 'get'         - to read the value from the list
    var index = 0
    print("Show all items od the 'ints' list (iterator): ")
    while(ints_1.iterator().hasNext() && (index <= ints_1.size-1)) {
        print("\n\titem[$index]: ${ints_1.get(index++)}")
    }

    // #2
    // Use:
    //      * 'listIterator'                - to move throw the list forward and backward
    //      * []                            - to read the value from the list
    index = 3
    print("\n\nShow only few items of the 'ints' list starting from index $index (listIterator): ")
    while(ints_1.listIterator(index).hasPrevious()) {
        print("\n\titem[$index]: ${ints_1[index--]}")
    }

    // #3
    // Use:
    //      * 'isEmpty'         - to check if list contains at least one item
    //      * 'contains'        - to check if list contains specified value
    //      * 'containsAll'     - to check if list contains all the items of the another list
    val targetItem = 105
    val ints_2 = ints_1.map { it }
    println("\n\nShow answer on question about 'ints' list:" +
        "\n\tIs it empty: ${ints_1.isEmpty()}" +
        "\n\tContains value '$targetItem': ${ints_1.contains(targetItem)}" +
        "\n\tContains all values of 'ints_2' list: ${ints_1.containsAll(ints_2)}"
    )

    // #4
    // Use:
    //      * indexOf           - to get the index of the first occurrence of the specified element in the list or -1
    //      * lastIndexOf       - to get the index of the last occurrence of the specified element in the list or -1
    //      * subList           - to get a portion of list items according to 'fromIndex'/'toIndex' specified
    val targetFromIndex = 2
    val targetToIndex = 7
    println(
        "\nShow info about 'ints_1' list: " +
        "\n\tFirst occurrence of the $targetItem is in position: ${ints_1.indexOf(targetItem)}" +
        "\n\tLast occurrence of the $targetItem is in position: ${ints_1.lastIndexOf(targetItem)}" +
        "\n\tGet sublist of items between $targetFromIndex and $targetToIndex: ${ints_1.subList(
            targetFromIndex, targetToIndex
        )}"
    )
}
