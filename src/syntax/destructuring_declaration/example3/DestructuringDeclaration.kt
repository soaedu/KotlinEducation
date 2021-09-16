package syntax.destructuring_declaration.example3

/**
 * Iterating over list with index
 */
fun main() {
    val list = listOf(1, 2, 3, 4)

    println("1. ")
    for ((index, element) in list.withIndex()) {
        println("\t$index, $element")
    }

    println("2. ")
    for (indexedValue in list.withIndex()) {
        val index = indexedValue.component1()
        val element = indexedValue.component2()
        println("\t$index, $element")
    }
}