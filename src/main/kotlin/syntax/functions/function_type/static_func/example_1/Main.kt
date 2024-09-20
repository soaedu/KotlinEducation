package syntax.functions.function_type.static_func.example_1

fun main() {
    // #1
    // Call 'static method' in the companion object of the enclosing 'Person' class
    Person.callStatic()
    // Call 'non-static method' in the companion object of the enclosing 'Person' class
    Person.callNonStatic()
    // Call 'non-static method' in the 'Person' class
    Person.callNonStatic()

    println()

    // #2
    // Call 'static method' in the object 'Deposit'
    Deposit.callStatic()
    // Call 'non-static method' in the object 'Deposit'
    Deposit.callNonStatic()

    println()

    // #3
    ChatBot.greet("Johny")
}

// #1
data class Person(
    val id: String,
    val name: String,
    val age: Int
) {
    companion object {
        @JvmStatic fun callStatic() { println("Person:Companion:callStatic()") }
        fun callNonStatic() { println("Person:Companion:callNonStatic()") }
    }

    fun callNonStatic() { println("Person:callNonStatic()") }
}

// #2
object Deposit {
    @JvmStatic fun callStatic() { println("Deposit:Companion:callStatic()") }
    fun callNonStatic() { println("Deposit:Companion:callNonStatic()") }
}

// #3
interface ChatBot {
    companion object {
        @JvmStatic fun greet(userName: String) {
            println("Hello, $userName")
        }
    }
}