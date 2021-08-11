package syntax.operators.type.elvis_operator.example3

/**
 * Использование оператора throw с оператором <Элвис>
 */
fun main() {
    val address = Address("Elsestr. 47", 80687 , "Munich", "Germany")
    val jetbrains = Company( "JetBrains", address)
    val person = Person( "Dmitry" , jetbrains)

    print("1. ")
    printShippingLabel(person)

    print("2. ")
    printShippingLabel(Person("Alexey",null))
}

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?)

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with (address) {
        println (streetAddress)
        println("$zipCode $city, $country")
    }
}
