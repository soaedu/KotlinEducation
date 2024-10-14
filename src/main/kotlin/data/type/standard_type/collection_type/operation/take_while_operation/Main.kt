package data.type.standard_type.collection_type.operation.take_while_operation

/**
 * Method 'takeLast(n)' is an extension method that returns all elements while they match to a given predicate.
 *
 * Return type is not an 'IntArray', but rather a 'List<Int>'.
 */
fun main() {
    val lessThanValue = 5
    val intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    val takeWhileResult = intArray.takeWhile { it < lessThanValue }
    println("Show items that are less than $lessThanValue of the 'intArray': ${takeWhileResult.joinToString(",")}")
}
