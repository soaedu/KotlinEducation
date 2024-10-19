package data.type.standard_type.collection_type.type.map_type.example_1

import data.helpers.printItems

fun main() {
    // Read-only instances
    // #1
    // Use 'mapOf' to create a read-only empty map.
    val map_1: Map<String, Int> = mapOf()
    // #2
    // Use 'mapOf' to create a read-only map.
    val map_2: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4
    )
    // #3
    // Use 'mapOf' and Pair<String, Int> to create a read-only map.
    val map_3: Map<String, Int> = mapOf(
        Pair("one", 1),
        Pair("two", 2),
        Pair("three", 3),
        Pair("four", 4)
    )

    // Mutable instances
    // #4
    // Use 'mutableMapOf()' to crate a mutable empty map.
    val map_4: MutableMap<String, Int> = mutableMapOf()
    // #5
    // Use 'mutableMapOf()' to create a mutable map.
    val map_5: MutableMap<String, Int> = mutableMapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4
    )
    // #6
    // Use 'hashMapOf()' to create a mutable map.
    val map_6: java.util.HashMap<String, Int> = hashMapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4
    )
    // #7
    // Use 'linkedMapOf()' to create a mutable map.
    val map_7: java.util.LinkedHashMap<String, Int> = linkedMapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4
    )
    // #8
    // Use 'LinkedHashMap' to create a mutable map.
    val map_8: java.util.HashMap<String, Int> = LinkedHashMap()
    map_8["one"] = 1
    map_8["two"] = 2
    map_8["three"] = 3
    map_8["four"] = 4

    // #9
    // Use 'sortedMapOf()' to create a mutable map.
    val map_9: java.util.SortedMap<String, Int> = sortedMapOf(
        "one" to 1,
        "four" to 4,
        "three" to 3,
        "two" to 2
    )

    printItems(
        "Show info about read-only empty map created with 'mapOf':" +
            "\n\tclass name: ${map_1.javaClass.canonicalName}",
        map_1
    )
    printItems(
        "Show info about read-only map created with 'mapOf':" +
            "\n\tclass name: ${map_2.javaClass.canonicalName}",
        map_2
    )
    printItems(
        "Show info about read-only map created with 'mapOf' and initialized with Pair's:" +
            "\n\tclass name: ${map_3.javaClass.canonicalName}",
        map_3
    )
    printItems(
        "Show info about mutable empty map created with 'mutableMapOf':" +
            "\n\tclass name: ${map_4.javaClass.canonicalName}",
        map_4
    )
    printItems(
        "Show info about mutable map created with 'mutableMapOf':" +
            "\n\tclass name: ${map_5.javaClass.canonicalName}",
        map_5
    )
    printItems(
        "Show info about mutable map created with 'hashMapOf':" +
            "\n\tclass name: ${map_6.javaClass.canonicalName}",
        map_6
    )
    printItems(
        "Show info about mutable map created with 'linkedMapOf':" +
            "\n\tclass name: ${map_7.javaClass.canonicalName}",
        map_7
    )
    printItems(
        "Show info about mutable map created with 'LinkedHashMap':" +
            "\n\tclass name: ${map_8.javaClass.canonicalName}",
        map_8
    )
    printItems(
        "Show info about mutable map created with 'sortedMapOf':" +
            "\n\tclass name: ${map_9.javaClass.canonicalName}",
        map_9
    )
}
