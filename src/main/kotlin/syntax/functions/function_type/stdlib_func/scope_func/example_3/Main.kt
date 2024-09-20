package syntax.functions.function_type.stdlib_func.example_1.scope_func.example_3

/**
 * Scope function 'let' has definition in the 'standard library' like this
 *
 * inline fun <T, R> T.let(block: (T) -> R): R {
 *      return block(this)
 * }
 *
 * accepts a lambda that is invoked with the receiver being the instance (where 'let' was called on)
 * represents the 'context object' as the lambda parameter
 * returns the result of lambda
 *
 * Should be used if we need to:
 *      * execute some code on an object before returning some different value
 *      * execute code on a not null value
 *      * convert a 'nullable object' to another 'nullable object'
 *      * limit the scope of a single local variable
 */
fun main() {
    // #1
    val title = "The Robots from Planet X3"
    val newTitle = title
        .removePrefix("The ")
        // .let { titleWithoutPrefix -> "'$titleWithoutPrefix'" }
        .let { "'$it'" }
        .uppercase()

    println(
        "\nShow title: " +
        "\n\tsource: $title" +
        "\n\ttransformed: $newTitle"
    )

    // #2
    val person_1 = Person("234567891", "John Smith", 25, License(125, "John Smith"))
    val person_2 = Person("2345678902", "Will Smith", 35)

    // #3
    // Use 'scope function' to limit the scope of the 'dao' variable to the 'let' block
    val person3: Person? = Person("2345678902", "Gabriel Smith", 45)
        .getPersonDao()?.let { dao ->
            dao.insert()
    }

    println(
        "\nShow info for:" +
        "\n\tperson #1: ${getPersonLicense(person_1)}" +
        "\n\tperson #2: ${getPersonLicense(person_2)}" +
        "\n\tperson #3: $person3"
    )
}

// #2
// Use 'scope function' to:
//      * execute code if 'person' is not null
//      * convert nullable person to nullable 'License'
fun getPersonLicense(
    person: Person?
): License? = person?.let { it.getLicense() }

