package data.type.standard_type.collection_type.operation.sorting.shuffled_operation

import kotlin.random.Random

/**
 * Method randomly shuffle the elements of a list.
 */
fun main() {
    // #1
    val range_1 = (1..10)
    val listOfNumber_1 = range_1.toList()
    val result_1 = listOfNumber_1.shuffled()

    // #2
    val range_2 = (3..8)
    val listOfNumber_2 = range_2.toMutableList()
    val result_2 = listOfNumber_2.shuffled()

    // #3
    val randomSeed = 42
    val listOfChar = ('A'..'K').toList()
    val result_3 = listOfChar.shuffled()
    val result_4 = listOfChar.shuffled()
    val result_5 = listOfChar.shuffled(Random(randomSeed))
    val result_6 = listOfChar.shuffled(Random(randomSeed))

    println(
        "Show result of sotring apply to the" +
        "\n\t'listOfNumber_1' (read-only list): $result_1" +
        "\n\t'listOfNumber_2' (mutable list): $result_2" +
        "\n\t'listOfNumber_2' (mutable list 'in-place'): ${listOfNumber_2.shuffled()}" +
        "\n\t'listOfChar' (shuffle #1): $result_3" +
        "\n\t'listOfChar' (shuffle #2): $result_4" +
        "\n\t'listOfChar' (shuffle with a seed #1): $result_5" +
        "\n\t'listOfChar' (shuffle with a seed #2): $result_6"
    )
}
