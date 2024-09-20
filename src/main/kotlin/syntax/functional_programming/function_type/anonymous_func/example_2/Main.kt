package syntax.functional_programming.function_type.anonymous_func.example_2

fun main() {
    // #1
    // Call function that contains 'anonymous' function and 'return' from it.
    println(
        "\nLooking for The John.."
    )
    lookForAlice(people)

    // #2
    // Call function than contains 'anonymous' function in the 'filter()' function.
    println(
        "\nFilter people younger than 30: " +
        "\n\t${filterPeopleYoungerThan(30)}"
    )


}

val people = listOf(
    Person("Alice", 29),
    Person( "Bob", 31),
    Person( "John", 38),
)

data class Person(val name: String, val age: Int)

fun filterPeopleYoungerThan(age: Int) = people.filter(fun(person) = person.age < age )
fun lookForAlice(people: List<Person>) {
    people.forEach(
        fun (person) {
            if (person.name == "John") {
                println("\tJohn is found!")
                return
            }
            println("\t${person.name} is not John")
        }
    )
}