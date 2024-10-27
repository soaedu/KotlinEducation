package data.type.standard_type.collection_type.operation.aggregating.sum_operation

import data.type.standard_type.collection_type.operation.Player
import java.math.BigDecimal

/**
 * Method calculates a sum of all collection items.
 *
 * It is implemented for all the basic ways of representing numbers, like:
 * Int, Long, Double, etc.
 */
fun main() {
    // #1
    val listOfNumber = listOf(1, 6, 2, 4, 7, 1)
    val result_1 = listOfNumber.sum()

    // #2
    val listOfPlayer = listOf(
        Player("Jake", 234, BigDecimal("2.30")),
        Player("Megan", 567, BigDecimal("1.50")),
        Player("Beth", 123, BigDecimal("0.00")),
    )
    val result_2 = listOfPlayer.map { it.points }.sum()

    println(
        "Show result of aggregation apply to the" +
        "\n\t'listOfNumber' (sum of all elements): $result_1" +
        "\n\t'listOfPlayer' (sum of all players points): $result_2"
    )
}
