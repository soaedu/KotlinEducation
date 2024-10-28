package data.type.standard_type.collection_type.operation.retrieving.windowed_operation

/**
 * Function 'windowed' returns all possible ranges of the collection elements of a given size.
 */
fun main() {
    // #1
    val targetValue_1 = 3
    val targetValue_2 = 2
    val targetValue_3 = true
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of breaking the 'listOfString'" +
        "\n\ton chunks with size '$targetValue_1' items: ${listOfString.windowed(targetValue_1)}" +
        "\n\ton chunks with '$targetValue_1' and step '$targetValue_2' items: " +
                "${listOfString.windowed(targetValue_1, targetValue_2)}" +
        "\n\ton chunks with '$targetValue_1', step '$targetValue_2' and partialWindows is '$targetValue_3' items: " +
                "${listOfString.windowed(targetValue_1, targetValue_2, targetValue_3)}"
    )

    // #2
    val targetValue_4 = 4
    val input = "HelloWorld"
    println(
        "Show result of breaking the '$input' string" +
        "\n\ton chunks with '$targetValue_4', step '$targetValue_4' and partialWindows is '$targetValue_3' items: " +
                "${input.windowed(targetValue_4, targetValue_4, targetValue_3)}"
    )
}
