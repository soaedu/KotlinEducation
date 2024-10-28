package data.type.standard_type.collection_type.operation.filtering.filter_not_null_operation

import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person

/**
 * Methods:
 *      * filterNotNull()       - returns the List with non-null elements.
 *      * filterNotNullTo(...)  - works the same as 'filterNotNull' but it appends the 'List' with
 *                                  non-null elements to the destination 'List'.
 */
fun main() {
    // #1
    val listOfCountries_1 = listOf("Germany", "India", null, "Japan", "Brazil", null, "Australia")
    var listOfCountries_2 = mutableListOf("United States", "Canada")
    val filterResult_1 = listOfCountries_1.filterNotNull()
    val filterResult_2 = listOfCountries_1.filterNotNullTo(listOfCountries_2)
    println(
        "Show filter result for 'listOfCountries_1'" +
        "\n\tall its items that are non-null: $filterResult_1" +
        "\n\tall 'listOfCountries_2' own items with appended after filter: $filterResult_2"
    )

    // #2
    val listOfPeople = listOf(
        null,
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val listOfRealPeople = mutableListOf<Person>(Employee("Bob", 26, true))
    val filterResult_3 = listOfPeople.filterNotNull()
    val filterResult_4 = listOfPeople.filterNotNullTo(listOfRealPeople)
    println(
        "Show filter result for 'listOfPeople'" +
        "\n\tall its items that are non-null: $filterResult_3" +
        "\n\tall 'listOfRealPeople' own items with appended after filter: $filterResult_4"
    )
}
