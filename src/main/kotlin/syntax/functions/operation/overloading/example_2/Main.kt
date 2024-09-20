package syntax.functions.operation.overloading.example_2

/**
 * Operation 'overloading' represents definition of few functions with the identical name
 * but with different parameters.
 */
fun main() {
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