package syntax.functions.type.lambda_func.example13

/**
 * Возврат из лямбда-выражений: возврат с помощью меток
 */
fun main() {
    print("1. ")
    lookForAlice(people)

    // Выражение "this" с меткой
    print("2. ")
    print(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString())
        }
    })
}

data class Person(val name: String, val age: Int)
val people = listOf(
    Person("Alice", 29),
    Person( "Bob", 31)
)

// Локальный возврат с использованием метки
// #1
/*fun lookForAlice(people: List<Person>) {
    people.forEach label@{                              // Метка для лямбда-выражения
        if (it.name == "Alice") return@label            // return@label ссылается на эту метку
    }
    println("Alice might be somewhere")                 // Эта строка выводится всегда
}*/

// Использование имени функции в роли метки для выражения return
fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") return@forEach
    }

    println("Alice might be somewhere")
}
