package syntax.functions.function_type.stdlib_func.scope_func.example_6

import kotlin.random.Random

/**
 * Scope functions 'takeIf' and 'takeUnless' have definition in the 'standard library' like this
 *
 * inline fun <T> T.takeIf(predicate: (T) -> Boolean): T? {
 *      return if (predicate(this)) this else null
 * }
 *
 * 'takeIf'/'takeUnless' - filter functions for a single object
 *
 * takeIf()     - returns the 'receiver object' if it satisfies the given predicate,
 *                  otherwise returns 'null'
 *
 * takeUnless() - returns the 'null' if it satisfies the given predicate,
 *                   otherwise returns 'receiver object'
 *
 *  Should be used if we:
 *      * want to filter some values in combination with 'scope functions'.
 */
fun main() {
    // #1
    displaySubstringPosition("010000011", "11")
    displaySubstringPosition("010000011", "12")

    // #2
    val str = "Hello"
    // We need to be careful with 'takeIf'/'takeUnless' functions, they always return
    // 'nullable' value. We have to use 'null check' all the time.
    val caps = str.takeIf { it.isNotEmpty() }?.uppercase()
    // val caps = str.takeIf { it.isNotEmpty() }.uppercase()        // compilation error
    println("\n$caps")

    // #3
    val number = Random.nextInt(100)
    val evenOrNull = number.takeIf { it % 2 == 0 }
    val oddOrNull = number.takeUnless { it % 2 == 0 }
    println("\neven: $evenOrNull, odd: $oddOrNull")
}

// #1
// Use 'scope function' to find matching position for a substring.
fun displaySubstringPosition(input: String, sub: String) {
    input.indexOf(sub).takeIf { it >= 0 }?.let {
        println("The substring $sub is found in $input.")
        println("Its start position is $it.")
    }
}