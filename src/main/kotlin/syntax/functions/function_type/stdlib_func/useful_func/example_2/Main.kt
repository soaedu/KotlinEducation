package syntax.functions.function_type.stdlib_func.useful_func.example_2

/**
 * Stdlib function 'repeat'.
 *
 * This method is particularly useful when the number of repetitions is predetermined.
 * 'repeat()' takes two parameters:
 * 	    * an integer specifying the number of iterations
 * 	    * a function to be executed.
 *
 * Additionally, it’s worth noting that Kotlin also has a 'repeat()' function for repeating
 * characters, not just for executing processes.
 */
fun main() {
    // #1
    // Use 'repeat()' to execute some process
    repeat(3) {
        println("Print Message 3 times")
    }

    // #2
    // Use 'repeat()' to repeat a character
    val line = "-".repeat(5)
    println("\n$line")
}