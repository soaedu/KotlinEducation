package syntax.functions.return_type.example_1

fun main() {
    // #1
    val salute = hello()
    println()
    checkAge(-15)
    checkAge(15)

    // #2
    val sum_1 = sum(4, 3)
    val sum_2 = sum(5, 6)
    val sum_3 = sum(6, 9)
    println(
        "Show result of the:" +
        "\n\tsum #1: $sum_1" +
        "\n\tsum #2: $sum_2" +
        "\n\tsum #3: $sum_3"
    )
}

// #1
// If function doesn't return any result, implicitly it returns value of type 'Unit'.
fun hello(): Unit {
    println("Hello")
}
fun checkAge(age: Int): Unit {
    if (age !in 0..110) {
        println("Invalid age: $age")
        return
    }
    println("Age is valid: $age")
}


// #2
// Use function that returns sum of two numbers of type 'Int'.
fun sum(a:Int, b:Int): Int {
    return a + b
}
