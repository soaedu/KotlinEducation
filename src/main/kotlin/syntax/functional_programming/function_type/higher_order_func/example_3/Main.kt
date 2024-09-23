package syntax.functional_programming.function_type.anonymous_func.higher_order_func.example_3

fun main() {
    val source = listOf("Alpha", "Beta", "Gama")

    // #1
    println(
        "\nPrint '$source' as string" +
        "\n\tusing default function of data to a string transformation: ${source.joinToString()}"
    )

    // #2
    println(
        "\nPrint '$source' as string" +
        "\n\tusing custom function of data to a string transformation: ${source.joinToString() { it.toLowerCase() }}"
    )

    // #3
    println(
        "\nPrint '$source' as string" +
        "\n\tusing custom function of data to a string transformation: ${source.joinToString(
            separator = "..",
            postfix = "! ",
            // transform = { it.toUpperCase() } 
            transform = null
        )}"
    )
}

// #1
// No transformation function is specified, only default 'toString()' is used.
/*fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        // Transform object to string using default realisation of 'toString()'
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}*/

// #2
// Transformation function is specified and has default value.
/*fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }        // custom transformation function with lambda
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        // Transform object to string using specified transformation function
        result.append(transform(element))
    }

    result.append(postfix)
    return result.toString()
}*/

// #3
// Transformation function is specified, can take function result or 'null'.
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null        // custom transformation function or 'null'
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        val str = transform?.invoke(element) ?: element.toString()

        // Transform object to string using specified transformation function
        result.append(str)
    }

    result.append(postfix)
    return result.toString()
}