package syntax.nullability.example7

fun main() {
    print("1. ")
//    yellAt(Person(null))

    print("2. ")
    yellAtSafe(Person(null))
}

/**
 * Получатель метода toUUpperCase() - поле person.name равно null, поэтому будет возбуждено исключение
 */
fun yellAt(person: Person) {
    println(person.name.toUpperCase() + "!!!")
}

fun yellAtSafe(person: Person) {
    println( (person.name ?: "Anyone").toUpperCase() + "!!!")
}
