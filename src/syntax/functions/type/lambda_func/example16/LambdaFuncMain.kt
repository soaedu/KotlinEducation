package syntax.functions.type.lambda_func.example16

fun main() {
    val people = listOf(
        Person("John Weak", 35, true),
        Person("Jack Nikolson", 42, true),
        Person("Samanta Fox", 19, false),
        Person("Gvinett Peltrow", 54, false)
    )

    // #1
    val filterResult1 = people.map { person ->
        person.takeIf { it.isPublicProfile }?.name
    }.filterNotNull()
    println("1. filterResult1: $filterResult1")

    // #2
    val filterResult2 = people.mapNotNull { person ->
        person.takeIf { it.isPublicProfile }?.name
    }
    println("2. filterResult2: $filterResult2")

    // Working with map
    // #1
    val map1 = mutableMapOf<Int, MutableList<Person>>()
    for (person in people) {
        if (person.age !in map1) {
            map1[person.age] = mutableListOf()
        }
        val group = map1.getValue(person.age)
        group += person
    }
    println("1. map: $map1")

    // #2
    val map2 = mutableMapOf<Int, MutableList<Person>>()
    for (person in people) {
        val group = map2.getOrPut(person.age) { mutableListOf() }
        group += person
    }
    println("2. map: $map2")

}

data class Person(val name: String, val age: Int, val isPublicProfile: Boolean)