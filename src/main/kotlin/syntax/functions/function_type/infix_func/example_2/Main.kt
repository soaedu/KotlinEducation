package syntax.functions.function_type.infix_func.example_2

fun main() {
    // #1
    // Call 'Pair' class to link data
    val pair1 = Pair("london", "paris")
    val map1 = mapOf(Pair("London", "UK"), Pair("Bucharest", "Romania"))
    println(
        "\nPrint data for (linked with 'Pair'):" +
                "\n\tpair: $pair1" +
                "\n\tmap: $map1"
    )

    // #2
    // Call 'to' ('infix function' from the standard library).
    val pair2 = "London" to "UK"
    val map2 = mapOf("London" to "UK", "Bucharest" to "Romania")
    println(
        "\nPrint data for (linked with 'to'):" +
                "\n\tpair: $pair2" +
                "\n\tmap: $map2"
    )
}