package syntax.functions.type.anonymous_func.example1

/**
 * Анонимные функции: по умолчанию возврат выполняется локально.
 *
 * Несмотря на то, что анонимная функция выглядит как объявление обычной функции, в действительности она - лишь
 * другая синтаксическая форма лямбда-выражения. Правила реализации лямбда-выражений и их встраивания во встраиваемых
 * функциях точно так же действуют для анонимных функций.
 */
fun main() {
    print("1. ")
    lookForAlice(people)

    // Использование анонимной функции в вызове filter
    println("2. people who is younger than 30-year: ${people.filter(fun (people: Person): Boolean {
                            return people.age < 30
                        })}")

    // Использование анонимной функции с телом-выражением
    println("3. people who is younger than 30-year: ${people.filter(fun (person) = person.age < 30)}")
}

data class Person(val name: String, val age: Int)
val people = listOf(
    Person("Alice", 29),
    Person( "Bob", 31),
    Person( "John", 38),
)

// Использование return в анонимных функциях
fun lookForAlice(people: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}