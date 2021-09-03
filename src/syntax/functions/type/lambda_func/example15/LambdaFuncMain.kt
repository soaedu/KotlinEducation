package syntax.functions.type.lambda_func.example15

/**
 * Связанные и несвязанные ссылки.
 */
fun main() {
    val alice = Person("Alice", 29)

    // В Kotlin можно создать несвязанную ссылку (т.к. она не связана с каким-либо экземпляром класса)
    val agePredicate1 = Person::isOlder
    // Фактически этот вызов разворачивается в:
    //      val agePredicate1: (Person, Int) -> Boolean = Person::isOlder
    // Компилятор превратит этот вызов в:
    //      val agePredicate1: (Person, Int) -> Boolean = { person, ageLimit -> person.isOlder(ageLimit) }
    println("1. Alice is older: ${agePredicate1(alice, 21)}")

    // Также в Kotlin можно создать связанную ссылку (связанную с каким-то конкретным экземпляром класса)
    val agePredicate2 = alice::isOlder
    // Фактически этот вызов разворачивается в:
    //      val agePredicate2: (Int) -> Boolean = alice::isOlder
    // Компилятор превратит этот вызов в:
    //      val agePredicate2: (Int) -> Boolean = { ageLimit -> alice.isOlder(ageLimit) }
    println("2. Alice is older: ${agePredicate2(21)}")
    println("3. Alice is older: ${alice.getAgePredicate(21)}")
}

class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit

    // fun getAgePredicate() = this::isOlder
    fun getAgePredicate(ageLimit: Int) = ::isOlder
}
