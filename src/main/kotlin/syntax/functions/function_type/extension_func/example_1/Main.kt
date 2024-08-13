package syntax.functions.function_type.extension_func.example_1

fun main() {
    val dropItemsAmount = 2
    val list = listOf(1,2,3)
    val droppedList = list.drop(dropItemsAmount)
    println("\nThe " +
            "\n\tsource list is: $list" +
            "\n\tlist with dropped $dropItemsAmount items: $droppedList"
    )
}

// The 'extension' function is used to extend List functionality with 'drop items' method.
fun <E> List<E>.drop(k: Int): List<E> {
    val newList = mutableListOf<E>()

    for (index in k .. (size - 1)) {
        newList.add(this[index])
    }

    return newList
}