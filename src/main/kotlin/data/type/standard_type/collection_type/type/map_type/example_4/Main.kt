package data.type.standard_type.collection_type.type.map_type.example_4

/**
 * Methods of the 'MutableMap' interface available.
 */
fun main() {
    val mutableMap_1: MutableMap<String, Int> = mutableMapOf(
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
        "Show info about 'mutableMap_1':" +
        "\n\tisEmpty: ${mutableMap_1.isEmpty()}" +
        "\n\tsize: ${mutableMap_1.size}" +
        "\n\tkeys: ${mutableMap_1.keys}" +
        "\n\tcontains key '$targetKey_1': ${mutableMap_1.containsKey(targetKey_1)}" +
        "\n\tcontains key '$targetKey_2': ${mutableMap_1.containsKey(targetKey_2)}" +
        "\n\tvalues: ${mutableMap_1.values}" +
        "\n\tcontains value '$targetValue_1': ${mutableMap_1.containsValue(targetValue_1)}" +
        "\n\tcontains value '$targetValue_2': ${mutableMap_1.containsValue(targetValue_2)}"
    )

    // #2
    // Use:
    //      * entries                       - to get objects that provide access to map items (key/value)
    //      * entry.setValue(newValue)      - to change the value of the item.
    print(
        "Show info about each entry of 'mutableMap_1':"
    )
    for (entry in mutableMap_1.entries) {
        print(
            "\n\tentry: $entry"
        )
    }

    // #3
    // Use:
    //      * get(key)/[key]                - to read the value from the map
    //      * getValue(key)                 - to read the value from the map with specified 'key'
    //                                          (if exists or error: NoSuchElementException)
    //      * getOrDefault/getOrElse        - to read the value from the map if exists,
    //                                          if it doesn't, get value/function specified
    //                                          as an alternative.
    println(
        "\nShow result of retrieving from 'mutableMap_1':" +
                "\n\tvalue with existing key '$targetKey_1' (get): ${mutableMap_1.get(targetKey_1)}" +
                "\n\tvalue with not existing key '$targetKey_2' (get): ${mutableMap_1[targetKey_2]}" +
                "\n\tvalue with existing key '$targetKey_1' (getValue): ${mutableMap_1.getValue(targetKey_1)}" +
                // "\n\tvalue with not existing key '$targetKey_2' (getValue): ${mutableMap_1.getValue(targetKey_2)}" +
                "\n\tvalue with existing key '$targetKey_1' (getOrDefault): " +
                "${mutableMap_1.getOrDefault(targetKey_1, "Undefined")}" +
                "\n\tvalue with not existing key '$targetKey_2' (getOrDefault): " +
                "${mutableMap_1.getOrDefault(targetKey_2, "Undefined")}" +
                "\n\tvalue with existing key '$targetKey_1' (getOrElse): " +
                "${mutableMap_1.getOrElse(targetKey_1) { "Undefined"} }" +
                "\n\tvalue with not existing key '$targetKey_2' (getOrElse): " +
                "${mutableMap_1.getOrElse(targetKey_2) { "Undefined"} }"
    )

    // #4
    // Use:
    //      * put(key, value)/
    //          [key] = value/
    //          += value                    - to add or change the 'value' associated
    //                                          with 'key'
    //      * putAll(map)                   - to add collection of objects with type
    //                                          Pair<K, V>
    val targetKey_3 = "six"
    val targetKey_4 = "ten"
    val targetKey_5 = "eleven"
    val targetKey_6 = "twenty"
    val targetKey_7 = "twenty one"
    val targetValue_3 = 6
    val targetValue_4 = 10
    val targetValue_5 = 11
    val targetValue_6 = 20
    val targetValue_7 = 21

    mutableMap_1.put(targetKey_3, targetValue_3)
    mutableMap_1[targetKey_4] = targetValue_4
    mutableMap_1 += (targetKey_5 to targetValue_5)
    val mutableMap_2 = mutableMapOf(
        targetKey_6 to targetValue_6,
        targetKey_7 to targetValue_7
    )
    mutableMap_1.putAll(mutableMap_2)
    println(
        "Show result of multiple 'put' operations performed on the 'mutableMap_1':" +
        "\n\titems: $mutableMap_1"
    )

    // #5
    // Use:
    //      * set(key, value)/[key] = value - to for the element with 'key' value 'value'
    val targetValue_8 = 22
    mutableMap_1.set(targetKey_6, targetValue_7)
    mutableMap_1.set(targetKey_7, targetValue_8)
    println(
        "Show result of 'set' operation performed on the 'mutableMap_1':" +
        "\n\titems: $mutableMap_1"
    )

    // #6
    // Use:
    //      * remove(key)                   - to remove the item with key 'key'
    //      * remove(key, value) /          - to remove the item with key 'key' if it has
    //          -= value                        the value 'value'
    mutableMap_1.remove(targetKey_1)
    mutableMap_1.remove(targetKey_7, targetValue_7)
    mutableMap_1 -= targetKey_2
    println(
        "Show result of multiple 'remove' operations performed on the 'mutableMap_1':" +
        "\n\titems: $mutableMap_1"
    )

    // #7
    // Use:
    //      * clear                     - to remove all elements from the mutable map
    mutableMap_1.clear()
    println(
        "Show result of 'clear' operation performed on the 'mutableMap_1':" +
        "\n\titems: $mutableMap_1"
    )
}
