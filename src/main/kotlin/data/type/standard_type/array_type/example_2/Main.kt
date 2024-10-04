package data.type.standard_type.array_type.example_2

import data.helpers.printItems

fun main() {
    // #1
    // Use 'BooleanArray' to create an array
    val booleans_1 = BooleanArray(3)
    printItems("Show 'booleans_1' items", booleans_1.toTypedArray())
    val booleans_2 = BooleanArray(3) { i -> if (i%2 == 0) true else false }
    printItems("Show 'booleans_2' items", booleans_2.toTypedArray())
    val booleans_3 = booleanArrayOf(true, false, true)
    printItems("Show 'booleans_3' items", booleans_3.toTypedArray())

    // Use 'ByteArray' to create an array
    val bytes = ByteArray(3)
    printItems("Show 'bytes' items", bytes.toTypedArray())

    // Use 'CharArray' to create an array
    val chars_1 = CharArray(3)
    printItems("Show 'chars' items", chars_1.toTypedArray())
    val chars_2 = CharArray(3) { i-> ('A' + (i*2))}
    printItems("Show 'chars' items", chars_2.toTypedArray())
    val chars_3 = charArrayOf('A', 'C', 'E')
    printItems("Show 'booleans_3' items", chars_3.toTypedArray())

    // Use 'DoubleArray' to create an array
    val doubles = DoubleArray(3)
    printItems("Show 'doubles' items", doubles.toTypedArray())

    // Use 'FloatArray' to create an array
    val floats = FloatArray(3)
    printItems("Show 'floats' items", floats.toTypedArray())

    // Use 'IntArray' to create an array
    val ints_1 = IntArray(3)
    printItems("Show 'ints_1' items", ints_1.toTypedArray())
    val ints_2 = listOf(1, 2, 3)
    printItems("Show 'ints_2' items", ints_2.toIntArray())

    // Use 'LongArray' to create an array
    val longs = LongArray(3)
    printItems("Show 'longs' items", longs.toTypedArray())

    // Use 'ShortArray' to create an array
    val shorts = ShortArray(3)
    printItems("Show 'shorts' items", shorts.toTypedArray())

    // Use 'Array' to create an array
    val letters = Array<String>(26) { i-> ('a' + i).toString()}
    printItems("Show 'letters' items", letters)
}
