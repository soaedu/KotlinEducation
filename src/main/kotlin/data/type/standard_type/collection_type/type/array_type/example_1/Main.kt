package data.type.standard_type.collection_type.type.array_type.example_1

import data.helpers.printItems

fun main() {
    // #1
    // Use 'Array' to create an array
    val intArray_1 = Array(3) { i -> i + 1 }

    // #2
    // Use 'arrayOf' to create an array
    val intArray_2 = arrayOf(1, 2, 3)

    // #3
    // Use 'intArrayOf' to create an array
    val intArray_3 = intArrayOf(1, 2, 3)

    // #4
    // Use 'arrayOfNulls' to create an array of 'nulls'
    val stringArray_1 = arrayOfNulls<String>(3)
    stringArray_1[0] = "a"
    stringArray_1[1] = "b"

    // #5
    // Use 'emptyArray' to create an array
    val longArray_1 = emptyArray<Long>()

    printItems("Show 'intArray_1' items", intArray_1)
    printItems("Show 'intArray_2' items", intArray_2)
    printItems("Show 'intArray_3' items", intArray_3)
    printItems("Show 'stringArray_1' items", stringArray_1)
    printItems("Show 'longArray_1' items", longArray_1)
}
