package syntax.functions.operation.example_1

/**
 * Operation 'overloading' represents definition of few functions with the identical name
 * but with different parameters.
 */
fun main() {
    // #1
    println(
        "call method #1: \t${printString("test")}" +
        "\ncall method #2: \t${printString("test", 25)}" +
        "\ncall method #3: \t${printString("test", toUpperCase = true)}" +
        "\ncall method #4: \t${printString("test", number = 33, toUpperCase = true)}"
    )

    // #2
    val sum_1 = sum(1, 2)
    val sum_2 = sum(1.5, 2.5)
    val sum_3 = sum(1, 2, 3)
    val sum_4 = sum(2, 1.5)
    val sum_5 = sum(1.5, 2)

    // Compiler automatically will take the right function, looking on type and amount
    // of parameters.
    println(
        "\nShow result of:" +
                "\n\t1 + 2 = $sum_1" +
                "\n\t1.5 + 2.5 = $sum_2" +
                "\n\t1 + 2 + 3 = $sum_3" +
                "\n\t2 + 1.5 = $sum_4" +
                "\n\t1.5 + 2 = $sum_5"
    )
}

// #1
// Five Java methods can be represented by one in Kotlin
fun printString(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
    return (if (toUpperCase) name.toUpperCase() else name) + number
}

// #2
// Parameters of overloaded functions can differ by amount, type or order in the parameter list.

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum(a: Double, b: Double): Double {
    return a + b
}

fun sum(a: Int, b: Int, c: Int): Int{
    return a + b + c
}

fun sum(a: Int, b: Double): Double{
    return a + b
}

fun sum(a: Double, b: Int): Double{
    return a + b
}

// Have to be careful with return type, compiler doesn't consider it on 'overloading'
/*fun sum(a: Double, b: Int): String {        // error: Conflicting overloads.
    return "$a + $b"
}*/