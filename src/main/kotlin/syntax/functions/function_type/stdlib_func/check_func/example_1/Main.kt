package syntax.functions.function_type.stdlib_func.check_func.example_1

fun main() {
    // #1
    println(
        "Get square for values:" +
                "\n\t16: ${squareRoot(16)}" // +
        /*"\n\t0: ${squareRoot(0)}" +
        "\n\t-16: ${squareRoot(-16)}"*/
    )

    // #2
    val person = Person(
        /*firstName = "",
        lastName = "",
        age = -20*/
        firstName = "Michael",
        lastName = "Jackson",
        age = null
    )
    println(
        "Person info:" +
                "\n\tfirstName: ${person.firstName}" +
                "\n\tlastName: ${person.lastName}" +
                "\n\tage: ${person.age}"
    )
}

// #1
// The 'require' keyword is used to set precondition and throw an
// exception if it will not pass.
// 'Exception in thread "main" java.lang.IllegalArgumentException: Failed requirement.'
fun squareRoot(k: Int): Int {
    require(k >= 0)
    return Math.sqrt(k.toDouble()).toInt()
}

// #2
// The 'require' keyword is used to check values on the 'init' block and throw an exception with
// predefined message if it will not pass.
class Person (
    val firstName: String,
    val lastName: String,
    val age: Int?
){
    init{
        require(firstName.trim().length > 0) { "Invalid firstName argument." }
        require(lastName.trim().length > 0) { "Invalid lastName argument." }
        if (age != null) {
            require(age >= 0 && age < 150) { "Invalid age argument." }
        }
    }
}