package syntax.functions.function_type.stdlib_func.example_1.scope_func.example_4

import syntax.functions.function_type.stdlib_func.example_1.scope_func.example_3.License
import syntax.functions.function_type.stdlib_func.example_1.scope_func.example_3.Person
import syntax.functions.function_type.stdlib_func.example_1.scope_func.example_3.PersonDao
import syntax.functions.function_type.stdlib_func.example_1.scope_func.example_3.getLicense

/**
 * Scope function 'run' has definition in the 'standard library' like this
 *
 * inline fun <T, R> T.run(block: T.() -> R): R {
 *      return block()
 *  }
 *
 * accepts a lambda that is invoked with the receiver being the instance (where 'run' was called on)
 * represents the 'context object' as the 'implicit receiver'
 * returns the result of lambda
 *
 * Should be used if we:
 *      * need to compute some value
 *      * want to limit the scope of multiple local variables
 *      * want to convert 'explicit parameters' to 'implicit receiver'
 */
fun main() {

    // #1
    // Use 'scope function' to define new values for the existing instance of the 'person'.
    val person_1 = Person("234567891", "John Smith", 25, License(125, "John Smith"))
    val license_1 = person_1.run {
        id = "1234567891"
        name = "Joe Smith"
        age = 33
        license = null

        getLicense()
    }
    println(
        "Show person info:" +
        "\n\tperson_1: $person_1" +
        "\n\tlicense_1: $license_1"
    )

    // #2
    // Use 'scope function' in a call chain.
    val title = "The Robots from Planet X3"
    val newTitle = title
        .removePrefix("The ")
        // .singleQuoted()
        .run { "'$this'" }
        .uppercase()
    println(
        "\nShow title: " +
        "\n\tsource: $title" +
        "\n\ttransformed: $newTitle"
    )

    // #3
    // Use 'scope function' to convert 'explicit parameters' to 'implicit receiver'
    val isPersonInserted: Boolean = run {
        val person_2: Person = getPerson()
        val personDao: PersonDao? = person_2.getPersonDao()
        personDao?.insert() != null
    }
    println(
        "\nShow person info:" +
        // "\n\tperson_2: $person_2" +
        // "\n\tpersonDao is not null: ${personDao != null}" +
        "\n\tis person inserted: $isPersonInserted"
    )
}

fun getPerson() = Person(
    "234567891", "John Smith", 25, License(125, "John Smith")
)

