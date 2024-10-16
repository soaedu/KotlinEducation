package data.type.standard_type.collection_type.type.list_type.example_2

import data.helpers.printItems
import src.data.type.standard_type.collection_type.type.list_type.example_2.CollectionUtils

fun main() {
    // Hack list with casting (do changes in the 'immutable' list)
    // #1
    // Cast 'ints_1' with type 'List<Int>' to 'ArrayList' and set new value for the first item.
    val ints_1 = List(10) { it + 1 }
    (ints_1 as java.util.ArrayList)[0] = 9999
    // #2
    // Cast 'doubles' with type 'List<Double>' to Collection<Double> and add on more item
    val ints_2 = listOf(20, 29, 40, 10)
    // Call produces an error: Exception in thread "main" java.lang.UnsupportedOperationException
    // CollectionUtils.addItem(ints_2)
    // #3
    val strings_1 = listOf("a", "b", "c")
    // Use 'strings_1' with type 'List<String>' and call Java method, passing reference on the
    // 'immutable list' to uppercase all items anyway changing them.
    CollectionUtils.uppercaseAll(strings_1)

    // #4
    // Cast 'notNulls' with type 'List<Int>' to 'ArrayList' and add two items more.
    val notNulls: List<String> = listOfNotNull(null, "a", "b", "c")
    (notNulls as java.util.ArrayList).addAll(arrayOf("x", "y"))

    // Convert a list to a different collection types
    val chars_1 = listOf('a', 'd', 'c', 'd', 'a')
    // #4
    // Cast 'chars' with type 'List<String>' to 'Array<Char>'
    val array_1: Array<Char> = chars_1.toTypedArray()
    // #5
    // Cast 'chars' with type 'List<String>' to 'CharArray'
    val chars_2: CharArray = chars_1.toCharArray()
    // #6
    // Cast 'chars' with type 'List<String>' to 'Set<Char>'
    val chars_3: Set<Char> = chars_1.toSet()
    // #7
    // Cast 'chars' with type 'List<String>' to 'MutableList<Char>'
    val chars_4: MutableList<Char> = chars_1.toMutableList()

    printItems("Int list[${ints_1.javaClass.canonicalName}]", ints_1)
    printItems("String list[${strings_1.javaClass.canonicalName}]", strings_1)
    printItems("Non-Null string list[${notNulls.javaClass.canonicalName}]", notNulls)
    printItems("Array[${array_1.javaClass.canonicalName}]", array_1)
    printItems("Char array[${chars_2.javaClass.canonicalName}]", chars_2.toTypedArray())
    printItems("Char array[${chars_3.javaClass.canonicalName}]", chars_3)
    printItems("Char list[${chars_4.javaClass.canonicalName}]", chars_4)
}
