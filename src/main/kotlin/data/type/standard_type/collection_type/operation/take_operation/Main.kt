package data.type.standard_type.collection_type.operation.take_operation

/**
 * Method 'take(n)' is an extension method that returns to the caller the first 'n' elements
 * of the target collection.
 *
 * Return type is not an 'IntArray', but rather a 'List<Int>'.
 */
fun main() {
    val itemsToTake = 3
    val intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    println("Show the first $itemsToTake items of the 'intArray': ${intArray.take(itemsToTake)}")
}
