package data.type.standard_type.collection_type.operation.map_operation

/**
 * Method 'map()' allows us to translate the underlying element type to a different one.
 */
fun main() {
    val intArray = intArrayOf(1, 2, 3)
    val mapResult = intArray.map { element -> "Item ${element.toString()}" }
    println("Show all transformed items of the 'intArray': $mapResult")
}
