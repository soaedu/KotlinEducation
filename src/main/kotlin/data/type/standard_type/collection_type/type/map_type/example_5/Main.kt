package data.type.standard_type.collection_type.type.map_type.example_5

fun main() {
    // #1
    // Cast immutable map to mutable
    val immutableMap_1: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2
    )
    // impossible
    // immutableMap_1["three"] = 3
    val mutableMap_1: MutableMap<String, Int> = immutableMap_1.toMutableMap()
    mutableMap_1["three"] = 3

    // #2
    // Cast mutable map to immutable
    val mutableMap_2: MutableMap<String, Int> = mutableMapOf(
        "one" to 1,
        "two" to 2
    )
    // possible
    mutableMap_2["three"] = 3
    val immutableMap_2: Map<String, Int> = mutableMap_2.toMap()
    // impossible
    // immutableMap_2["three"] = 3
}
