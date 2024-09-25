package data.type.special_type.unit_type.example_2

fun main() {
    // Use 'Unit' type in chain of calls (fluent interface)
    Person()
        .setName("John")
        .setAge(25)
        .introduce()
}

class Person {
    private var name: String = ""
    private var age: Int = 0

    fun setName(name: String): Person {
        this.name = name
        return this
    }

    fun setAge(age: Int): Person {
        this.age = age
        return this
    }

    // Use 'Unit' type to only do a side effect, printing person data.
    fun introduce(): Unit {
        println("Name: $name, Age: $age")
    }
}
