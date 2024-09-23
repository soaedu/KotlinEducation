package syntax.functions.parameter.example_1

fun main() {
    // #1
    val str = "a kindness of ravens"

    val result_1 = str.regionMatches(14, "Red Ravens", 4, 6, true)
    val result_2 = str.regionMatches(
        thisOffset = 14,
        other = "Red Ravens",
        otherOffset = 4,
        length = 6,
        ignoreCase = true
    )
    val result_3 = str.endsWith(ignoreCase = true, suffix = "ravens")

    println(
        "Call method without specifying names of parameters (keep defined parameters order): " +
        "\n\t'$str' contains 'ravens' : $result_1" +
        "\n\nCall method specifying names of parameters: " +
        "\n\t'$str' contains 'ravens' : $result_2" +
        "\n\nCall method specifying names of parameters (order of specified parameters can be violated): " +
        "\n\t'$str' ends with 'ravens' : $result_3"
    )

    // #2
    // When calling a function, not all parameters need to be named.
    // The rule is simple: once a parameter has been named, all the following parameters must be named too.
    deleteFiles("*.jpg", recursive = true, ignoreCase = true, deleteDirectories = false)
}

// Function accepts multiple Boolean parameters.
// And without named parameters, it is easy to swap arguments erroneously
fun deleteFiles(
    filePattern: String,
    recursive: Boolean,
    ignoreCase: Boolean,
    deleteDirectories: Boolean
): Unit {
    // do some work here...
}