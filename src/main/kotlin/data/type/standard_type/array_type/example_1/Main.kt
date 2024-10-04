package data.type.standard_type.array_type.example_1

import data.helpers.printItems

fun main() {
    // #1
    // Use 'Array' to create an array
    val intArray_1 = Array(3) { i -> i + 1 }

    // #2
    // Use 'arrayOf' to create an array
    val intArray_2 = arrayOf(1, 2, 3)

    // #3
    // Use 'intArrayOf' to create array
    val intArray_3 = intArrayOf(1, 2, 3)

    printItems("Show 'intArray_1' items", intArray_1)
    printItems("Show 'intArray_2' items", intArray_2)
    printItems("Show 'intArray_3' items", intArray_3)
}
