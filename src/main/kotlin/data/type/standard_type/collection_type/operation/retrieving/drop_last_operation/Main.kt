package data.type.standard_type.collection_type.operation.retrieving.drop_last_operation

/**
 * Function 'dropLast' is used to get a collection without the last 'n' elements.
 *
 * If we know the size of our collection, we can use instead:
 * 	    * list.dropLast(n) -> list.take(list.size - n)
 * 	    * list.dropLast(n) -> list.subList(0, list.size - n)
 */
fun main() {
    // #1
    val targetValue_1 = 2
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of dropping the 'listOfString'" +
        "\n\twith '$targetValue_1' items: ${listOfString.dropLast(targetValue_1)}"
    )

    // #2
    // val targetIndex_1 = 0
    // val targetIndex_2 = 100
    val targetValue_2 = 100
    val input = "HelloWorld"
    println(
        "Show result of dropping the '$input' string" +
        "\n\twith value '$targetValue_2' that exceeds the size of the input string: ${input.dropLast(targetValue_2)}"
        // error: IndexOutOfBoundsException
        /*
        "\n\twith indexes that exceeds the size of the input string: " +
        "${input.toList().subList(targetIndex_1, targetIndex_2)}"
        */
    )
}
