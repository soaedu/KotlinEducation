package data.type.standard_type.array_type.example_3

fun main() {
    val ints = intArrayOf(1, 2, 3)

    // #1
    // Use:
    //      * 'iterator' to move throw the array
    //      * 'size' to check size of the array
    //      * 'get'/[] to read the value from the array
    //      * 'set' to write the value to the array
    var index = 0
    print("Show 'ints' items: ")
    while(ints.iterator().hasNext() && (index <= ints.size-1)) {
        val value = ints.get(index)

        if (index %2 == 0) ints.set(index, (value*value))

        print("\n\titem[$index]: ${ints[index++]}")
    }

    // #2
    // Use 'forEachIndexed' to print items of the array
    print("\n\nShow 'ints' items: ")
    ints.forEachIndexed { index, element ->
        print("\n\titem[$index]: $element")
    }
}
