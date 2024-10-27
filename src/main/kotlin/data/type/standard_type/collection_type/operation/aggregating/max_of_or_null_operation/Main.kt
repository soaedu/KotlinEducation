package data.type.standard_type.collection_type.operation.aggregating.max_of_or_null_operation

import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person

/**
 * Method helps to return the biggest value of a property:
 *      not the element that contains this value but the value itself.
 */
fun main() {
    // #1
    // Use 'maxOfOrNull' to get the biggest value from array.
    val arrayOfNumber = arrayOf(1, 2, 3, 4)
    val result_1 = arrayOfNumber.maxOfOrNull { it }

    // #2
    // Use 'maxOfOrNull' to get the highest age of all persons in the list.
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Employee("Bob", 26, true),
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val result_2 = listOfPeople.maxOfOrNull { it.age }

    // #3
    // Use 'maxOfOrNull' to get the size of the widest string of skills.
    val mapOfSkill = mapOf(
        "Alice" to "Kotlin, typescript, Javascript, C, C++",
        "Bob" to "Java, C, Python, Ruby, Shell, Go",
        "Eric" to "Kotlin, Java, C, Python, Ruby, Php, Shell, Rust",
        "Kevin" to "Java, Scala, Go, Ruby",
        "Anthony" to "Beauty!"
    )
    val result_3 = mapOfSkill.maxOfOrNull { (name, skills) -> skills.split(", ").size }

    // #4
    // Use 'maxOfOrNull' to get a value from the empty list.
    val emptyList = emptyList<String>()
    val result_4 = emptyList.maxOfOrNull { it }

    println(
        "Show result of aggregation apply to the:" +
        "\n\t'arrayOfNumber' ('maxOfOrNull' the biggest number): $result_1" +
        "\n\t'listOfPeople' ('maxOfOrNull' the higher age): $result_2" +
        "\n\t'mapOfSkill' ('maxOfOrNull' size of the widest skills string): $result_3" +
        "\n\t'emptyList' ('maxOfOrNull'): $result_4"
    )
}
