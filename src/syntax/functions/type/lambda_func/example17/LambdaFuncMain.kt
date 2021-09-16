package syntax.functions.type.lambda_func.example17

import syntax.functions.type.lambda_func.example16.Person

/**
 * groupingBy - the function that performs groupBy for sequences
 *              in a lazy way
 */
/*
fun main() {
    val people = listOf(
        Person("John Weak", 35, true),
        Person("Jack Nikolson", 42, true),
        Person("Samanta Fox", 19, false),
        Person("Gvinett Peltrow", 54, false)
    )

    // #1
    val groupResult1 = people
                        .asSequence()
                        .groupBy { it.age }
                        .mapValues { (_, group) -> group.size }
    println("1. result: $groupResult1")

    // #2
    val groupResult2 = people
                        .asSequence()
                        .groupingBy { it.age }
                        .eachCount()
    println("2. result: $groupResult2")
}

data class Person(val name: String, val age: Int, val isPublicProfile: Boolean)*/

fun fibonacci(): Sequence<Int> = sequence {
    var x1 = 0
    var x2 = 1
    var x3 = 0

    while(true) {
        x3 = (x1+x2)

        if (x3 < 2) {
            yieldAll(listOf(x1, x2, x3))
        } else {
            yield(x3)
        }
        x1 = x2
        x2 = x3
    }
}

fun main(args: Array<String>) {
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}

infix fun <T> T.eq(other: T) {
    if (this == other) println("OK")
    else println("Error: $this != $other")
}
