package syntax.functions.function_type.stdlib_func.example_1.scope_func.example_3

data class Person(
    var id: String,
    var name: String,
    var age: Int,
    var license: License? = null
) {
    fun getPersonDao(): PersonDao? = license?.let { PersonDao(this) }
}

fun Person.getLicense(): License? = license

class PersonDao(val person: Person) {
    fun insert(): Person = person
}
