package data.helpers

fun <T> printItems(header: String = "", list: List<T>) {
    if (header.isNotEmpty())
        println("$header: ")

    for (item in list) {
        println("\t$item")
    }
}
