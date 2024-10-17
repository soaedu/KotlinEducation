package data.type.standard_type.collection_type.operation.finding.last_operation

import data.type.standard_type.collection_type.operation.Employee
import data.type.standard_type.collection_type.operation.Manager
import data.type.standard_type.collection_type.operation.Person

/**
 * Function 'last()' is used to find the last element in the collection that match to a predicate.
 *
 * If element is not found, 'NoSuchElementException' is thrown.
 */
fun main() {
    // #1
    val targetValue_1 = "A"
    val targetValue_2 = "a"
    // val targetValue_3 = "F"
    val listOfString = listOf("Apple", "Avocado", "Banana", "Orange", "Peach", "Plum")
    val findResult_1 = listOfString.last { it.startsWith(targetValue_1) }
    val findResult_2 = listOfString.last { it.endsWith(targetValue_2) }
    // val findResult_3 = listOfString.last { it.endsWith(targetValue_3) }    // error: NoSuchElementException
    println(
        "Show find result applied to 'listOfString': " +
        "\n\tlast item that starts with '$targetValue_1': $findResult_1" +
        "\n\tlast item that ends with '$targetValue_2': $findResult_2"
        // "\n\tlast item that ends with '$targetValue_3': $findResult_3"
    )

    // #2
    val targetValue_4 = 20
    // val targetValue_5 = 50
    val listOfPeople = listOf(
        Person("Alice", 13, false),
        Employee("Carol", 31, false),
        Manager("Anthony", 28, true)
    )
    val findResult_4 = listOfPeople.last { it.age > targetValue_4 }
    val findResult_5 = listOfPeople.last { it.isFemale(it) }
    // val findResult_6 = listOfPeople.last { it.age > targetValue_5 }        // error: NoSuchElementException
    println(
        "Show find result applied to 'listOfPeople': " +
        "\n\tlast person whose age is greater than '$targetValue_4': $findResult_4" +
        "\n\tlast person that is female: $findResult_5"
        // "\n\tlast person whose age is greater than '$targetValue_5': $findResult_6"
    )
}
