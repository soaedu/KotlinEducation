package data.type.standard_type.collection_type.type.array_type.example_5

/**
 * Kotlin supports object destruction (we need to provide an iterator method alongside
 * 'componentN' methods).
 */
fun main() {
    // #1
    val integers_1 = intArrayOf(1, 2, 3, 4, 5, 6)
    val (i11, i12, i13, i14, i15) = integers_1
    println("Show items of 'integers_1' array:" +
            "\n\ti1: $i11" +
            "\n\ti2: $i12" +
            "\n\ti3: $i13" +
            "\n\ti4: $i14" +
            "\n\ti5: $i15"
    )

    // #2
    // Try to deconstruct the array who's length does not match
    // the number of elements used in deconstruction
    // Error: ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    val integers_2 = intArrayOf(1, 2, 3)
    val (i21, i22, i23, i24, i25) = integers_2
    println("Show items of 'integers_2' array:" +
            "\n\ti1: $i21" +
            "\n\ti2: $i22" +
            "\n\ti3: $i23" +
            "\n\ti4: $i24" +
            "\n\ti5: $i25"
    )
}
