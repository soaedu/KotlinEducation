package syntax.nullability.example4

/**
 * Объединение нескольких операторов безопасного вызова
 */
fun main() {
    val person = Person("Dmitry",null)
    println(person.countryName())
}

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    val country = this.company?.address?.country
    return if(country != null) country else "Unknown"
}