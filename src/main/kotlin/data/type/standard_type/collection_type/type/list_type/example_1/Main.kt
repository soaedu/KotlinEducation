package data.type.standard_type.collection_type.type.list_type.example_1

import data.helpers.printItems

fun main() {
    // Read-only instances
    // #1
    // Use 'List()' to create a read-only list.
    val ints_1 = List(10) { it + 1 }
    // #2
    // Use 'listOf()' to create a read-only list.
    val ints_2: List<Int> = listOf(20, 29, 40, 10)
    // #3
    // Use 'emptyList()' to create a read-only list.
    val emptyList: List<String> = emptyList()
    // #4
    // Use 'listOfNotNull()' to create a read-only list.
    val notNulls: List<String> = listOfNotNull(null, "a", "b", "c")

    // Mutable instances
    // #5
    // Use 'arrayListOf()' to create a mutable list.
    val doubles: ArrayList<Double> = arrayListOf(84.88, 100.25, 999.99)
    // #6
    // Use 'mutableListOf' to create a mutable list.
    val cartoons: MutableList<String> = mutableListOf(
        "Tom&Jerry",
        "Dexter's Laboratory",
        "Johnny Bravo",
        "Cow&Chicken"
    )

    printItems("Int list[${ints_1.javaClass.canonicalName}]", ints_1)
    printItems("Int list[${ints_2.javaClass.canonicalName}]", ints_2)
    printItems("Empty list[${emptyList.javaClass.canonicalName}]", emptyList)
    printItems("Non-Null string list[${notNulls.javaClass.canonicalName}]", notNulls)
    printItems("Double list[${doubles.javaClass.canonicalName}]", doubles)

    printItems("Cartoons list[${cartoons.javaClass.canonicalName}] (#1)", cartoons)
    cartoons.addAll(arrayOf("Ed, Edd n Eddy", "Courage the Cowardly Dog"))
    printItems("Cartoons list[${cartoons.javaClass.canonicalName}] (#2)", cartoons)
}
