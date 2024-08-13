package syntax.functions.function_type.closure_func.example_1

fun main() {
    println(
        "Result of looking for:" +
        "\n\tlast name is 'Domingo':${lookForAPerson("Domingo").toString().replace("[", "").replace("]", "")}"
    )
}

class Person(val firstName: String, val lastName: String) {
    override fun toString(): String {
        return  "\n\t\tPerson" +
                "\n\t\t{" +
                "\n\t\t\tfirst name: $firstName" +
                "\n\t\t\tlast name: $lastName" +
                "\n\t\t}"
    }
}

fun loadData(): List<Person> = listOf(
    Person("Michael", "Jordan"),
    Person("Placido", "Domingo"),
    Person("Monica", "Belucci"),
    Person("Angelina", "Joly"),
    Person("Diego", "Maradonna")
)

// #1
// Use 'closure' to find a person or few persons that match
fun lookForAPerson(nameToMatch: String): List<Person> {
    // The 'function literal' passed to the 'filter' method uses the parameter to the outer
    // function. The parameter is defined in an outer scope to the function, so the function is
    // 'closing over' the parameter.
    return loadData().filter {
        it.lastName == nameToMatch
    }
}