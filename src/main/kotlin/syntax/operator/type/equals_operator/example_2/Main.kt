package syntax.operator.type.equals_operator.example_2

fun main() {
    val person_1 = Person("John", 25)
    val person_2 = Person("John", 25)
    val person_3 = person_1

    println(
        "Show result of:" +
        "\n\tperson_1 == person_2 (equality): ${person_1 == person_2}" +
        "\n\tperson_1 == person_3 (equality): ${person_1 == person_3}" +
        "\n\tperson_1 === person_2 (reference equality): ${person_1 === person_2}" +
        "\n\tperson_1 === person_3 (reference equality): ${person_1 === person_3}"
    )
}

class Person(name: String, age: Int)