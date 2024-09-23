package syntax.functions.parameter.example_3

fun main(args: Array<String>) {
    val prefixStr = "Start"
    val suffixStr = "End"

    // Print few strings using method with parameter:
    //  * type 'vararg'
    multiPrint_1("a", "b", "c")
    multiPrint_1(prefixStr, "a", "b", "c")

    // Print few strings using method with parameters:
    //  * positional 'prefix',
    //  * type 'vararg'
    multiPrint_2(prefixStr, "a", "b", "c")

    // Print few strings using method with parameters:
    //  * positional 'prefix',
    //  * type 'vararg',
    //  * named 'suffix'
    multiPrint_3(prefixStr, "a", "b", "c", suffix = suffixStr)

    // Print few strings using 'spread operator' to pass values from array 'strings'
    // to parameter with type 'vararg'
    val strings = arrayOf("a", "b", "c", "d", "e")
    multiPrint_3(prefixStr, *strings, suffix = suffixStr)
}

fun multiPrint_1(vararg strings: String) {
    println()
    for (string in strings)
        println(string)
}


// Functions can have regular parameters, and at most one parameter marked as "vararg":
fun multiPrint_2(prefix: String, vararg strings: String) {
    println("\n$prefix")
    for (string in strings)
        println(string)
}

// The "vararg" parameter is usually the last parameter, but it does not always have to be.
// If there are other parameters after 'vararg', then arguments must be passed in using
// 'named parameters'.
fun multiPrint_3(prefix: String, vararg strings: String, suffix: String): Unit {
    println("\n$prefix")
    for (string in strings)
        println(string)
    println(suffix)
}
