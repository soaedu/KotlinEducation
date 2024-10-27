package data.type.standard_type.collection_type.operation.aggregating.max_of_operation

import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person

/**
 * Method takes a 'selector function' and returns the largest value produced by the
 * 'selector function'.
 */
fun main() {
    // #1
    // Use 'maxOf' to get a value with max value in array.
    val arrayOfNumber = arrayOf(1, 2, 3, 4)
    val result_1 = arrayOfNumber.maxOf { it }

    // #2
    // Use 'maxOf' to get a person that match to a selector function.
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Employee("Bob", 26, true),
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val result_2 = listOfPeople.maxOf { it.age }

    // #3
    // Use 'maxOf' to get a person whose name match to a selector function.
    val mapOfSkill = mapOf(
        "Alice" to "Kotlin, typescript, Javascript, C, C++",
        "Bob" to "Java, C, Python, Ruby, Shell, Go",
        "Eric" to "Kotlin, Java, C, Python, Ruby, Php, Shell, Rust",
        "Kevin" to "Java, Scala, Go, Ruby",
        "Anthony" to "Beauty!"
    )
    val result_3 = mapOfSkill.maxOf { (name, _) -> name }
    val result_4 = mapOfSkill.maxOf { (name, _) -> name[1] }

    // #4
    // Use 'maxOf' to get a value from the empty list.
    val emptyList = emptyList<String>()
    // error: NoSuchElementException
    // val result_5 = emptyList.maxOf { it }

    println(
        "Show result of aggregation applied to the:" +
        "\n\t'arrayOfNumber' ('maxOf'): $result_1" +
        "\n\t'listOfPeople' ('maxOf'): $result_2" +
        "\n\t'mapOfSkill' ('maxOf' by 'name'): $result_3" +
        "\n\t'mapOfSkill' ('maxOf'- by second letter in 'name'): $result_4"
        // "\n\t'emptyList' (maxOf): $result_5"
    )
}
