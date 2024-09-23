package syntax.operator.type.elvis_operator.example_3

fun main() {
    val address = Address("Elsestr. 47", 80687 , "Munich", "Germany")
    val jetbrains = Company( "JetBrains", address)
    val person = Person( "Dmitry" , jetbrains)

    val person_1 = Person( "Dmitry" , jetbrains)
    val person_2 = Person("Alexey",null)

    print(
        "Show info for: " +
        "\n\tperson_1: $person_1" +
        "\n\tshipping address: "
    )
    printShippingLabel(person_1)

    println(
        "\nShow info for: " +
        "\n\tperson_2: $person_2" +
        "\n\tshipping address: "
    )
    printShippingLabel(person_2)
}

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person(val name: String, val company: Company?) {
    override fun toString(): String {
        return "Person(name='$name')"
    }
}

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with (address) {
        println (streetAddress)
        println("$zipCode $city, $country")
    }
}
