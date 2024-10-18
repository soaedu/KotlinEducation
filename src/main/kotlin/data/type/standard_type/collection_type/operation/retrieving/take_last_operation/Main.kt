package data.type.standard_type.collection_type.operation.retrieving.take_last_operation

/**
 * Function 'takeLast(n)' returns a collection with only the last 'n' elements
 * (or returns the unchanged collection if it has less than 'n' elements).
 *
 * Return type is not an 'IntArray', but rather a 'List<Int>'.
 *
 * If we know the size of our collection, we can use instead:
 * 	    * list.takeLast(n) -> list.drop(list.size - n)
 * 	    * list.takeLast(n) -> list.subList(list.size - n, list.size)
 */
fun main() {
    // #1
    val targetValue_1 = 2
    val listOfString = listOf("Kotlin", "Java", "Dart", "Python", "C++")
    println(
        "Show result of taking last '$targetValue_1' items from 'listOfString': ${listOfString.takeLast(targetValue_1)}"
    )

    // #2
    // val targetIndex_1 = 0
    // val targetIndex_2 = 100
    val targetValue_2 = 100
    val input = "HelloWorld"
    println(
        "Show result of taking last '$targetValue_1' items from '$input' string:" +
                "\n\tuse 'takeLast' with value '$targetValue_2' that exceeds the size of the input string: " +
                "${input.take(targetValue_2)}"
        // error: IndexOutOfBoundsException
        /*
        "\n\tuse 'subList' with '$targetIndex_2' that exceeds the size of the input string: " +
        "${input.toList().subList(targetIndex_1, targetIndex_2)}"
         */
    )
}
