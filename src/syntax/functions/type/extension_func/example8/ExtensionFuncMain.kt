package syntax.functions.type.extension_func.example8

/**
 * Formatting multiline strings
 */
fun main() {
    val q1 = """To code,
        or not to code?.."""
    println("1. question:")
    println(q1)

    // Crop standard indent
    val q2 = """To code,
        |or not to code?..""".trimMargin()
    println("2. question:")
    println(q2)

    // Add custom prefix
    val q3 = """To code,
        #or not to code?..""".trimMargin(marginPrefix = "#")
    println("3. question:")
    println(q3)

    val a1 = """
        Keep calm 
        and learn Kotlin""".trimIndent()
    println("4. phrase:")
    println(a1)
}