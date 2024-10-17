package data.type.standard_type.collection_type.operation.filtering_operation.filter_operation

import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person

/**
 * Methods:
 *      * filter(...)       - returns the List with elements that match the given predicate.
 *      * filterTo(...)     - works the same as 'filter' but it appends the 'List' with
 *                              resulting elements to the destination 'List'.
 */
fun main() {
    // #1
    val targetValue = 5
    val predicate_1 = { element: String -> element.length > targetValue }
    val listOfCountries_1 = listOf("Germany", "India", "Japan", "Brazil", "Australia")
    val listOfCountries_2 = mutableListOf("United States", "Canada")
    val filterResult_1 = listOfCountries_1.filter(predicate_1)
    val filterResult_2 = listOfCountries_1.filterTo(
        listOfCountries_2,
        predicate_1
    )
    println(
        "Show filter result for 'listOfCountries_1'" +
        "\n\tall its items that match to a predicate: $filterResult_1" +
        "\n\tall 'listOfCountries_2' own items with appended after filter: $filterResult_2"
    )

    // #2
    fun isEmployee(person: Person): Boolean = (person is Employee)
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val listOfEmployee = mutableListOf<Person>(Employee("Bob", 26, true))


    val filterResult_3 = listOfPeople.filter(::isEmployee)
    val filterResult_4 = listOfPeople.filterTo(
        listOfEmployee,
        ::isEmployee
    )
    println(
        "Show filter result for 'listOfPeople'" +
        "\n\tall its items that are of type 'Employee': $filterResult_3" +
        "\n\tall 'listOfEmployee' own items with appended after filter: $filterResult_4"
    )

    // #3
    // prints:
    //  line#1  -> m1 m2 m3 m4 f1 f2 f3 f4
    //  line#2  -> result: [2, 4]
    val listOfNumber = listOf(1, 2, 3, 4)
    println()
    println(
        "\nShow filter result and order of chain execution with 'map' and 'filter' methods" +
        "\n\tresult: ${listOfNumber.map(::executeMap).filter(::executeFilter)}")
}

fun executeMap(value: Int): Int {
    print("map$value ")
    return value
}

fun executeFilter(value: Int): Boolean {
    print("filter$value ")
    return (value % 2) == 0
}
