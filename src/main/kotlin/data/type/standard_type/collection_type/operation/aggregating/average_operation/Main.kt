package data.type.standard_type.collection_type.operation.aggregating.average_operation

/**
 * Method calculates average of all numeric collection values with type:
 * Byte, Int, Short, Long, Float, Double:
 *      average(): Double
 */
fun main() {
    // #1
    // Use 'average' to calculate average value of all values in the collection.
    val listOfNumber = listOf(10.0, 2.0, 3.0, 40.0, 5.0)
    val result_1: Double = listOfNumber.average()

    // #2
    // Use 'average' to calculate average length of all words in the collection.
    val arrayOfString = arrayOf("apple", "banana", "cherry", "guava")
    val result_2 = arrayOfString.map { it.length }.average()

    println(
        "Show result of calculation apply to the:" +
        "\n\t'listOfNumber': $result_1" +
        "\n\t'arrayOfString': $result_2"
    )
}
