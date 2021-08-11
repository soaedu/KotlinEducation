package syntax.operators.type.elvis_operator.example2

import syntax.nullability.example4.Person

/**
 * Применение оператора <Элвис> для работы с null
 */
fun main() {
    println("1. ${strLenSafe("аЬс")}")
    println("2. ${strLenSafe(null)}")

    val person = Person("Dmitry",null)
    println("3. ${person.countryName()}")
}

fun strLenSafe(s: String?): Int = s?.length ?: 0

fun Person.countryName() =  company?.address?.country?: "Unknown"