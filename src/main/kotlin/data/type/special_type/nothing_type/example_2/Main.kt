package data.type.special_type.nothing_type.example_2

import java.lang.IllegalStateException

fun main() {
    val company = Company(null)
    val address = company.address ?: fail("No address")
    print("1. $address")

    print("2.")
    fail("Error occurred")
}

// Use 'Nothing' type to specify that this method
// will never return a value it only throws an error.
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

data class Company(val address: String?)
