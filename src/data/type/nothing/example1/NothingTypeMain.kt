package data.type.nothing.example1

import java.lang.IllegalStateException

fun main() {
    val company = Company(null)
    val address = company.address ?: fail("No address")
    print("1. $address")

    print("2.")
    fail("Error occurred")
}

fun fail(message: String) : Nothing {
    throw IllegalStateException(message)
}

data class Company(val address: String?)