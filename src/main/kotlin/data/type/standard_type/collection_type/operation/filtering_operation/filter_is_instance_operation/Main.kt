package data.type.standard_type.collection_type.operation.filtering_operation.filter_is_instance_operation

import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person
import syntax.functional_programming.function_type.anonymous_func.higher_order_func.example_3.joinToString

/**
 * Methods:
 *      * filterIsInstance(...)    - returns the List with elements of a specified type.
 *      * filterIsInstanceTo(...)  - works the same as 'filterIsInstance' but it appends the 'List'
 *                                      with resulting elements to the destination 'List'.
 */
fun main() {
    // #1
    val listOfCountryDataMix = listOf("Germany", 49, null, "India", 91, "Japan", 81, "Brazil", null, "Australia", 61)
    val listOfNumbers = mutableListOf<Int>(15, 16, 188)
    val filterResult_1 = listOfCountryDataMix.filterIsInstance<Int>()
    val filterResult_2 = listOfCountryDataMix.filterIsInstanceTo(listOfNumbers)
    println(
        "Show filter result for 'listOfCountryDataMix': " +
        "\n\tall its items with type 'Int': $filterResult_1" +
        "\n\tall 'listOfNumbers' own items its items with appended after filter: $filterResult_2"
    )

    // #2
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Employee("Bob", 26, true),
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val listOfEmployee = mutableListOf<Employee>()
    val filterResult_3 = listOfPeople.filterIsInstance<Manager>()
    val filterResult_4 = listOfPeople.filterIsInstanceTo(listOfEmployee)
    println(
        "Show filter result for 'listOfPeople'" +
        "\n\tall its items with type 'Manager': $filterResult_3" +
        "\n\tall 'listOfEmployee' own items with appended after filter: $filterResult_4"
    )
}
