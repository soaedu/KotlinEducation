package data.type.standard_type.collection_type.operation.filtering.filter_indexed_operation

import syntax.functional_programming.function_type.anonymous_func.higher_order_func.example_3.joinToString

/**
 * Methods:
 *      * filterIndexed(...)    - returns the List with elements that satisfy to a given predicate.
 *      * filterIndexedTo(...)  - works the same as 'filterIndexed' but it appends the 'List' with
 *                                  resulting elements to the destination 'List'.
 *
 * They use both 'index' and 'element' as arguments for the predicate.
 */
fun main() {
    // #1
    val targetIndex = 3
    val targetValue_1 = 5
    val arrayOfNumbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    val listOfNumbers = mutableListOf<Int>()
    val filterResult_1 = arrayOfNumbers.filterIndexed { index, _ ->
        if (index < targetIndex) index == (targetIndex - 1)
        else (index + 1) % targetIndex == 0
    }.joinToString(",")
    val filterResult_2 = arrayOfNumbers.filterIndexedTo(
        listOfNumbers,
        { index, element -> (index < targetIndex) && (element < targetValue_1) }
    )
    println(
        "Show filter result for:" +
        "\n\t'intArray' and display every '$targetIndex' its item: $filterResult_1" +
        "\n\t'intArray' and display its items less than '$targetValue_1' with index less than '$targetIndex': " +
                "$filterResult_2"
    )

    // #2
    val targetValue_2 = 5
    val predicate_1 = { index: Int, element: String -> (index != targetIndex) && (element.length > targetValue_2)}
    val listOfCountries_1 = listOf("Germany", "India", "Japan", "Brazil", "Australia")
    var listOfCountries_2 = mutableListOf("United States", "Canada")
    val filterResult_3 = listOfCountries_1.filterIndexed(predicate_1)
    val filterResult_4 = listOfCountries_1.filterIndexedTo(
        listOfCountries_2,
        predicate_1
    )
    println(
        "Show filter result for 'listOfCountries_1'" +
        "\n\tall its items that match to predicate: $filterResult_3" +
        "\n\tall 'listOfCountries_2' own items with appended after filter: $filterResult_4"
    )
}
