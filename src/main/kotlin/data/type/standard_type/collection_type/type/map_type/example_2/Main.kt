package data.type.standard_type.collection_type.type.map_type.example_2

import data.helpers.printItems

fun main() {
    // #1
    // Cast 'map' to 'list' of 'Map.Entry'
    val immutableMap_1: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4
    )
    val listOfMapEntry: List<Map.Entry<String, Int>> = immutableMap_1.entries.toList()
    printItems(
        "Show result of casting 'immutableMap_3' to one list of 'Map.Entry'",
        listOfMapEntry
    )

    // #2
    // Cast 'map' to one 'list' of 'key-value' pairs
    val immutableMap_2: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4
    )
    val listOfMapKeyValue: List<Pair<String, Int>> = immutableMap_2.toList()
    printItems(
        "Show result of casting 'immutableMap_4' to one list of 'key-value' pairs",
        listOfMapKeyValue
    )
}
