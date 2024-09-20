package syntax.functions.function_type.stdlib_func.useful_func.example_3

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

/**
 * Stdlib function 'use'.
 *
 * Is similar to the 'try-with-resources' statement that exists in 'Java 7'.
 * Is defined as an extension on an instance of closeable and accepts a function literal that
 * operates on this closeable, such as:
 *      * files
 *      * database connections
 *      * network streams
 *
 * Will safely invoke the function, closing down the resource after the function has completed
 * whether an exception was raised or not.
 *
 * Is a more concise way of handling resources in simple cases, without needing the
 * 'try/catch/finally' block.
 */
fun main() {
    val filePath = "E:\\Edu\\Computer_disciplines\\0_Language\\Kotlin\\2_Code\\KotlinEducation\\src\\main\\kotlin\\syntax\\functions\\function_type\\stdlib_func\\useful_func\\example_3\\TestFile.txt"
    println("\nFirst line: ${readFirstLineFromFile(filePath)}")

    writeToTextFile(filePath, "Some text fom the line #3")
}

// Use 'use' function to execute lambda expression passed in (executes operation with file).
// As a result we get a first line that was read from the file and then resources will be closed
// automatically.
fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br ->
        return br.readLine()
    }
}

fun writeToTextFile(path: String, content: String) {
    BufferedWriter(FileWriter(path)).use { bw ->
        bw.write(content)
    }
}
