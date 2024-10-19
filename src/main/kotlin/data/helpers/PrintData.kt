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

fun <T> printItems(header: String = "", set: Set<T>) {
    printItems(header, set.toList())
}

fun <K, V> printItems(header: String = "", map: Map<K, V>) {
    if (header.isNotEmpty())
        println("$header: ")

    for (mapEntry in map.entries) {
        println("\tkey: ${mapEntry.key}, value: ${mapEntry.value}")
    }
}
