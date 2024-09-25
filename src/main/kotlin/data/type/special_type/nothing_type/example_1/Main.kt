package data.type.special_type.nothing_type.example_1

import data.helpers.printItems

fun main() {
    readUserInputData()
}

// Use 'Nothing' type to specify that method has a cycle that never ends.
fun readUserInputData(): Nothing {
    val userInput = mutableListOf<String>()

    println("Type a value and press 'Enter'")

    while(true) {
        userInput.add(readLine().toString())
        printItems(list = userInput.toList())
        println("keep adding values...")
    }
}
