// #1 no annotation
/*package syntax.annotations.example_1

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)

        result.append(element)
    }
    result.append(postfix)

    return result.toString()
}*/

// #2 with annotation
/*@file: JvmName("StringFunctions")
package syntax.annotations.example_1

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)

        result.append(element)
    }
    result.append(postfix)

    return result.toString()
}*/

// #3 with annotation
@file: JvmName("StringFunctions")
package syntax.annotations.example_1

@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)

        result.append(element)
    }
    result.append(postfix)

    return result.toString()
}
