package syntax.functional_programming.function_type.anonymous_func.inline_func.example_2

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val path = "E:\\Edu\\Computer_disciplines\\0_Language\\Kotlin\\2_Code\\KotlinEducation\\src\\main\\kotlin\\syntax" +
            "\\functions\\function_type\\inline_func\\example_2\\TextFile.txt"
    println(
        "\nThe size of read data from the file using" +
        "\n\t'regular' function is: ${characterCount(path)}" +
        "\n\t'inline' function is: ${characterCountExpanded(path)}"
    )
}

// #1
// Use regular function to:
//      1. open a file
//      2. read in the text
//      3. count the number of characters
// It uses 'withResource()' to ensure that the input stream is correctly closed if some
// exception was thrown.
fun characterCount(fileName: String): Int {
    val input = Files.newInputStream(
        Paths.get(fileName)
    )
    return withResource(input) {
        input.buffered().reader().readText().length
    }
}

// #2
// After adding 'inline' keyword to 'withResource()' function, the compiler would translate
// an invocation of 'characterCount' into the following:
fun characterCountExpanded(fileName: String): Int {
    val input = Files.newInputStream(Paths.get(fileName))
    try {
        return input.buffered().reader().readText().length
    } finally {
        input.close()
    }
}

// #1
// Use regular 'higher-order' function that handles resources in a safer manner:
// the resource will always be closed correctly, even if the code throws an exception.
// When this code is compiled, will be created an instance of the function argument.
// If code like this was being executed many times in a loop, those allocations would add up.
// A new instance of the function literal was being created before being passed into the
// 'withResource' function.
// In bytecode it will look like:
//      NEW syntax/functions/function_type/inline_func/example_2/MainKt$characterCount$1
/*fun <T: AutoCloseable, U> withResource(
    resource: T,
    fn: (T) -> U
): U {
    try {
        return fn(resource)
    } finally {
        resource.close()
    }
}*/

// #2
// Use 'inline' keyword to inline function body into call side.
inline fun <T: AutoCloseable, U> withResource(
    resource: T,
    fn: (T) -> U
): U {
    try {
        return fn(resource)
    } finally {
        resource.close()
    }
}
