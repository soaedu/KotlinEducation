package syntax.operator.type.elvis_operator.example_2

fun main() {
    with(Person("John Smith", 36)) {
        println(
            "Show person info:" +
            "\n\tname: $name" +
            "\n\tage: $age" +
            "\n\tcountry: ${strSafe(country)}"
        )
    }
}

class Person(val name: String, val age: Int, val country: String? = null) {
    override fun toString(): String {
        return "Person(name=$name, age=$age, country=$country)"
    }
}

fun strSafe(s: String?): String = s ?: "Unknown"
