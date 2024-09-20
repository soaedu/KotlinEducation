package syntax.functional_programming.operation.reference.example_2

/**
 * Operation 'reference' is used when we want to refer to an existing function and call it.
 *
 * Bound and unbound references.
 */
fun main() {
    // Operation for creating an instance of the 'Person' class is saved into a variable.
    // We save link on a constructor.
    val createPerson = ::Person
    val alice = createPerson("Alice", 29)

    // In Kotlin we can create an 'unbound reference'
    // (since it is not associated with any instance of the class)
    val agePredicate_1 = Person::isOlder

    // In fact, this call is unfolding in:
    val agePredicate_2: (Person, Int) -> Boolean = Person::isOlder

    // The compiler will turn this call into:
    val agePredicate_3: (Person, Int) -> Boolean = { person: Person, age: Int -> person.isOlder(age) }

    println(
        "Show info about " +
        "\n\tAlice: $alice" +
        "\nIs ts older than 29 years? " +
        "\n\tpredicate #1 (unbound reference): ${agePredicate_1(alice, alice.age)}" +
        "\n\tpredicate #2 (unbound reference): ${agePredicate_2(alice, alice.age)}" +
        "\n\tpredicate #3 (unbound reference): ${agePredicate_3(alice, alice.age)}"
    )

    // Also in Kotlin we can create a 'bound reference'
    // (bound to some specific instance of a class)
    val agePredicate_4 = alice::isOlder

    // In fact, this call is unfolding in:
    val agePredicate_5: (Int) -> Boolean = alice::isOlder

    // The compiler will turn this call into:
    val agePredicate_6: (Int) -> Boolean = { age: Int -> alice.isOlder(age)}

    println(
        "\nShow info about " +
        "\n\tAlice: $alice" +
        "\nIs it older than 29 years? " +
        "\n\tpredicate #4 (bound reference): ${agePredicate_4(alice.age)}" +
        "\n\tpredicate #5 (bound reference): ${agePredicate_5(alice.age)}" +
        "\n\tpredicate #6 (bound reference): ${agePredicate_6(alice.age)}"
    )

    println(
        "\nIs Alice older than" +
        "\n\t21 year? : ${alice.getAgePredicate(21).invoke(21)}"
    )

    // Create 'function reference' on an 'extension function' of the 'Person' class.
    val adultPredicate = Person::isAdult
    println(
        "\nIs Alice adult? (unbound reference) : ${adultPredicate(alice)}"
    )
}

class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit

    // fun getAgePredicate() = this::isOlder
    fun getAgePredicate(ageLimit: Int) = ::isOlder

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}

fun Person.isAdult() = age >= 21
