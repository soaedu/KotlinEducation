package syntax.nullability.example5

fun main() {
    val str1 = "ABC"
    println("1. call with $str1: ${ignoreNulls(str1)}")

    val str2 = null
    println("2. call with $str2: ${ignoreNulls(str2)}")
}

fun ignoreNulls(s: String?): Int {
    val sNotNull: String = s!!
    return sNotNull.length
}