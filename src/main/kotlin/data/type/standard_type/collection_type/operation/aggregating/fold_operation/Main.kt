package data.type.standard_type.collection_type.operation.aggregating.fold_operation

/**
 * Method calculates the value as a result of applying 'operation' function to each item
 * of the collection.
 *      fold(initial: R, operation: (acc: R, T) -> R): R
 */
fun main() {
    // #1
    val targetValue_1 = 0.0
    val targetValue_2 = ""
    val targetValue_3 = 1
    val listOfNumber = listOf(10, 2, 3, 40, 5)
    val result_1: Double = listOfNumber.fold(targetValue_1) { acc, num ->
        acc + num
    }
    val result_2 = listOfNumber.fold(targetValue_2) { acc, num ->
        acc + num + " "
    }
    val result_3 = listOfNumber.fold(targetValue_3) { acc, num ->
        acc * num
    }

    // #2
    val targetValue_4 = "People ->"
    val listOfString = listOf("Tom", "Bob", "Kate", "Sam", "Alice")
    val result_4 = listOfString.fold(
        targetValue_4,
        { prefix, name -> "$prefix $name" }
    )

    println(
        "Show result of aggregation apply to the" +
        "\n\t'listOfNumber' (initial value '$targetValue_1'): $result_1" +
        "\n\t'listOfNumber' (initial value '$targetValue_2'): $result_2" +
        "\n\t'listOfNumber' (initial value '$targetValue_3'): $result_3" +
        "\n\t'listOfString': $result_4"
    )
}
