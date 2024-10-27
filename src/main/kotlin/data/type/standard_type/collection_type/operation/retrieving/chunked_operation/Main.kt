package data.type.standard_type.collection_type.operation.retrieving.chunked_operation

/**
 * Method helps to break the collection into parts.
 */
fun main() {
    // #1
    val targetValue_1 = 2
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    val result_1 = listOfString.chunked(targetValue_1)
    val result_2 = listOfString.chunked(targetValue_1) { list: List<String> ->
        list.map { item: String -> item.length }
    }

    // #2
    // This approach pads the 'String' to a size that is a multiple of n before splitting it.
    val targetValue_2 = 3
    val input = "HelloWorld"
    val paddedInput = input.padEnd(
        input.length + targetValue_2 - (input.length % targetValue_2),
        ' '
    )
    val result_3 = paddedInput.chunked(targetValue_2)

    println(
        "Show result of breaking on chunks the" +
        "\n\t'listOfString': $result_1" +
        "\n\t'listOfString' ('map' applied): $result_2" +
        "\n\t'input' ('padding' applied to last item): $result_3"
    )
}
