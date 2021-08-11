package syntax.nullability.example2

fun main() {
    print("1.")
    printAllCaps("abc")

    print("2.")
    printAllCaps(null)
}

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}