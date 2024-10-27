package data.type.standard_type.collection_type.operation.filtering.distinct_operation

/**
 * Methods:
 *      * distinct
 *      * distinctBy
 *          As a parameter receives 'selector function'
 *
 * are used to filter source collection and return a new one with unique items.
 */
fun main() {
    // #1
    val listOfNumber = listOf(1, 11, 1, 22, 1, 33, 1, 44)
    val result_1 = listOfNumber.distinct()
    val result_2 = listOfNumber.distinctBy { it > 20 }

    // #2
    val listOfItem = listOf(
        Item(1, "Apple"),
        Item(2, "Banana"),
        Item(3, "Apple"),
        Item(4, "Orange"),
        Item(5, "Banana"),
        Item(3, "Apple")
    )
    val result_3 = listOfItem.distinct()
    val result_4 = listOfItem.distinctBy { it.name }

    println(
        "Show result of filtering apply to the:" +
        "\n\t'listOfNumber' ('distinct'): $result_1" +
        "\n\t'listOfNumber' ('distinctBy'): $result_2" +
        "\n\t'listOfItem' ('distinct'): $result_3" +
        "\n\t'listOfItem' ('distinctBy'): $result_4"
    )
}

data class Item(val id: Int, val name: String)
