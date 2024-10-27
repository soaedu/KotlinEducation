package data.type.standard_type.collection_type.operation.aggregating.min_of_or_null_operation

import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person

/**
 * Method returns the lowest value of a property:
 *      not the element that contains this value but the value itself.
 */
fun main() {
    // #1
    // Use 'minOfOrNull' to get the minimal value from array.
    val arrayOfNumber = arrayOf(1, 2, 3, 4)
    val result_1 = arrayOfNumber.minOfOrNull { it }

    // #2
    // Use 'minOfOrNull' to get the lowest age of all persons in the list.
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Employee("Bob", 26, true),
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val result_2 = listOfPeople.minOfOrNull { it.age }

    // #3
    // Use 'minOfOrNull' to get the size of the narrowest string of skills.
    val mapOfSkill = mapOf(
        "Alice" to "Kotlin, typescript, Javascript, C, C++",
        "Bob" to "Java, C, Python, Ruby, Shell, Go",
        "Eric" to "Kotlin, Java, C, Python, Ruby, Php, Shell, Rust",
        "Kevin" to "Java, Scala, Go, Ruby",
        "Anthony" to "Beauty!"
    )
    val result_3 = mapOfSkill.minOfOrNull { (_, skills) -> skills.split(", ").size }

    // #4
    // Use 'minOfOrNull' to get a value from the empty list.
    val emptyList = emptyList<String>()
    val result_4 = emptyList.minOfOrNull { it }

    println(
        "Show result of aggregation applied to the:" +
        "\n\t'arrayOfNumber' ('minOfOrNull' minimal value): $result_1" +
        "\n\t'listOfPeople' ('minOfOrNull' minimal age): $result_2" +
        "\n\t'mapOfSkill' ('minOfOrNull' size of shortest skills string): $result_3" +
        "\n\t'emptyList': $result_4"
    )
}
