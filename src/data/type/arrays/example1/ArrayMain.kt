package data.type.arrays

import Utils.printCollection

fun main() {
    onlyJavaWorkingExample()

    val intArray1 = arrayOf(1, 1, 2, 3, 5, 8, 13)

    // boxing type IntArray
    val intArray2 = intArrayOf(1, 1, 2, 3, 5, 8, 13)
    val sqrtItemArray = Array(7) { i -> i*i }

    printCollection(intArray1, "IntArray1")
    println("\nInfo of the \"intArray1\":" +
            "\n\tsize: ${intArray1.size}" +
            "\n\tfirst item: ${intArray1.get(0)}" +
            "\n\tfourth item: ${intArray1[3]}"
    )

    println("\nChange the value of the \"intArray1\" first item to 10...")
    intArray1.set(0, 10)
    println("\nInfo of the \"intArray1\":" +
            "\n\tfirst item: ${intArray1.get(0)}")

    printCollection(intArray2, "IntArray2")

    println("\nArray that has items generated with function:")
    printCollection(sqrtItemArray)
}

// that will work in Java but not in Kotlin
fun onlyJavaWorkingExample() {
    /*
        final String[] oops = {"only", "strings", "here"};
        final Object[] yeah = oops;
        yeah[1] = 42;
    */
}