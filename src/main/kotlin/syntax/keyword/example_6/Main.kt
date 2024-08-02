package syntax.keyword.example_6

fun main() {
    val number1 = 3
    val number2 = 5
    val number3 = 10

    // #1
    println("\nThe sum of $number1 and $number2 is: ${addTwoNumbers(number1, number2)}")

    // #2
    println("\nThe largest number of $number1, $number2 and $number3 is: ${largestNumber(number1, number2, number3)}")

    // #3
    println()
    printLessThanTwo()

    // #4, #5
    println()
    printUntilStop()
}

// #1
// The 'return' keyword is used to return the value or expression from a function.
fun addTwoNumbers(a: Int, b: Int): Int {
    return a + b
}

// #2
// The 'return' keyword is used to return value from the innermost function only.
// By default, "return" returns from the nearest "enclosing function" or "anonymous function".
fun largestNumber(a: Int, b: Int, c: Int): Int {
    fun largest(a: Int, b: Int): Int {
        if (a > b) return a
        else return b
    }

    return largest(largest(a, b), largest(b, c))
}

// #3
// The 'return' keyword is used to return from the 'anonymous' function and continue work of
// the outer function.
fun printLessThanTwo() {
    val list = listOf(1, 2, 3, 4)
    list.forEach(fun(x) {
        if (x < 2) println(x)
        else return
    })

    println("This line will still execute")
}

// #4
// The 'return' keyword is used with an explicit label 'stop@' to break the cycle and return
// the control to the outer function.
/*fun printUntilStop() {
    val list = listOf("a", "b", "stop", "c")
    list.forEach stop@ {
        if (it == "stop") return@stop
        else println(it)
    }
}*/

// #5
// The 'return' keyword is used with an implicit label 'stop@' to break the cycle and return
// the control to the outer function.
fun printUntilStop() {
    val list = listOf("a", "b", "stop", "c")
    list.forEach {
        if (it == "stop") return@forEach
        else println(it)
    }
}

