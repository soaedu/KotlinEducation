package syntax.functions.type.extension_func.example7

/**
 * Accessing private members
 *  1. In Java you can't call a private member from a static function of another class
 *  2. Kotlin extension functions are regular static functions defined in a separate auxiliary class
 *  3. You can't call private members from extensions
 */
fun main() {

}

fun String.repeat(n: Int): String {
    val sb = StringBuilder(n * length)

    for(i in 1..n) {
        sb.append(this)
    }

    return sb.toString()
}