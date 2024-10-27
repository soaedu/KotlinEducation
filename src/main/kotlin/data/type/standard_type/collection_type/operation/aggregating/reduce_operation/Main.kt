package data.type.standard_type.collection_type.operation.aggregating.reduce_operation

/**
 * Method calculates the value as a result of applying 'operation' function to each item of
 * the collection:
 *      reduce(operation: (acc: S, T) -> S): S
 *
 * We do not define the 'initial' value, and it uses the first element as the
 * 'initial' value.
 */
fun main() {
    // #1
    val listOfNumber = listOf(1, 2, 3, 4, 5)
    val result_1 = listOfNumber.reduce { acc, value ->
        acc + value
    }
    val result_2 = listOfNumber.runningReduce { acc, value ->
        acc + value
    }
    val result_3 = listOfNumber.reduceRight { acc, value ->
        acc + value
    }

    // #2
    val operation = { a: String, b: String -> "$a $b" }
    val listOfPeople = listOf("Tom", "Bob", "Kate", "Sam", "Alice")
    val result_4 = listOfPeople.reduce(operation)

    // #3
    // Use 'reduce' with an empty collection.
    val emptyList = emptyList<String>()
    // error: UnsupportedOperationException
    // val result_5 = emptyList.reduce { acc, value -> acc + value }

    println(
        "Show result of aggregation apply to the" +
        "\n\t'listOfNumber' ('reduce'): $result_1" +
        "\n\t'listOfNumber' ('runningReduce'): $result_2" +
        "\n\t'listOfNumber' ('reduceRight'): $result_3" +
        "\n\t'listOfPeople' ('reduce'): $result_4"
        // "\n\t'emptyList': $result_5"
    )
}
