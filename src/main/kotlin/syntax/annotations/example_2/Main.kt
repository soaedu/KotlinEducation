package syntax.annotations.example_2

/**
 * Due to erasure in the JVM, it is impossible to declare two functions with the same name and the same erased
 * signature.
 * For example, the following declarations in Java would result in a compile error:
 *      public void foo(list: List<String>)
 *      public void foo(list: List<Int>)
 *
 * Erasure is caused by the fact that the JVM does not retain type parameters.
 * This means, among other examples, that variables of List<String> and List<Int> both compile to List<Any>.
 *
 * The most commonly used solution to this problem is to name the methods differently. But sometimes that isn't
 * desirable. In Kotlin, we can retain the same names as long as we provide alternative names for when they are
 * compiled. To do this we annotate the functions using @JvmName with a supplied alternative.
 *
 * At compile time the name supplied to the annotation will be used. We can see this by inspecting the generated
 * bytecode:
 *      public static final void filterStrings(java.util.List<java.lang.String>);
 *      public static final void filterInts(java.util.List<java.lang.Integer>);\
 *
 * When using these functions from Kotlin, we continue to use the original names. The @JvmName annotation is invisible
 * to Kotlin users. The compiler will do the necessary translation for us, but when invoking these functions from Java
 * we use the alternative name.
 *
 * source: Book "Programming Kotlin" (Authors: Stephen Samuel, Stefan Bocutiu)
 */

fun main() {
    val strings = listOf("A", "BC", "DEF", "GHIJ")
    val ints = listOf(1, 3, 5, 7)

    println(
        "filter strings result: ${filter(strings)}" +
        "\n" +
        "filter ints result: ${filter(ints)}"
    )
}

@JvmName("filterStrings")
fun filter (list: List<String>): List<String> {
    return list.filter { it.length >= 3 }
}

@JvmName("filterIntegers")
fun filter (list: List<Int>): List<Int> {
    return list.filter { it >= 3 }
}