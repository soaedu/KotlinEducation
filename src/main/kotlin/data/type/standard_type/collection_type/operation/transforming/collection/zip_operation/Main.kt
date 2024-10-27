package data.type.standard_type.collection_type.operation.transforming.collection.zip_operation

/**
 * Method combines two lists by mimicking the behavior of the zipper on our jacket, pairing
 * adjacent 'List' elements.
 */
fun main() {
    // #1
    val range_1 = 0..4
    val range_2 = 0..10
    val listOfString_1 = listOf("a", "b", "c", "d")
    val listOfString_2 = listOf("q", "r", "s", "t")
    val result_1 = listOfString_1.zip(listOfString_2)
    val result_2 = listOfString_1.zip(range_1)
    val result_3 = (range_2).zip(listOfString_2)

    // #2
    val listOfString_3 = listOf("red", "blue", "green")
    val listOfString_4 = listOf("красный", "синий", "зеленый")
    val result_4 = listOfString_3.zip(listOfString_4)

    println(
        "Show result of transforming apply to the" +
        "\n\t'listOfString_1' and 'listOfString_2': $result_1" +
        "\n\t'listOfString_1' and 'range_1': $result_2" +
        "\n\t'range_2' and 'listOfString_2': $result_3" +
        "\n\t'listOfString_3' and 'listOfString_4': $result_4"
    )
}
