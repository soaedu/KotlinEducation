package data.type.standard_type.collection_type.operation.aggregating.min_of_operation

import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person

/**
 * Method takes a 'selector function' and returns the lowest value produced by the
 * 'selector function'.
 */
fun main() {
    // #1
    // Use 'minOf' to get a value with minimal value in array.
    val arrayOfNumber = arrayOf(1, 2, 3, 4)
    val result_1 = arrayOfNumber.minOf { it }

    // #2
    // Use 'minOf' to get the youngest person from the list.
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Employee("Bob", 26, true),
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val result_2 = listOfPeople.minOf { it.age }

    // #3
    // Use 'minOf' to get the size of the shortest list of persons skills.
    val mapOfSkill = mapOf(
        "Alice" to "Kotlin, typescript, Javascript, C, C++",
        "Bob" to "Java, C, Python, Ruby, Shell, Go",
        "Eric" to "Kotlin, Java, C, Python, Ruby, Php, Shell, Rust",
        "Kevin" to "Java, Scala, Go, Ruby",
        "Anthony" to "Beauty!"
    )
    val result_3 = mapOfSkill.minOf { (name, skills) -> skills.split(", ").size }

    // #4
    // Use 'minOf' to get a value from the empty list.
    val emptyList = emptyList<String>()
    // error: NoSuchElementException
    // val result_5 = emptyList.minOf { it }

    println(
        "Show result of aggregation applied to the:" +
        "\n\t'arrayOfNumber' ('minOf' minimal value): $result_1" +
        "\n\t'listOfPeople' ('minOf' youngest person): $result_2" +
        "\n\t'mapOfSkill' ('minOf' shortest skills string): $result_3"
        // "\n\t'emptyList': $result_5"
    )
}
