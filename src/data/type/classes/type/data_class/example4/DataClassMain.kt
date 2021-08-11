package data.type.classes.type.data_class.example4

fun main() {
    val persons = listOf(Person("Alice"),
                         Person("Bob", age = 29))
    val oldest = persons.maxByOrNull { it.age ?: 0 }
    println("The oldest is: $oldest")
}