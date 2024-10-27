package data.type.standard_type.collection_type.operation.aggregating.scan_operation

/**
 * Method returns a sequence, containing successive accumulation values generated
 * by applying 'operation' from left to right to each element and current 'accumulator'
 * value that starts with 'initial' value.
 */
fun main() {
    // #1
    val listOfString = listOf("a", "b", "c", "d")
    val result_1 = listOfString.scan("s") { acc, string -> acc + string }

    // #2
    val listOfNumber = listOf(1, 2, 3, 4)
    val result_2 = listOfNumber.scan(0) { acc, number -> acc + number}
    val result_3 = listOfNumber.scan(1) { acc, number -> acc * number}
    val result_4 = listOfNumber.scan("") { acc, number -> acc + number}

    // #3
    val emptyList = emptyList<String>()
    val result_5 = emptyList.scan("s") { _, _ -> "X" }

    println(
        "Show result of aggregation apply to the" +
        "\n\t'listOfString': $result_1" +
        "\n\t'listOfNumber' (initial value '0'): $result_2" +
        "\n\t'listOfNumber' (initial value '1'): $result_3" +
        "\n\t'listOfNumber' (initial value empty string): $result_4" +
        "\n\t'emptyList': $result_5"
    )
}
