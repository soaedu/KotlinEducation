package syntax.functional_programming.function_type.anonymous_func.higher_order_func.example_4

data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilter {
    var startsWith: String = ""
    var withPhoneNumberOnly: Boolean = false

    // Use function of the class that gets one of its predicates
    // basing on the properties check result.
    fun getFilterPredicate(): (Person) -> Boolean {
        val namePredicate = { p: Person ->
            p.firstName.startsWith(startsWith) ||
            p.lastName.startsWith(startsWith)
        }
        val phonePredicate = { p: Person ->
            p.phoneNumber != null
        }

        if (withPhoneNumberOnly)
           return { namePredicate(it) && phonePredicate(it)}
        else
            return namePredicate
    }
}