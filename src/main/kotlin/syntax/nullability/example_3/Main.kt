package syntax.nullability.example_3

fun main() {
    val ceo = Employee("Da Boss",null)
    val developer = Employee("Bob Smith", ceo)

    // #1, 2
    println(
        "Employee manager for:" +
        "\n\tdeveloper is: \t${managerName(developer)}" +
        "\n\tceo is: \t\t${managerName(ceo)}"
    )

    // #3
    val person = Person("Dmitry",null)
    println(
        "\nPerson country: ${person.countryName()}"
    )
}

// #1
// The parameter 'manager' is defined as 'nullable' Employee type.
class Employee(val name: String, val manager: Employee?)

// #2
// The return type of the function is 'nullable' string type.
// Result can be:
//      * null          - if property 'manager' in the instance of the class Employee contains 'null'
//      * string value  - if property 'manager' in the instance of the class Employee contains value
fun managerName(employee: Employee): String? = employee.manager?.name

// #3
class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
// The parameter 'address' is defined as 'nullable' Address type.
class Company(val name: String, val address: Address?)
// The parameter 'company' is defined as 'nullable' Company type.
class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    // Result can be:
    //      * null          - if some oe all properties ('company', 'address' or 'country') contains 'null'
    //      * string text   - if all properties has values.
    val country = this.company?.address?.country
    return if(country != null) country else "Unknown"
}
