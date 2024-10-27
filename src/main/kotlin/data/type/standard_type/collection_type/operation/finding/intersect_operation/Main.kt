package data.type.standard_type.collection_type.operation.finding.intersect_operation

/**
 * Method returns a set of items that exists in both compared collections.
 */
fun main() {
    // #1
    // Use 'intersect' to get only matching fruits.
    val arrayOfString_1 = arrayOf("apple", "orange", "banana", "grape")
    val arrayOfString_2 = arrayOf("orange", "grape", "kiwi", "melon")
    val result_1 = arrayOfString_1.intersect(arrayOfString_2.toSet())

    // #2
    // Use 'intersect' to get only matching numbers.
    val listOfNumber_1 = listOf(1, 2, 3, 4, 5)
    val listOfNumber_2 = listOf(3, 4, 5, 6, 7)
    val result_2 = listOfNumber_1.intersect(listOfNumber_2)

    println(
        "Show result of finding apply to the:" +
        "\n\t'arrayOfString_1' and 'arrayOfString_2': $result_1" +
        "\n\t'listOfNumber_1' and 'listOfNumber_2': $result_2"
    )
}
