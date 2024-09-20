package syntax.functions.function_type.generic_func.example_2

fun main() {
    val integers = listOf(1, 2, 3, 4, 5)
    val strings = listOf("one", "two", "three")

    // #1
    /*val integerMiddleItem = middleItem(integers) as Int
    val stringMiddleItem = middleItem(strings) as String
    */

    // #2
    val integerMiddleItem = middleItem(integers)
    val stringMiddleItem = middleItem(strings)

    println(
        "\nGet the middle item from list with:" +
                "\n\tintegers: $integerMiddleItem" +
                "\n\tstrings: $stringMiddleItem"
    )
}

// #1
// We use type 'Any' to get list of items with any type.
// fun middleItem(list: List<Any>): Any = list[list.size / 2]

// #2
// We use generic type '<T>' to use list of items with any type
// and preserve the type of the result (no need to cast it).
fun <T> middleItem(list: List<T>): T = list[list.size / 2]