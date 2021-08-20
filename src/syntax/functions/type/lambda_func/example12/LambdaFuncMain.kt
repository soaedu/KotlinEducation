package syntax.functions.type.lambda_func.example12

/**
 * Инструкции "return" в лямбда-выражениях: выход из вмещающей функции
 */
fun main() {
    lookForAlice(people)
}

data class Person(val name: String, val age: Int)
val people = listOf(
                Person("Alice", 29),
                Person( "Bob", 31)
             )

// Использование return в обычном цикле
// #1
/*fun lookForAlice(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice") {
            println ("Found!")
            return
        }
    }
    println("Alice is not found")           // Функция выведет этот текст, если имя "Alice" не будет
                                            // встречено в коллекции "people"
}*/

// Использование return в лямбда-выражении, передаваемом в вызов forEach
fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return                          // Выполнит выход из функции так же как и в примере выше (#1)
        }
    }

    println("Alice is not found")
}