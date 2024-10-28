package data.type.standard_type.collection_type.operation.retrieving.drop_operation

/**
 * Function 'drop' is used to get all the elements except a given number of first elements.
 *
 * If we know the size of our collection, we can use instead:
 * 	    * list.drop(n) -> list.takeLast(list.size - n)
 * 	    * list.drop(n) -> list.subList(n, list.size)
 */
fun main() {
    // #1
    val targetValue_1 = 2
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of dropping the 'listOfString'" +
        "\n\twith '$targetValue_1' items: ${listOfString.drop(targetValue_1)}"
    )

    // #2
    // val targetIndex_1 = 0
    // val targetIndex_2 = 100
    val targetValue_2 = 100
    val input = "HelloWorld"
    println(
        "Show result of dropping the '$input' string" +
        "\n\twith value '$targetValue_2' that exceeds the size of the input string: ${input.drop(targetValue_2)}"
        // error: IndexOutOfBoundsException
        /*
        "\n\twith indexes that exceeds the size of the input string: " +
        "${input.toList().subList(targetIndex_1, targetIndex_2)}"
        */
    )
}
