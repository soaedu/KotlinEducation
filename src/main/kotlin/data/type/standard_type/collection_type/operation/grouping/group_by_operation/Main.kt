package data.type.standard_type.collection_type.operation.grouping.group_by_operation

import data.type.standard_type.collection_type.operation.Employee

/**
 * Method groups elements of collection/sequence by a specified criteria.
 *      * groupBy(keySelector: (T) -> K): Map<K, List<T>>
 * 	    * groupBy(keySelector: (T) -> K, valueTransform: (T) -> V): Map<K, List<V>>
 * 	        In addition receives in the parameter 'valueTransform' a transforming function.
 *
 * Both functions receive in the parameter 'keySelector' a function that defines criteria of
 * grouping.
 *
 * As a result they return a 'map' that holds a set of groups.
 */
fun main() {
    // #1
    // Use 'groupBy' to group employees by their companies.
    val map_1 = listOf(
        Employee("Tom", 31, true, "Microsoft"),
        Employee("Bob", 28, true,"JetBrains"),
        Employee("Sam", 42,true, "Google"),
        Employee("Alice", 38, false,"Microsoft"),
        Employee("Kate", 27, false,"Google")
    )
    val result_1 = map_1.groupBy { it.company.uppercase() }
    val result_2 = map_1.groupBy(
        keySelector = { it.company.uppercase() },
        valueTransform = { it.name }
    )

    // #2
    // Use 'groupBy' to group words by its length.
    val listOfString = listOf("a", "abc", "ab", "def", "abcd")
    val result_3 = listOfString.groupBy { it.length }

    // #3
    // Use 'groupBy' to group people by its department name.
    val listOfPair = listOf("Alice" to "Marketing", "Bob" to "Sales", "Carol" to "Marketing")
    val result_4 = listOfPair.groupBy({ it.second }, { it.first })

    println(
        "Show result of grouping apply to the:" +
        "\n\t'map_1' ('groupBy' company name): $result_1" +
        "\n\t'map_1' ('groupBy' company name and show only names): $result_2" +
        "\n\t'listOfString' ('groupBy' length): $result_3" +
        "\n\t'listOfPair' ('groupBy' department name): $result_4"
    )
}
