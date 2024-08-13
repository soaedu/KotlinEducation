package syntax.functions.function_type.inline_func.example_3

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val path = "E:\\Edu\\Computer_disciplines\\0_Language\\Kotlin\\2_Code\\KotlinEducation\\src\\main\\kotlin\\syntax" +
            "\\functions\\function_type\\inline_func\\example_2\\TextFile.txt"
    println(
        "\nThe size of read data from the file using 'inline' function" +
        "\n\tbefore inlining is: ${characterCountInKilobytes(path)}" +
        "\n\tafter inlining is: ${characterCountInKilobytesExpanded(path)}"
    )
}

// Use regular function to:
//      1. open a file
//      2. read in the text
//      3. count the number of characters
//      4. return size in kilobytes
fun characterCountInKilobytes(
    fileName: String
): Int {
    val input = Files.newInputStream(
        Paths.get(fileName)
    )
    return withResource(
        input,
        {
            input.buffered().reader().readText().length
        },
        { it * 1024 }
    )
}

// #2
// After inlining process the method will look like:
fun characterCountInKilobytesExpanded(
    fileName: String
): Int {
    val input = Files.newInputStream(Paths.get(fileName))
    val size = try {
        input.buffered().reader().readText().length
    } finally {
        input.close()
    }
    val fn: (Int) -> Int = { it * 1024 }
    return fn(size)
}

// Use 'inline' function with 'noinline' keyword for separate argument.
// By adding the 'noinline' annotation, the function will be wrapped in a 'FunctionN' instance
// as normal. The first function, however, is not affected, and is still inlined.
// In the case of an exception, the second function will not be called.
inline fun <T: AutoCloseable, U, V> withResource(
    resource: T,
    before: (T) -> U,
    noinline after: (U) -> V
): V {
    val u = try {
        before(resource)
    } finally {
        resource.close()
    }
    return after(u)
}