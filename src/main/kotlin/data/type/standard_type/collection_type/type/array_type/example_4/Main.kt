package data.type.standard_type.collection_type.type.array_type.example_4

import data.helpers.printItems
import java.util.*

/**
 * The 'standard library' provides quite a few methods that allows us to convert an array
 * to a different collection type.
 *
 * These methods are extension methods covering all the array type classes.
 */
fun main() {
    val longs = longArrayOf(1, 2, 1, 2, 3, 4, 5)

    // #1
    val set: Set<Long> = longs.toSet()
    printItems("Show values from 'longs' array transformed to 'Set'", set)

    // #2
    val hashSet: HashSet<Long> = longs.toHashSet()
    printItems("Show values from 'longs' array transformed to 'HashSet'", hashSet)

    // #3
    val sortedSet: SortedSet<Long> = longs.toSortedSet()
    printItems("Show values from 'longs' array transformed to 'SortedSet'", sortedSet)

    // #4
    val mutableSet = longs.toMutableSet()
    mutableSet.add(10)
    printItems("Show values from 'longs' array transformed to 'MutableSet'", mutableSet)

    // #5
    val list: List<Long> = longs.toList()
    printItems("Show values from 'longs' array transformed to 'List'", list)

    // #6
    val mutableList: MutableList<Long> = longs.toMutableList()
    mutableList.add(20)
    printItems("Show values from 'longs' array transformed to 'MutableList'", mutableList)
}
