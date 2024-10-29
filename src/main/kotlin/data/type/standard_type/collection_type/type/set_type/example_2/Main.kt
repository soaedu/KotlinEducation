package data.type.standard_type.collection_type.type.set_type.example_2

import data.helpers.printItems

fun main() {
    // #1
    // Use 'toSet()' function to convert 'List<String>' into the 'Set<String>'.
    val listOfString_1 = listOf("Tom", "Bob", "Sam", "Tom", "Bob", "Alex")
    val setOfString = listOfString_1.toSet()
    // impossible
    // setOfString.add("Kate")
    printItems(
        "Show result of casting 'listOfString' to set",
        setOfString
    )

    // #2
    // Use 'toList()' function to convert 'Set<String>' to the 'List<String>'.
    val listOfString_2 = setOfString.toList()
    // impossible
    // listOfString_2.add("Kate")
    printItems(
        "Show result of casting 'setOfString' to list",
        listOfString_2
    )

    // #3
    // Use 'toMutableList()' function to convert 'Set<String>' to the 'MutableList<String>'
    // and add one more item.
    val listOfString_3 = setOfString.toMutableList()
    listOfString_3.add("Kate")
    printItems(
        "Show result of casting 'setOfString' to mutable list",
        listOfString_3
    )

    // #4
    // Use 'toLongArray()' function to convert 'MutableSet<Long>' to the 'LongArray'
    // and add one more item.
    val setOfNumber: MutableSet<Long> = mutableSetOf(
        20161028141216,
        20161029121211,
        20161029121211
    )
    val arrayOfNumber_1 = setOfNumber.toLongArray()
    arrayOfNumber_1[1] = 20161029121212
    printItems(
        "Show result of casting 'setOfNumber' to mutable array (toLongArray)",
        arrayOfNumber_1
    )

    // #5
    // Use 'toTypedArray()' function to convert 'MutableSet<Long>' to the 'Array<Long>'
    // and add one more item.
    val arrayOfNumber_2 = setOfNumber.toTypedArray()
    arrayOfNumber_1[1] = 20161029121215
    printItems(
        "Show result of casting 'setOfNumber' to read-only array (toTypedArray)",
        arrayOfNumber_2
    )
}
