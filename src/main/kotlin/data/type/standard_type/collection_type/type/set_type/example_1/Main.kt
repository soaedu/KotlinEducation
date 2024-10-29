package data.type.standard_type.collection_type.type.set_type.example_1

import data.helpers.printItems

fun main() {
    // Read-only instances
    // #1
    // Use 'setOf' to create a read-only empty set.
    val setOfNumber_1 = setOf<Int>()
    // #2
    // Use 'setOf' to create a read-only set.
    val setOfNumber_2 = setOf(1, 1, 2, 3, 9, 9, 4)
    // #3
    val emptySet = emptySet<Int>()
    // #4
    val setOfNotNull = setOfNotNull(null, 3, 8, 9, 10)

    // Mutable instances
    // #5
    val setOfNumber_3 = mutableSetOf<Int>()
    // #6
    val setOfNumber_4 = mutableSetOf(1, 1, 2, 3, 9, 9, 4)
    // #7
    val hashSetOfNumber: java.util.HashSet<Int> = hashSetOf(1, 1, 2, 3, 9, 9, 4)
    hashSetOfNumber.add(5)
    // #8
    val sortedSetOfNumber: java.util.TreeSet<Int> = sortedSetOf(11, 0, 9, 11, 9, 8)
    sortedSetOfNumber.add(12)
    // #9
    val linkedSetOfNumber: java.util.LinkedHashSet<Int> = linkedSetOf(1, 1, 2, 3, 9, 9, 4)
    linkedSetOfNumber.add(18)


    printItems(
        "Show info about read-only empty set created with 'setOf':" +
        "\n\tclass name: ${setOfNumber_1.javaClass.canonicalName}",
        setOfNumber_1
    )
    printItems(
        "Show info about read-only set created with 'setOf':" +
        "\n\tclass name: ${setOfNumber_2.javaClass.canonicalName}",
        setOfNumber_2
    )
    printItems(
        "Show info about read-only empty set created with 'emptySet':" +
        "\n\tclass name: ${emptySet.javaClass.canonicalName}",
        emptySet
    )
    printItems(
        "Show info about read-only set without nulls created with 'setOfNotNull':" +
        "\n\tclass name: ${setOfNotNull.javaClass.canonicalName}",
        setOfNotNull
    )
    printItems(
        "Show info about mutable empty set created with 'mutableSetOf':" +
       "\n\tclass name: ${setOfNumber_3.javaClass.canonicalName}",
        setOfNumber_3
    )
    printItems(
        "Show info about mutable set created with 'mutableSetOf':" +
       "\n\tclass name: ${setOfNumber_4.javaClass.canonicalName}",
        setOfNumber_4
    )
    printItems(
        "Show info about mutable set created with 'hashSetOf':" +
       "\n\tclass name: ${hashSetOfNumber.javaClass.canonicalName}",
        hashSetOfNumber
    )
    printItems(
        "Show info about mutable set created with 'sortedSetOf':" +
       "\n\tclass name: ${sortedSetOfNumber.javaClass.canonicalName}",
        sortedSetOfNumber
    )
    printItems(
        "Show info about mutable set created with 'linkedSetOf':" +
       "\n\tclass name: ${linkedSetOfNumber.javaClass.canonicalName}",
        linkedSetOfNumber
    )
}
