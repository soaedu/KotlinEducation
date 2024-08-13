package syntax.functions.function_type.local_func.example_2

fun main() {
    val x = 10
    val y = 20
    fizzBuzz(x, y)
}

// #1
// Solution without using 'local function(s)'
/*fun fizzBuzz(start: Int, end: Int) {
    for (k in start..end) {
        print("$k: ")
        if (k % 3 == 0 && k % 5 == 0)
            println("Fizz Buzz")
        else if (k % 3 == 0)
            println("Fizz")
        else if (k % 5 == 0)
            println("Buzz")
        else
            println(k)
    }
}*/

// #2
// Use two 'local functions' defined outside the 'for' loop and use them in the 'if-else'.
// Parameter 'k' is passed into the 'local functions' from the 'for loop' as an argument.
/*fun fizzBuzz(start: Int, end: Int): Unit {
    fun isFizz(k: Int): Boolean = k % 3 == 0
    fun isBuzz(k: Int): Boolean = k % 5 == 0

    for (k in start..end) {
        print("$k: ")
        if (isFizz(k) && isBuzz(k))
            println("Fizz Buzz")
        else if (isFizz(k))
            println("Fizz")
        else if (isBuzz(k))
            println("Buzz")
        else
            println(k)
    }
}*/

// #3
// Use two 'local functions' defined inside the 'for' loop and use them in the 'if-else'.
// Parameter 'k' is used directly in the 'local functions'.
/*fun fizzBuzz(start: Int, end: Int): Unit {
    for (k in start..end) {
        print("$k: ")

        fun isFizz(): Boolean = k % 3 == 0
        fun isBuzz(): Boolean = k % 5 == 0

        if (isFizz() && isBuzz())
            println("Fizz Buzz")
        else if (isFizz())
            println("Fizz")
        else if (isBuzz())
            println("Buzz")
        else
            println(k)
    }
}*/

// #4
// Use two 'local functions' defined inside the 'for' loop and use them in the 'when'.
// Parameter 'k' is used directly in the 'local functions'.
fun fizzBuzz(start: Int, end: Int): Unit {
    for (k in start..end) {
        print("$k: ")

        fun isFizz(): Boolean = k % 3 == 0
        fun isBuzz(): Boolean = k % 5 == 0

        when {
            isFizz() && isBuzz() -> println("Fizz Buzz")
            isFizz() -> println("Fizz")
            isBuzz() -> println("Buzz")
            else -> println(k)
        }
    }
}
