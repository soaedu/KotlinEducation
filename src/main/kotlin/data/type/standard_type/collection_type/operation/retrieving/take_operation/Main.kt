package data.type.standard_type.collection_type.operation.retrieving.take_operation

/**
 * Function 'take(n)' returns a collection with only the first 'n' elements
 * (or returns the unchanged collection if it has less than 'n' elements).
 *
 * Return type is not an 'IntArray', but rather a 'List<Int>'.
 *
 * If we know the size of our collection, we can use instead:
 * 	    * list.take(n) -> list.dropLast(list.size - n)
 * 	    * list.take(n) -> list.subList(0, n)
 */
fun main() {
    // #1
    val targetValue_1 = 2
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of taking '$targetValue_1' items from 'listOfString': ${listOfString.take(targetValue_1)}"
    )

    // #2
    // val targetIndex_1 = 0
    // val targetIndex_2 = 100
    val targetValue_2 = 100
    val input = "HelloWorld"
    println(
        "Show result of taking '$targetValue_1' items from '$input' string:" +
        "\n\tuse 'take' with value '$targetValue_2' that exceeds the size of the input string: " +
                "${input.take(targetValue_2)}"
        // error: IndexOutOfBoundsException
        /*
        "\n\tuse 'subList' with '$targetIndex_2' that exceeds the size of the input string: " +
        "${input.toList().subList(targetIndex_1, targetIndex_2)}"
         */
    )
}
