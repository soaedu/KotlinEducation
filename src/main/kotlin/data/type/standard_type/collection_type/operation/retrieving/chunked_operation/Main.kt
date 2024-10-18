package data.type.standard_type.collection_type.operation.retrieving.chunked_operation

/**
 * Function 'chunked' is used to break the collection into parts.
 */
fun main() {
    // #1
    val targetValue_1 = 2
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of breaking the 'listOfString'" +
        "\n\ton chunks with '$targetValue_1' items: ${listOfString.chunked(targetValue_1)}"
    )

    // #2
    // This approach pads the 'String' to a size that is a multiple of n before splitting it.
    val targetValue_2 = 3
    val input = "HelloWorld"
    val paddedInput = input.padEnd(
        input.length + targetValue_2 - (input.length % targetValue_2),
        ' '
    )
    val chunks = paddedInput.chunked(targetValue_2)
    println(
        "Show result of breaking the '$input' string" +
        "\n\ton chunks with '$targetValue_2' items: $chunks"
    )
}
