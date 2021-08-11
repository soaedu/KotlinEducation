package data.type.arrays.example4

fun main() {
    val intArray1 = IntArray(10)
    println("1_1. intArray: ${intArray1.joinToString()}")
    val intArray2 = intArrayOf(1, 2, 4, 5)
    println("1_2. intArray: ${intArray2.joinToString()}")
    val intArray3 = IntArray(3) { i-> (i*2) }
    println("1_3. intArray: ${intArray3.joinToString()}")

    // Существующие массив или коллекцию, хранящие обёртки для значений примитивного типа, можно преобразовать в массив
    // примитивного типа с помощью соответствующей функции - например, toIntArray().
    val intCollection = listOf(10, 20, 30)
    val intArray4 = intCollection.toIntArray()
    println("1_4. intArray: ${intArray4.joinToString()}")

    val booleanArray1 = BooleanArray(10)
    println("\n2_1. booleanArray: ${booleanArray1.joinToString()}")
    val booleanArray2 = booleanArrayOf(true, true, false)
    println("2_2. booleanArray: ${booleanArray2.joinToString()}")
    val booleanArray3 = BooleanArray(2) { i-> (i > 0)}
    println("2_3. booleanArray: ${booleanArray3.joinToString()}")

    val charArray1 = CharArray(10)
    println("\n3_1. charArray: ${charArray1.joinToString()}")
    val charArray2 = charArrayOf('l', 'd', 'z')
    println("3_2. charArray: ${charArray2.joinToString()}")
    val charArray3 = CharArray(5) { i-> ('A' + (i*2))}
    println("3_3. charArray: ${charArray3.joinToString()}")
}
