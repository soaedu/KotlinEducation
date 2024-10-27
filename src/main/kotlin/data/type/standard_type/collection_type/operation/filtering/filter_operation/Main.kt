package data.type.standard_type.collection_type.operation.filtering.filter_operation

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
    val result_1 = listOfCountries_1.filter(predicate_1)
    val result_2 = listOfCountries_1.filterTo(
        listOfCountries_2,
        predicate_1
    )

    // #2
    fun isEmployee(person: Person): Boolean = (person is Employee)
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val listOfEmployee = mutableListOf<Person>(Employee("Bob", 26, true))
    val result_3 = listOfPeople.filter(::isEmployee)
    val result_4 = listOfPeople.filterTo(
        listOfEmployee,
        ::isEmployee
    )

    // #3
    // prints:
    //  line#1  -> m1 m2 m3 m4 f1 f2 f3 f4
    //  line#2  -> result: [2, 4]
    val listOfNumber = listOf(1, 2, 3, 4)
    val result_5 = listOfNumber.map(::executeMap).filter(::executeFilter)

    // #4
    // Use 'filter' on a map, pass to it a predicate with a 'Pair' as an argument
    val map = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3
    )
    val result_6 = map.filterKeys { it.endsWith("e") }
    val result_7 = map.filterValues { it > 1 }
    val result_8 = map.filter { (key, value) ->
        key.endsWith("e") && value > 1
    }

    println(
        "\n\nShow result of filter operation applied to" +
        "\n\t'listOfCountries_1' ('filter' all items matching predicate): $result_1" +
        "\n\t'listOfCountries_2' ('filterTo' own items with appended after filter): $result_2" +
        "\n\t'listOfPeople' ('filter' all items of type 'Employee'): $result_3" +
        "\n\t'listOfPeople' ('filterTo' own items with appended after filter): $result_4" +
        "\n\t'listOfNumber' ('map' than 'filter' chained execution): $result_5" +
        "\n\t'map' ('filterKeys'): $result_6" +
        "\n\t'map' ('filterValues'): $result_7" +
        "\n\t'map' ('filter (key, values)'): $result_8"
    )
}

fun executeMap(value: Int): Int {
    print("map$value ")
    return value
}

fun executeFilter(value: Int): Boolean {
    print("filter$value ")
    return (value % 2) == 0
}
