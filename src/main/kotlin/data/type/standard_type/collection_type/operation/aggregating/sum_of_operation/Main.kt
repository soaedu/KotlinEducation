package data.type.standard_type.collection_type.operation.aggregating.sum_of_operation

import data.type.standard_type.collection_type.operation.Player
import java.math.BigDecimal

/**
 * Method returns the sum of all values produced by 'selector function' applied to each
 * element in the sequence.
 *
 * The operation is terminal.
 */
fun main() {
    // #1
    val listOfNumber = listOf(10.0, 2.0, 3.0, 40.0, 5.0)
    val result_1: Double = listOfNumber.sumOf { it }

    // #2
    val listOfPlayer = listOf(
        Player("Jake", 234, BigDecimal("2.30")),
        Player("Megan", 567, BigDecimal("1.50")),
        Player("Beth", 123, BigDecimal("0.00")),
    )
    val result_2 = listOfPlayer.sumOf { it.points }

    println(
        "Show result of aggregation apply to the" +
        "\n\t'listOfNumber' (sum of all elements): $result_1" +
        "\n\t'listOfPlayer' (sum of all players points): $result_2"
    )
}
