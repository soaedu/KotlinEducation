package data.type.standard_type.collection_type.operation.filter_indexed_operation

import syntax.functional_programming.function_type.anonymous_func.higher_order_func.example_3.joinToString

/**
 * Method 'filterIndexed(...)' is an extension method that returns every element that satisfy
 * to a given predicate.
 */
fun main() {
    val itemToTake = 3
    val intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    val filterResult = intArray.filterIndexed { index, _ ->
        if (index < itemToTake) index == (itemToTake - 1)
        else (index + 1) % itemToTake == 0
    }.joinToString(",")
    println("Show every $itemToTake item of the 'intArray': $filterResult")
}
