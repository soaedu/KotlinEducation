package data.type.standard_type.collection_type.operation.transforming.data.flat_map_operation

import data.type.standard_type.collection_type.operation.Department
import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person

/**
 * Method transforms one collection to another using transformation method passed by parameter.
 *
 * It is expected that our lambda function return type is 'Iterable<T>'.
 * This method flattens the sequence of 'Iterable' instances.
 */
fun main() {
    // #1
    // Use 'flatMap' to get a result collection with repeated twice items from source collection.
    val arrayOfNumber = intArrayOf(1, 2, 3)
    val result_1 = arrayOfNumber.flatMap { element ->
        intArrayOf(element, element).asIterable()
    }
    println("Show doubled each item of the 'intArray': $result_1")

    // #2
    // Use 'flatMap' to get a single list of all persons in all departments.
    val person_1 = Person("Alice", 13, false)
    val employee_1 = Employee("Bob", 26, true)
    val employee_2 = Employee("Carol", 31, false)
    val manager_1 = Manager("Anthony", 28, true)
    val listOfDepartment = listOf(
        Department("dep_1", listOf(person_1)),
        Department("dep_2", listOf(employee_1, employee_2)),
        Department("dep_3", listOf(manager_1))
    )
    val result_2 = listOfDepartment.flatMap { it.employees }

    // #3
    // Use 'flatMap' to get list of symbols from words in the source list.
    val listOfString = listOf("Hello", "World")
    val result_3 = listOfString.flatMap { it.toList() }

    // #4
    // Use 'flatMap' to get set of symbols from words in the source list.
    val result_4 = listOfString.flatMap { it.toList() }.toSet()

    println(
        "Show result of transformation apply on the:" +
        "\n\t'listOfDepartment': $result_2" +
        "\n\t'listOfString' (list): $result_3" +
        "\n\t'listOfString' (set): $result_4"
    )
}
