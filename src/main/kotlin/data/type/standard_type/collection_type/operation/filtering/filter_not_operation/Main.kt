package data.type.standard_type.collection_type.operation.filtering.filter_not_operation

import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person

/**
 * Methods:
 *      * filterNot()       - returns the List with elements that do not match the given predicate.
 *      * filterNotTo(...)  - works the same as 'filterNot' but it appends the 'List' with
 *                              resulting elements to the destination 'List'.
 */
fun main() {
    // #1
    val targetValue = 5
    val predicate_1 = { element: String -> element.length > targetValue }
    val listOfCountries_1 = listOf("Germany", "India", "Japan", "Brazil", "Australia")
    val listOfCountries_2 = mutableListOf("United States", "Canada")
    val filterResult_1 = listOfCountries_1.filterNot(predicate_1)
    val filterResult_2 = listOfCountries_1.filterNotTo(
        listOfCountries_2,
        predicate_1
    )
    println(
        "Show filter result for 'listOfCountries_1'" +
        "\n\tall its items that not match to a predicate: $filterResult_1" +
        "\n\tall 'listOfCountries_2' own items with appended after filter: $filterResult_2"
    )

    // #2
    val predicate_2 = { element: Person -> element is Employee}
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val listOfEmployee = mutableListOf<Person>(Employee("Bob", 26, true))
    val filterResult_3 = listOfPeople.filterNot(predicate_2)
    val filterResult_4 = listOfPeople.filterNotTo(
        listOfEmployee,
        predicate_2
    )
    println(
        "Show filter result for 'listOfPeople'" +
        "\n\tall its items that are not of type 'Employee': $filterResult_3" +
        "\n\tall 'listOfEmployee' own items with appended after filter: $filterResult_4"
    )
}
