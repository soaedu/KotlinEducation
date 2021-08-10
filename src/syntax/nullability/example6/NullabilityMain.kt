package syntax.nullability.example6

fun main() {
    print("1. ")
    printHashCode1(null)

    print("2. ")
    printHashCode2("null")
}

/**
 * Обязатепыо допжен испопьзоваться безопасный вызов, поскопьку «T» может хранить null
 */
fun <T> printHashCode1(t: T) {
    println("hashCode: ${t?.hashCode()}")
}

/**
 * Объявление верхней границы, не допускающей null, для параметра типа
 *
 * Теперь «Т» не поддерживает null
 */
fun <T:Any> printHashCode2(t: T) {
    println("hashCode: ${t.hashCode()}")
}