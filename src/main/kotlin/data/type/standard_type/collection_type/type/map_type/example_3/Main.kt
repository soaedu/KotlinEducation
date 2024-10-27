package data.type.standard_type.collection_type.type.map_type.example_3

/**
 * Methods of the 'Map' interface available.
 */
fun main() {
    val immutableMap_1: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4
    )
    val targetKey_1 = "three"
    val targetKey_2 = "five"
    val targetValue_1 = 3
    val targetValue_2 = 5

    // #1
    // Use:
    //      * size                          - to check the size of the map
    //      * keys/values                   - to provide fast access to map 'values'
    //      * isEmpty                       - to check if map contains at least one item
    //      * containsKey/containsValue     - to check if map contains definite key nd value
    println(
        "Show info about 'immutableMap':" +
        "\n\tisEmpty: ${immutableMap_1.isEmpty()}" +
        "\n\tsize: ${immutableMap_1.size}" +
        "\n\tkeys: ${immutableMap_1.keys}" +
        "\n\tcontains key '$targetKey_1': ${immutableMap_1.containsKey(targetKey_1)}" +
        "\n\tcontains key '$targetKey_2': ${immutableMap_1.containsKey(targetKey_2)}" +
        "\n\tvalues: ${immutableMap_1.values}" +
        "\n\tcontains value '$targetValue_1': ${immutableMap_1.containsValue(targetValue_1)}" +
        "\n\tcontains value '$targetValue_2': ${immutableMap_1.containsValue(targetValue_2)}"
    )

    // #2
    // Use:
    //      * entries                       - to get objects that provide access to map items (key/value)
    print(
        "Show info about each entry of 'immutableMap' iterating throw key-value pairs"
    )
    for (entry in immutableMap_1.entries) {
        print(
            "\n\tentry: $entry"
        )
    }
    print(
        "\nShow info about each entry of 'immutableMap' unpack during iteration"
    )
    for ((key, value ) in immutableMap_1) {
        print(
            "\n\tkey: $key, value: $value"
        )
    }

    // #3
    // Use:
    //      * map +/- (key to value)        - to create new map with/without specified value
    //      * map +/- Pair || map +/- map   - to create new map with/without values from both maps
    val targetKey_3 = "six"
    val targetKey_4 = "ten"
    val targetKey_5 = "eleven"
    val targetKey_7 = "twenty one"
    val targetValue_3 = 6
    val targetValue_4 = 10
    val targetValue_5 = 11
    val targetValue_6 = 20
    val targetValue_7 = 21
    val immutableMap_2 = immutableMap_1 + (targetKey_3 to targetValue_3)
    val immutableMap_3 = immutableMap_1 + Pair(targetKey_1, targetValue_3)
    println(
        "\nShow all items of them maps after '+' operation apply" +
        "\n\t'immutableMap_1': $immutableMap_1" +
        "\n\t'immutableMap_2': $immutableMap_2" +
        "\n\t'immutableMap_3': $immutableMap_3"
    )
    val immutableMap_4 = immutableMap_1 - targetKey_1
    val immutableMap_5 = immutableMap_1 - listOf(targetKey_2, targetKey_3)
    println(
        "Show all items of them maps after '-' operation apply" +
        "\n\t'immutableMap_1': $immutableMap_1" +
        "\n\t'immutableMap_4': $immutableMap_4" +
        "\n\t'immutableMap_5': $immutableMap_5"
    )
    val immutableMap_6 = mapOf(targetKey_4 to targetValue_4, targetKey_5 to targetValue_5)
    val immutableMap_7 = mapOf(targetKey_1 to targetValue_6, targetKey_7 to targetValue_7)
    val immutableMap_8 = immutableMap_1 + immutableMap_6
    val immutableMap_9 = immutableMap_1 + immutableMap_7
    println(
        "Show all items of the maps after '+' operation apply" +
        "\n\t'immutableMap_6': $immutableMap_6" +
        "\n\t'immutableMap_7': $immutableMap_7" +
        "\n\t'immutableMap_8' (sum of two maps): $immutableMap_8" +
        "\n\t'immutableMap_9' (sum of two maps): $immutableMap_9"
    )

    // #4
    // Use:
    //      * get(key)/[key]                - to read the value from the map
    //      * getValue(key)                 - to read the value from the map with specified 'key'
    //                                          (if exists or error: NoSuchElementException)
    //      * getOrDefault/getOrElse        - to read the value from the map if exists, if it
    //                                          doesn't, get value/function specified as an
    //                                          alternative.
    immutableMap_1.getValue(targetKey_1)
    println(
        "Show result of retrieving from 'immutableMap':" +
        "\n\tvalue with existing key '$targetKey_1' (get): ${immutableMap_1.get(targetKey_1)}" +
        "\n\tvalue with not existing key '$targetKey_2' (get): ${immutableMap_1[targetKey_2]}" +
        "\n\tvalue with existing key '$targetKey_1' (getValue): ${immutableMap_1.getValue(targetKey_1)}" +
        // "\n\tvalue with not existing key '$targetKey_2' (getValue): ${immutableMap_1.getValue(targetKey_2)}" +
        "\n\tvalue with existing key '$targetKey_1' (getOrDefault): " +
                "${immutableMap_1.getOrDefault(targetKey_1, "Undefined")}" +
        "\n\tvalue with not existing key '$targetKey_2' (getOrDefault): " +
                "${immutableMap_1.getOrDefault(targetKey_2, "Undefined")}" +
        "\n\tvalue with existing key '$targetKey_1' (getOrElse): " +
                "${immutableMap_1.getOrElse(targetKey_1) { "Undefined"} }" +
        "\n\tvalue with not existing key '$targetKey_2' (getOrElse): " +
                "${immutableMap_1.getOrElse(targetKey_2) { "Undefined"} }"
    )
}
