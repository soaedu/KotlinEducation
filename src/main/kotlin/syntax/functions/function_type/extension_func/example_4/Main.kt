package syntax.functions.function_type.extension_func.example_4

fun main() {
    // #1
    val mappings = Mappings()
    // Available member function
    mappings.add("string_1")
    // Not available 'extension function'
    // mappings.stringAdd()

    // #2
    val str = "Kotlin"
    // Call the 'extension' function.
    println("Last character of the $str is: ${str.lastChar()}")
}

// #1
class Mappings {
    private val map = hashMapOf<Int, String>()

    // The 'extension' function is declared usually at the top level,
    // but here we define it inside class as member to limit the scope
    // of an extension.
    private fun String.stringAdd(): Unit {
        // "extension receiver" - String instance
        map.put(hashCode(), this)

        // "dispatch receiver" - "Mappings" instance.
        map.put(this@Mappings.hashCode(), this)
    }

    fun add(str: String): Unit = str.stringAdd()
}