package data.helpers

fun printItems(header: String = "", array: IntArray) {
    printItems(header, array.toList())
}

fun <T> printItems(header: String = "", list: List<T>) {
    if (header.isNotEmpty())
        println("$header: ")

    for (item in list) {
        println("\t$item")
    }
}

fun <T> printItems(header: String = "", array: Array<T>) {
    printItems(header, array.toList())
}
