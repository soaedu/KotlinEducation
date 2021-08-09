package syntax.type_cast.example3

fun main() {
    val person1 = Person("Dmitriy", "Jemerov")
    val person2 = Person("Dmitriy", "Jemerov")

    println("1. are person1 and person2 equal?: ${person1 == person2}")
    println("2. are person1 and 142 equal?: ${person1.equals(142)}")
}

class Person(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? Person ?: return false

        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}