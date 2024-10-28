package data.type.standard_type.collection_type.operation.grouping.grouping_by_operation

import data.type.standard_type.collection_type.operation.Employee

/**
 * Method creates a 'grouping' source from a collection to be used later with one of
 * group-and-fold operations using the specified keySelector function to extract a key
 * from each element.
 */
fun main() {
    // #1
    // Use 'groupingBy' to group employees by their companies.
    val map_1 = listOf(
        Employee("Tom", 31, true, "Microsoft"),
        Employee("Bob", 28, true,"JetBrains"),
        Employee("Sam", 42,true, "Google"),
        Employee("Alice", 38, false,"Microsoft"),
        Employee("Kate", 27, false,"Google")
    )
    val result_1 = map_1.groupingBy { it.company.uppercase() }
    val result_2 = map_1.groupingBy { it.company }.eachCount()

    // #2
    // Use 'groupingBy' to group words by its length.
    val listOfString = listOf("a", "abc", "ab", "def", "abcd")
    val result_3 = listOfString.groupingBy { it.length }

    // #3
    // Use 'groupingBy' to group people by its department name.
    val listOfPair = listOf("Alice" to "Marketing", "Bob" to "Sales", "Carol" to "Marketing")
    val result_4 = listOfPair.groupingBy { it.second }

    println(
        "Show result of grouping apply to the:" +
        "\n\t'map_1' ('groupingBy' company name): $result_1" +
        "\n\t'map_1' ('groupingBy' company name and show people amount): $result_2" +
        "\n\t'listOfString' ('groupingBy' length): $result_3" +
        "\n\t'listOfPair' ('groupingBy' department name): $result_4"
    )
}
