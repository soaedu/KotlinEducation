package syntax.functions.type.lambda_func.example8

import syntax.functions.type.lambda_func.example5.Person

fun main() {
    val list = listOf(
            Person("Alice", 25),
            Person("Bob", 35),
            Person("Frank", 15),
            Person("Svetlana", 23)
    )

    println("1. ${list.map { it.name }}")
    println("2. ${list.map(Person::name)}")
    println("3. ${list.filter { it.age < 35 }.map(Person::age).sortedByDescending { it }}")

    /**
     * Этот код повторяет процесс поиска максимального возраста для каждого человека - следовательно, если в коллекции
     * хранится список из 1 00 человек, поиск максимального возраста будет выполнен 100 раз!
     */
    println("4. ${list.filter { it.age == list.maxByOrNull(Person::age)?.age }}")

    /**
     * Тут рассчитывается максимальный возраст только один раз.
     */
    val maxAge = list.maxByOrNull(Person::age)?.age
    println("5. ${list.filter { it.age == maxAge}}")

    /**
     * К словарям также можно применить функции отбора и преобразования:
     *  filterKeys, mapKeys
     *  filterValues, mapValues
     */
    val valuesMap = mapOf(0 to "zero", 1 to "one")
    println("6. ${valuesMap.mapValues { it.value.toUpperCase() }}")
}
