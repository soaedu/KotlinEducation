package data.type.standard_type.collection_type.operation.flat_map_operation

/**
 * Method 'flatMap()' is an extension method that returns a merged list of all the collections
 * returned by our transformation lambda.
 *
 * It is expected that our lambda function return type is 'Iterable<T>'.
 * This method flattens the sequence of 'Iterable' instances.
 */
fun main() {
    val intArray = intArrayOf(1, 2, 3)
    val flatMapResult = intArray.flatMap { element -> intArrayOf(element, element).asIterable() }
    println("Show doubled each item of the 'intArray': $flatMapResult")
}
