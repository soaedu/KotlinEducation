package syntax.functions.function_type.extension_func.example_3

import java.util.*

fun main(args: Array<String>) {
    // #1
    for (index in 1..10)
        println("Random value[$index]: ${Int.random()}")

    // #2
    val object1 = listOf(1, 2, 3)
    val object2 = object1

    val object3 = null

    val result1 = object1.safeEquals(object2)
    val result2 = object2.safeEquals(object3)
    println("Result1: $result1 \nResult2: $result2")

    val result3 = object3.safeEquals(object2)
    println("\nResult3: $result3")
}

// #1
// The 'extension' function is created in the
// companion object of the 'Int' class.
fun Int.Companion.random(): Int {
    val random = Random()
    return random.nextInt()
}

// #2
// The 'extension' function is used to add 'equal'
// functionality to 'Any?' type.
fun Any?.safeEquals(other: Any?): Boolean {
    if (this == null && other == null) return true
    if (this == null) return false

    return this.equals(other)
}
